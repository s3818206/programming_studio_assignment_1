package app;

import io.javalin.Javalin;
import io.javalin.core.util.RouteOverviewPlugin;


public class App {

    public static final int         JAVALIN_PORT    = 7000;
    public static final String      CSS_DIR         = "css/";
    public static final String      IMAGES_DIR      = "images/";
    public static final String      JS_DIR         = "js/";

    public static void main(String[] args) {
     
        Javalin app = Javalin.create(config -> {
            config.registerPlugin(new RouteOverviewPlugin("/help/routes")); 
            config.addStaticFiles(CSS_DIR);
            config.addStaticFiles(JS_DIR);
            config.addStaticFiles(IMAGES_DIR);

            // config.addStaticFiles(IMAGES_DIR);
        }).start(JAVALIN_PORT);

        configureRoutes(app);
    } 

    public static void configureRoutes(Javalin app) {
        
        
        // ADD ALL OF YOUR WEBPAGES with GET Method HERE
        app.get("/", new PageIndex());
        app.get("/about-us", new PageAboutUs());
        app.get("/dashboard", new PageDashboard());
        app.get("/dashboard_s2b", new PageDashboard_s2b());
        app.get("/dashboard_s3a", new PageDashboard_s3a());
        app.get("/dashboard_s3b", new PageDashboard_s3b());

        app.get("/news", new PageNews());
        app.get("/contact", new PageContact());
        
        // POST pages can accept form data
        app.post("/", new PageIndex());
        app.post("/dashboard", new PageDashboard());
        app.post("/dashboard_s2b", new PageDashboard_s2b());
        app.post("/dashboard_s3a", new PageDashboard_s3a());
        app.post("/dashboard_s3b", new PageDashboard_s3b());
        app.post("/contact", new PageContact());
        app.post("/news", new PageNews());
    }
}