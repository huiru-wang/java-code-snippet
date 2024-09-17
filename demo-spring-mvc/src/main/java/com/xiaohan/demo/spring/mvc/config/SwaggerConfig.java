package com.xiaohan.demo.spring.mvc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.oas.annotations.EnableOpenApi;

@Configuration
@EnableWebMvc
@EnableOpenApi
public class SwaggerConfig {
}
