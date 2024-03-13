package vn.titv.spring.demo.service;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.titv.spring.demo.dao.StudentRepository;
import vn.titv.spring.demo.entity.Student;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override

    public Student getStudentById(int id) {
        return studentRepository.getById(id);
    }

    @Override
    @Transactional
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return studentRepository.saveAndFlush(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName(String name) {
        return studentRepository.findByFirstNameNot(name);
    }

    @Override
    public List<Student> getAllStudentsNotFirstName1(String name) {
        return studentRepository.findByFirstNameNot1(name);
    }

    @Override
    public List<Student> getByFirstName(String name) {
        return studentRepository.findByFirstName(name);
    }

    @Override
    public List<Student> getByFirstNameAndLastName(String firstName, String lastName) {
        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    @Override
    public void saveStudent(Student student, int id) {
        student.setId(id);
        studentRepository.save(student);
    }
}
