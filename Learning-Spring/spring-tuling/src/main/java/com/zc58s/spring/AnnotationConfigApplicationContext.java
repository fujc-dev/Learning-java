package com.zc58s.spring;

import com.zc58s.spring.annotation.Autowired;
import com.zc58s.spring.annotation.Component;
import com.zc58s.spring.annotation.ComponentScan;
import com.zc58s.spring.annotation.Scope;
import com.zc58s.spring.enums.ScopeType;
import com.zc58s.spring.exceptions.BeanNameNotFindException;

import javax.annotation.PostConstruct;
import java.beans.Introspector;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/9/6 9:54
 */
public class AnnotationConfigApplicationContext {

    /**
     * 配置类
     */
    private Class configClass;

    /**
     * 存放扫描到的Bean定义
     */
    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();

    /**
     * 存放单例的Bean对象
     */
    private Map<String, Object> singletonObjects = new HashMap<String, Object>();

    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<BeanPostProcessor>();

    public AnnotationConfigApplicationContext() {

    }

    /**
     * @param configClass
     */
    public AnnotationConfigApplicationContext(Class configClass) {
        this.configClass = configClass;
        // 扫描
        doScan(configClass);
        // 将单例的Bean存储到缓存中
        for (Map.Entry<String, BeanDefinition> definitionEntry : beanDefinitionMap.entrySet()) {
            String beanName = definitionEntry.getKey();
            BeanDefinition beanDefinition = definitionEntry.getValue();
            if (beanDefinition.getScope() == ScopeType.singleton) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }

    }

    private void doScan(Class configClass) {
        if (configClass.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String scanPath = componentScan.value();
            scanPath = scanPath.replace(".", "/");
            System.out.println("当前需要扫描的包地址：" + scanPath);
            //
            ClassLoader classLoader = AnnotationConfigApplicationContext.class.getClassLoader();
            URL resource = classLoader.getResource(scanPath);
            File classFile = new File(resource.getFile());
            if (classFile.isDirectory()) {
                for (File f : classFile.listFiles()) {
                    String absolutePath = f.getAbsolutePath();
                    absolutePath = absolutePath.substring(absolutePath.indexOf("com"), absolutePath.indexOf(".class"));
                    absolutePath = absolutePath.replace("\\", ".");
                    //System.out.println(absolutePath);
                    try {
                        Class clazz = classLoader.loadClass(absolutePath);
                        //检测类包含Component注解，表示这个类是一个Bean
                        if (clazz.isAnnotationPresent(Component.class)) {
                            //检测bean是否有扩展，BeanPostProcessor
                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor processor = (BeanPostProcessor) clazz.getConstructor().newInstance();
                                beanPostProcessorList.add(processor);
                            } else {
                                Component componentAnnotation = (Component) clazz.getAnnotation(Component.class);
                                String beanName = componentAnnotation.value();
                                if ("".equals(beanName) || beanName.length() == 0) {
                                    beanName = Introspector.decapitalize(clazz.getSimpleName());
                                }
                                BeanDefinition beanDefinition = new BeanDefinition();
                                beanDefinition.setType(clazz);
                                //检测类包含Scope注解，如果没有检测到Scope注解，默认为单例
                                if (clazz.isAnnotationPresent(Scope.class)) {
                                    Scope scopeAnnotation = (Scope) clazz.getAnnotation(Scope.class);
                                    beanDefinition.setScope(scopeAnnotation.value());
                                } else
                                    beanDefinition.setScope(ScopeType.singleton);
                                beanDefinitionMap.put(beanName, beanDefinition);
                            }
                            //System.out.println(clazz);
                        }
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    /**
     * 获取Bean对象
     *
     * @param beanName
     * @return
     */
    public Object getBean(String beanName) throws BeanNameNotFindException {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new BeanNameNotFindException("未找到有效的BeanName：" + beanName);
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition.getScope() == ScopeType.prototype) {
            //原型
            Object bean = createBean(beanName, beanDefinition);
            return bean;
        } else {
            //单例Bean
            Object bean = singletonObjects.get(beanName);
            //为了避免Bean创建有先后，徐建检测当前bean是否存在，不存在重新创建一次
            if (bean == null) {
                bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
            return bean;
        }
    }

    /**
     * 创建具体的Bean的地方
     *
     * @param beanName
     * @param beanDefinition
     * @return
     */
    private Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class beanClass = beanDefinition.getType();

        Object instance = null;
        try {
            //创建Bean的具体步骤
            //1、通过构造函数创建对象实例，也就是申请内存
            instance = beanClass.getConstructor().newInstance();
            //2、属性赋值，依赖注入
            //检测当前对象那些属性包含Autowired注解
            for (Field f : beanClass.getDeclaredFields()) {
                if (f.isAnnotationPresent(Autowired.class)) {
                    f.setAccessible(true);
                    //属性赋值，要去容器集合中去找
                    f.set(instance, getBean(f.getName()));
                }
            }
            //3、Aware接口

            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            //4、@PostConstruct
            //Bean初始化前执行的方法
            for (BeanPostProcessor processor : beanPostProcessorList) {
                //
                processor.postProcessBeforeInitialization(instance, beanName);
                //instance = processor.postProcessBeforeInitialization(instance, beanName);
            }

            //5、Initializing Bean接口，初始化动作
            if (instance instanceof InitializingBean) {
                InitializingBean initializingBean = (InitializingBean) instance;
                initializingBean.afterPropertiesSet();
            }
            //6、aop
            //Bean初始化后执行的方法
            for (BeanPostProcessor processor : beanPostProcessorList) {
                //processor.postProcessAfterInitialization(instance, beanName);
                instance = processor.postProcessAfterInitialization(instance, beanName);
            }
            //完成Bean创建


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (BeanNameNotFindException e) {
            e.printStackTrace();
        }
        return instance;
    }

}
