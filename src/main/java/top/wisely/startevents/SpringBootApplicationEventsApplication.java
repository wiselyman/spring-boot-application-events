package top.wisely.startevents;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootApplicationEventsApplication {

	public static void main(String[] args) {

//		SpringApplication application = new SpringApplication(StartEventsApplication.class);
//		application.addListeners(
//				(ApplicationListener<ApplicationStartingEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//				(ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//				(ApplicationListener<ApplicationContextInitializedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//				(ApplicationListener<ApplicationPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//				(ApplicationListener<ApplicationStartedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//				(ApplicationListener<ApplicationReadyEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName())
//		);
//		application.run(args);

//		new SpringApplicationBuilder()
//				.sources(StartEventsApplication.class)
//				.listeners(
//						(ApplicationListener<ApplicationStartingEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//						(ApplicationListener<ApplicationEnvironmentPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//						(ApplicationListener<ApplicationContextInitializedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//						(ApplicationListener<ApplicationPreparedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//						(ApplicationListener<ApplicationStartedEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName()),
//						(ApplicationListener<ApplicationReadyEvent>) event -> log.info("----------- 监听Spring Boot:" + event.getClass().getSimpleName())
//						)
//				.run(args);

		SpringApplication.run(SpringBootApplicationEventsApplication.class, args);
	}



}

