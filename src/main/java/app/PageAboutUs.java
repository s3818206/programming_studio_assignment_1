package app;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageAboutUs implements Handler  {
    private static final String TEMPLATE = ("aboutUs.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Member> members = jdbc.getMembers();
        model.put("members", members);
      
        // TODO: Your work for Thymeleaf and JDBC
        


        // No code below this
        context.render(TEMPLATE, model);
    }
}
