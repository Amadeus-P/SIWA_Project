package com.main.web.siwa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
// 프로젝트 생성후  최초 실행시 DB 연결이 안되어 있으면 DB 연결 없이 실행하기 
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class SiwaProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiwaProjectApplication.class, args);
    }

}
