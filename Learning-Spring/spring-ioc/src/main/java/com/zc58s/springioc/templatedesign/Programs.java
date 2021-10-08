package com.zc58s.springioc.templatedesign;

import com.zc58s.springioc.templatedesign.group.JDNetMall;

/**
 * 模板模式的业务场景可能在平时的开发中并不是很多，主要是因为这个设计模式会在抽象类中定义逻辑行为的执行顺序。<br/>
 * 一般情况下，我们用的抽象类定义的逻辑行为都是比较轻量级或者没有，只是提供一些基本的方法公共调用和实现。<br/>
 * <br/>
 * 在当前模拟的场景中，需要实现的三步：模拟登录、爬取信息、生成海报。<br/>
 *
 * @author : fjc.dane@gmail.com
 * @createtime : 2021/8/11 9:48
 */
public class Programs {
    public static void main(String[] args) {

        /**
         * 测试链接
         * 京东：https://item.jd.com/100008348542.html
         * 当当网：http://product.dangdang.com/1509704171.html
         *
         *
         */
        NetMall netMall = new JDNetMall("1000001", "*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        System.out.println("测试结果：" + base64);

        /**
         * 总结：
         * 1、通过上面的实现，可以看出模板模式在定义统一结构也就是执行标准上非常方便，
         * 也就很好的控制了后续的实现者不用关心调用逻辑，按照统一的方式执行。那么类的
         * 继承者只需要关心具体的业务逻辑实现即可。
         *2、模板模式也是为了解决子类通用方法，放到类中中设计的优化。让每一个子类只做
         * 子类需要完成的内容，而不需要关系其他逻辑。这样提取公用代码，行为由父类管理，
         * 扩展可变部分，也就非常有利于开发扩展和迭代。
         *
         */
    }
}
