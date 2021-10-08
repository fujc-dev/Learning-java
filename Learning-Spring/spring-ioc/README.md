# Getting Started

### 代码的方式加载Bean.xml配置
```text
	BeanFactory container3 = new XmlBeanFactory(new ClassPathResource("配置文件路径"));
	ApplicationContext container = new ClassPathXmlApplicationContext("配置文件路径");
	ApplicationContext container2 = new FileSystemXmlApplicationContext("配置文件路径");
```

