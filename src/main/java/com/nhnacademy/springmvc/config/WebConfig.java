package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.controller.ControllerBase;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Spring 에서 registry 라는 이름이 붙으면 저걸 통해서 뭘 등록할 떄 쓰는 양식같은 거라고 보면 된다.
        registry.addViewController("/").setViewName("index");

        // /version1/xxx    ->    /version2/aaa/xxx
        registry.addRedirectViewController("/ver1/xxx", "ver2/aaa/xxx");

        registry.addViewController("/user2/register").setViewName("userRegister");
        registry.addViewController("/post2/register").setViewName("postRegister");
    }
}
