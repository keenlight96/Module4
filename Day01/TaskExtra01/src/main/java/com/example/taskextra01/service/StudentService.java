package com.example.taskextra01.service;

import com.example.taskextra01.model.Student;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StudentService {
    List<Student> students;

    public StudentService() {
        students = new ArrayList<>();
        students.add(new Student(1, "Long", "jkgnals@gmail.com","09198151"));
        students.add(new Student(2, "Duyên", "asghha@gmail.com","08181842"));
        students.add(new Student(3, "Hoàng", "aghhas@gmail.com","083951125"));
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public int getIndexByStudentId(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId)
                return i;
        }
        return -1;
    }

    public Student getStudentByStudentId(int studentId) {
        int index = getIndexByStudentId(studentId);
        return students.get(index);
    }

    public void editStudent(Student student) {
        int index = getIndexByStudentId(student.getStudentId());
        students.set(index, student);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudentByStudentId(int studentId) {
        int index = getIndexByStudentId(studentId);
        students.remove(index);
    }
}
