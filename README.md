# Spring MVC

## What is `DefaultServlet`

`DispatcherServlet` 이 `DefaultServlet` 이다.  
Spring MVC 에서는 정적 리소스(CSS, images, JS(?)) 처리하는 서블릿도 `DispatcherServlet` 이 처리한다.  
어떻게 하느냐? 톰캣에 넘겨요.

핵심은 **빠지는 요청 없이** 모든 요청을 DispatcherServlet 이 한다.  
전에는 **.do** 만 처리한다. 이런 식과 달리 **모든 요청** 담당

```xml
<servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/</url-pattern>
</servlet-mapping>
```

`DispatcherServlet` 을 믿고, `Controller` 만 작성하면 되도록.

## Root ApplicationContext

서블릿이 아닌 것들에서 처리해야 하는 것들, 예를 들어 DB Connection 이나 리소스 번들 같은 것들.

## Application vs. WebApplicationContext

> `WebApplicationContext` = `ApplicationContext` + `ServletContext`

