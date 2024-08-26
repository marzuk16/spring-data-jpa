package org.example.reflection;

import lombok.extern.slf4j.Slf4j;
import org.example.entity.Student;

import java.util.Arrays;

@Slf4j
public class ReflectionAPI {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> studentClassInfo = Class.forName("org.example.entity.Student");
//        Class<Student> studentClassInfo = Student.class;
//        Student student = new Student();
//        Class<Student> studentClassInfo = student.getClass();
        Student studentObjUsingReflection = (Student) studentClassInfo.newInstance();
        System.out.println("========= printing Annotations: ===========");
        Arrays.stream(studentClassInfo.getAnnotations()).forEach(System.out::println); // It does not give u a Lombok annotations.

        System.out.println("========= printing Constructors: ===========");
        Arrays.stream(studentClassInfo.getConstructors()).forEach(System.out::println);

        System.out.println("========= printing Methods: ===========");
        Arrays.stream(studentClassInfo.getMethods()).forEach(System.out::println);

    }
}
