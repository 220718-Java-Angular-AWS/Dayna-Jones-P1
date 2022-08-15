package com.revature.servlets;
import com.revature.services.DatasourceService;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
    public class DependencyLoaderListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            DatasourceService.getConnection();
            System.out.println("Servlet content has been Initialized!");
        }
        @Override
        public void contextDestroyed(ServletContextEvent sce) {

        }
    }
}
