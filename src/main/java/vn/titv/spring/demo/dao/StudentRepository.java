package vn.titv.spring.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.titv.spring.demo.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Truy vấn bằng firstName
    public List<Student> findByFirstName(String firstName);

    // Truy vấn bằng firstName và lastName
    public List<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Truy vấn các students có firstName khác với giá trị tìm kiếm
    // public List<Student> findByFirstNameNot(String firstName);

    // Truy vấn các students có firstName khác với giá trị tìm kiếm
     @Query("SELECT s FROM Student s WHERE s.firstName<>?1")
     public List<Student> findByFirstNameNot(String firstName);

    // Truy vấn các students có firstName không chứa giá trị tìm kiếm // LIKE
    @Query("SELECT s FROM Student s WHERE s.firstName NOT LIKE ?1")
    public List<Student> findByFirstNameNot1(String firstName);
}
