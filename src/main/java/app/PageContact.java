package app;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageContact implements Handler  {
    private static final String TEMPLATE = ("contact.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        JDBCConnection jdbc = new JDBCConnection();
        
    
        // TODO: Your work to render with Thymeleaf and JDBC works here
     
    

        // No code below this

        context.render(TEMPLATE, model);
    }
}
