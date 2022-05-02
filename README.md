# Spring MVC

RootConfig      ->      Root ApplicationContext  
WebConfig       ->      Servlet ApplicationContext

Root ApplicationContext  
    DB connection bean

    Servlet ApplicationContext - `DispactcherServlet`  
        DB connection bean (x, 못 봐요 그래서 위에 둔다)

filter      ㅡ       servlet
