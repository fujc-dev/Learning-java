####  责任链
```text
    1、有多个对象共同对一个任务进行处理；
    2、这些对象使用链式存储结构，形成一个链，每个对象知道自己的下一个对象；
    3、一个对象对任务进行处理，可以添加一些操作后将对象传递到下一个任务，也可以在此对象上处理任务并，结束任务链；
    4、客户端赋值组装链式结构，但是客户端不需要关心最终是谁来处理了任务。
```
#### 类结构图
```text
1、一个抽象者角色，定义一个处理请求接口。
2、具体的矗立着橘色，具体的处理者接收到请求后可以选择将请求处理掉，或者将请求传递给下一个处理者。
```

#### 常见应用场景
```text
1、多条件流程判断，复杂的if else处理；
2、ERP系统的审批流程，报账的审批，部门负责人、机构负责人、财务、出纳等等。
3、最常见的ActionFilter。比如：在java过滤器中，客户端发送请求到服务器，会经过参数过滤，session过滤，表单过滤，检测请求头过滤等等。
```


####  网关权限控制案例
```text
 在微服务中，网关作为微服务程序的入口，拦截客户端所有的请求实现权限控制，比如：先判断api接口限流、黑名单、用户会话，参数过滤等等。

API接口限流 --> 黑名单拦截 --> 用户会话 ---> 参数过滤
```

####   Context
```java
public class Context {
    public static GatewayHandler getHandler() {
        //首先构建第一个链
        GatewayHandler currentLimitHandler = new CurrentLimitHandler();
        GatewayHandler blackListHandler  = new BlacklistHandler();
        //后续依次设置一步链
        currentLimitHandler.setNext(blackListHandler);
        GatewayHandler conversationHandler  = new ConversationHandler();
        blackListHandler.setNext(conversationHandler);
        return currentLimitHandler;
    }
}
```

#### 总结
```text
    
```


