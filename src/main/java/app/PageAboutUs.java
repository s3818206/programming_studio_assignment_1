package app;

import java.util.HashMap;
import java.util.Map;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageAboutUs implements Handler  {
    private static final String TEMPLATE = ("aboutUs.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        // JDBCConnection jdbc = new JDBCConnection();
        // ArrayList<Member> members = jdbc.getMembers();
        // for (Member member : members) {
        //     System.out.println("\t" + member.getName() + ": " + member.getStudentId());
        // }
        
    
        // TODO: Your work for Thymeleaf and JDBC

        
    

        // No code below this

        context.render(TEMPLATE, model);
    }
}
