package com.sobchuk.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.util.Arrays;

import static java.util.Collections.singletonList;

@SpringBootApplication
@EnableJpaAuditing
public class ForumApplication {

    public ForumApplication(FreeMarkerConfigurer freeMarkerConfigurer) {
        freeMarkerConfigurer.getTaglibFactory().setClasspathTlds(singletonList("/META-INF/spring-form.tld"));

    }

    public static void main(String[] args) {
        SpringApplication.run(ForumApplication.class, args);
    }

}
