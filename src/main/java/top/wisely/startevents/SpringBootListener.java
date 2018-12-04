package top.wisely.startevents;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SpringBootListener {
    @EventListener
    public  void handleEvent(ApplicationStartedEvent event){
        log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName());
    }
    @EventListener
    public  void handleEvent(ApplicationReadyEvent event){
        log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName());
    }
}
