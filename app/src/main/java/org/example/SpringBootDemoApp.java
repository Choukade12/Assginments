package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.ServletWebServerInitializedEvent;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableAutoConfiguration

public class SpringBootDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoApp.class,args);
    }
    @EventListener(ServletWebServerInitializedEvent.class)
    public void handleApplicationStartEvent(ServletWebServerInitializedEvent event) {
        int applicationRunningPort = event.getWebServer().getPort();
        System.out.println("Application started");
        System.out.println("Use swagger url: http://localhost:" + applicationRunningPort+"/swagger-ui.html");
    }
}
