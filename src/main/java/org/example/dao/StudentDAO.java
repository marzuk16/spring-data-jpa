package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class StudentDAO {

    /**
     * use following code block while not using SPRING DATA JPA
     */
//    @PersistenceContext(unitName = "postgresPU")
//    private EntityManager em;

    /**
     * use DI when use SPRING DATA JPA
     */
    private final EntityManager em;

    @Transactional
    public void saveStudent(Student student) {
        em.persist(student);
        System.out.println("====================== Student Inserted. =======================");
    }

    public List<Student> findAllStudents(){
        TypedQuery<Student> query = em.createQuery("from Student", Student.class);
        List<Student> students = query.getResultList();

        System.out.println("====================== Fetched All ( " + students.size() + " ) Students. =======================");
        return students;
    }
}
