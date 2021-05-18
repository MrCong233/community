package com.nowcoder.community;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//该注解表示该类是一个配置文件，一般用于程序的入口
//MapperScan用于声明扫描mapper包的包名
//@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@MapperScan("com.nowcoder.community.dao")
@SpringBootApplication
public class CommunityApplication {
	//启动tomcat，自动创建Spring容器，自动扫面bin，然后装配到容器里，
	public static void main(String[] args) {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
