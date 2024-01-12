package app;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageDashboard implements Handler  {
    private static final String TEMPLATE = ("dashboard.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        JDBCConnection jdbc = new JDBCConnection();
        
    
        // TODO: Your work for Thymeleaf and JDBC

        
    

        // No code below this

        context.render(TEMPLATE, model);
    }
}
