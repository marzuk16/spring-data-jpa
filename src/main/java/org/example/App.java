package org.example;

import org.example.config.AppConfig;
import org.example.dao.StudentDAO;
import org.example.entity.Student;
import org.example.service.ProductService;
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
        container.registerShutdownHook();
        StudentDAO studentDAO = container.getBean("studentDAO", StudentDAO.class);
        ProductService productService = container.getBean("productService", ProductService.class);

//        saveStudent(studentDAO);
        saveProduct(productService);

        container.close();
    }

    private static void saveStudent(StudentDAO studentDAO){
        Student student = Student
                .builder()
                .name("Marzuk Islam")
                .email("marzuk.dev@gmail.com")
                .address("105.098.2.22")
                .build();
        studentDAO.saveStudent(student);

        System.out.println(studentDAO.findAllStudents());

        System.out.println(studentDAO.getById(2L));
    }

    private static void saveProduct(ProductService productService){
        productService.saveProduct();
    }
}
