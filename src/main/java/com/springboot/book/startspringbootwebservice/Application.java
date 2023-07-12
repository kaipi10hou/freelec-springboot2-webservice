package com.springboot.book.startspringbootwebservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication //스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정 / 프로젝트 최상단 위치해야함!!
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
