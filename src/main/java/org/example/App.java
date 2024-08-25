package org.example;

import org.example.config.AppConfig;
import org.example.dao.StudentDAO;
import org.example.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring data jpa app
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "=======================================" );
        System.out.println( "Spring data jpa app started" );
        System.out.println( "=======================================" );

        AnnotationConfigApplicationContext container = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDAO studentDAO = container.getBean("studentDAO", StudentDAO.class);

        Student student = Student
                .builder()
                .name("Marzuk Islam")
                .email("marzuk.dev@gmail.com")
                .address("105.098.2.22")
                .build();
        studentDAO.saveStudent(student);

        System.out.println(studentDAO.findAllStudents());

        System.out.println(studentDAO.getById(1L));
    }
}
