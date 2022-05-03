package com.nhnacademy.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class MeasuringInterceptor implements HandlerInterceptor {
    // private final StopWatch stopWatch = new StopWatch();

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        // 공유되는 이슈가 있음
        // stopWatch.start();

        // UNIX epoch time: e.g. 42341243324
        request.setAttribute("timestamp", System.currentTimeMillis());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        // stopWatch.stop();
        long before = (long) request.getAttribute("timestamp");
        long elapsed = System.currentTimeMillis() - before;
        log.info("elapsed={}", elapsed);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {
    }
}
