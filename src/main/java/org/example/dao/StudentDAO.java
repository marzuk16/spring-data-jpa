package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.entity.Student;
import org.example.entity.Student_;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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

    public Student getById(Long id){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        Root<Student> root = criteriaQuery.from(Student.class);
        Predicate equalId = criteriaBuilder.equal(root.get(Student_.studentId), id);
        criteriaQuery.where(equalId);

        TypedQuery<Student> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }
}
