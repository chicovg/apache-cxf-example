package edu.lionuniversity;

import edu.lionuniversity.services.CourseCatalogImpl;
import https.lionuniversity_edu.wsdl.courses_wsdl.CourseCatalog;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import java.util.logging.Logger;

public class Server {

    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());

    public static void main(String[] args) {
        // init service implementation
        CourseCatalog courseCatalog = new CourseCatalogImpl();

        // create JaxWS server
        JaxWsServerFactoryBean serverFactory = new JaxWsServerFactoryBean();
        serverFactory.setServiceClass(CourseCatalog.class);
        serverFactory.setAddress("http://localhost:8080/coursecatalog");
        serverFactory.setServiceBean(courseCatalog);

        // start it up!
        serverFactory.create().start();

        LOGGER.info("Course catalog server is running!");
    }
}
