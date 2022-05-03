package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.controller.ControllerBase;
import com.nhnacademy.springmvc.interceptor.MeasuringInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = ControllerBase.class)
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/view/", ".jsp");
    }

    // TODO #1: `LocaleResolver` 설정
    @Bean
    public LocaleResolver localeResolver() {
        // Locale.KOREAN == new Locale("ko")
        // Locale 이 Fix 라서 에러남 -> not fixed (cookie | session) 을 써야 함
        // return new FixedLocaleResolver(Locale.KOREAN);

        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setCookieName("bbung");

        return clr;
    }

    // TODO #2: `LocaleChangeInterceptor` 추가
    //         `locale`이라는 파라미터로 전달된 값으로 locale을 변경.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleChangeInterceptor());
        registry.addInterceptor(new MeasuringInterceptor());
    }

}
