### 1. Spring Boot特有的应用事件

除了Spring框架的事件，Spring Boot的`SpringApplication`也发送了一些自己的事件：

1. `ApplicationStartingEvent`:在任何处理(除了注册`listener`和`initializer`)开始之前发送。
2. `ApplicationEnvironmentPreparedEvent`: 在`context`创建之前，而用到`context`中的`Environment`已经被识别时发送。
3. `ApplicationContextInitializedEvent`: `SpringApplication`正在启动，`ApplicationContext`已准备好且`ApplicationContextInitializer`已被调用但是bean的定义还没有被加载时发送。
4. `ApplicationPreparedEvent`: 在`context`刷新之前，在bean的定义已经被加载之后调用。
5. `ApplicationStartedEvent`: 在任何应用和`command-line runner`调用之前，而`context`已经被刷新时发送。
6. `ApplicationReadyEvent`: 在任何应用和`command-line runner`被调用的时候发送，它意味着应用可以接受请求了。
7. `ApplicationFailedEvent`: 在启动时有异常的时候发送。

有些事件是在`ApplicationContext`创建之前触发的，所以我们不能用常规的注册成bean的事件监听方式：

1. 注解了`@EventListener`注解分方法的类注册的bean；
2. 实现了`ApplicationListener<Event>`接口的类注册的bean。

像`ApplicationStartedEvent`和`ApplicationReadyEvent`是`ApplicationContext`创建之后触发的，可以用上述两种方式来监听事件。

### 2. 如何监听这些事件

我们可以通过下面的方式注册监听：

#### 1. `SpringApplication.addListeners(...)`

``` java
SpringApplication application = new SpringApplication(StartEventsApplication.class);
application.addListeners(
        (ApplicationListener<ApplicationStartingEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
        (ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
        (ApplicationListener<ApplicationContextInitializedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
        (ApplicationListener<ApplicationPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
        (ApplicationListener<ApplicationStartedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
        (ApplicationListener<ApplicationReadyEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName())
);
application.run(args);

```

#### 2. `SpringApplicationBuilder.listeners(...)`

`src/main/resources/META-INF/spring.factories`下：

``` java
new SpringApplicationBuilder()
            .sources(StartEventsApplication.class)
            .listeners(
                    (ApplicationListener<ApplicationStartingEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
                    (ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
                    (ApplicationListener<ApplicationContextInitializedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
                    (ApplicationListener<ApplicationPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
                    (ApplicationListener<ApplicationStartedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
                    (ApplicationListener<ApplicationReadyEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName())
                    )
            .run(args);

```

#### 3. `META-INF/spring.factories`

```
org.springframework.context.ApplicationListener=top.wisely.startevents.listeners.ApplicationContextInitializedEventListener, \
                                                top.wisely.startevents.listeners.ApplicationEnvironmentPreparedEventListener, \
                                                top.wisely.startevents.listeners.ApplicationPreparedEventListener, \
                                                top.wisely.startevents.listeners.ApplicationReadyEventListener, \
                                                top.wisely.startevents.listeners.ApplicationStartedEventListener, \
                                                top.wisely.startevents.listeners.ApplicationStartingEventListener
```

监听器只需实现`ApplicationListener<要监听的接口类型>`接口，无需手动注册为bean:

``` java
public class ApplicationStartedEventListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName());
    }
}
```