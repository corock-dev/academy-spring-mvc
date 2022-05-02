package com.nhnacademy.springmvc;

import com.nhnacademy.springmvc.config.RootConfig;
import com.nhnacademy.springmvc.config.WebConfig;
import javax.servlet.Filter;
import org.springframework.core.annotation.Order;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 목적: web.xml 을 없애고 싶다!
 * web.xml 에 있었던 servlet-mapping
 */
@Order(2)
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebConfig.class };
    }

    // @Override
    // protected Filter[] getServletFilters() {
    //     CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    //     characterEncodingFilter.setEncoding("UTF-8");
    //     characterEncodingFilter.setForceEncoding(true);
    //
    //     HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
    //
    //     return new Filter[] {
    //         characterEncodingFilter,
    //         hiddenHttpMethodFilter
    //     };
    // }
}
