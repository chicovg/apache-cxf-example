package edu.lionuniversity.services;

import https.lionuniversity_edu.wsdl.courses_wsdl.CourseCatalog;
import https.lionuniversity_edu.wsdl.courses_wsdl.CourseCatalogFault;
import https.lionuniversity_edu.xsd.courses.CourseData;
import https.lionuniversity_edu.xsd.courses.Courses;
import https.lionuniversity_edu.xsd.courses.ObjectFactory;

import javax.xml.ws.Holder;
import java.util.logging.Logger;

import static java.util.logging.Level.INFO;

public class CourseCatalogImpl implements CourseCatalog {

    private static final Logger LOGGER = Logger.getLogger(CourseCatalogImpl.class.getName());

    private final Courses courses;

    public CourseCatalogImpl() {
        courses = new ObjectFactory().createCourses();
    }

    @Override
    public Courses getAllCourses() throws CourseCatalogFault {
        return courses;
    }

    @Override
    public void addNewCourse(Holder<CourseData> body) throws CourseCatalogFault {
        CourseData courseData = body.value;
        LOGGER.log(INFO, "Adding new course named: {0}", courseData.getCourseName());

        courses.getCourseData().add(body.value);
    }
}
