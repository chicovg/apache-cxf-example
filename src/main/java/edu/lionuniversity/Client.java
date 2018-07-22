package edu.lionuniversity;

import https.lionuniversity_edu.wsdl.courses_wsdl.CourseCatalog;
import https.lionuniversity_edu.wsdl.courses_wsdl.CourseCatalogFault;
import https.lionuniversity_edu.xsd.courses.CourseData;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import javax.xml.ws.Holder;
import java.math.BigDecimal;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class Client {

    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    public static void main(String[] args) throws CourseCatalogFault {
        // create a proxy to server
        JaxWsProxyFactoryBean proxyFactoryBean = new JaxWsProxyFactoryBean();
        proxyFactoryBean.setServiceClass(CourseCatalog.class);
        proxyFactoryBean.setAddress("http://localhost:8080/coursecatalog");

        // create client
        CourseCatalog client = proxyFactoryBean.create(CourseCatalog.class);

        CourseData data = new CourseData();
        data.setCourseId(new BigDecimal(1));
        data.setCourseName("OOO Programming 101");
        data.setSectionId(new BigDecimal(1));

        int totalCourses = client.getAllCourses().getCourseData().size();
        LOGGER.log(INFO, "There are {0} courses in the catalog", totalCourses);

        client.addNewCourse(new Holder<>(data));

        totalCourses = client.getAllCourses().getCourseData().size();
        LOGGER.log(INFO, "There are {0} courses in the catalog", totalCourses);
    }
}
