package com.nhnacademy.springmvc.config;

import com.nhnacademy.springmvc.Base;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

// stereo type bean
// @Controller
// @Service
// @Repository
// @Component

@Configuration
@ComponentScan(// basePackages = "com.nhnacademy.springmvc",
    basePackageClasses = Base.class,
    // includeFilters =
    excludeFilters = {@ComponentScan.Filter(Controller.class)})
public class RootConfig {
}
