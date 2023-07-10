package com.example.taskextra01.controller;

import com.example.taskextra01.model.Student;
import com.example.taskextra01.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/home")
    public String getAllStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "home";
    }

    @GetMapping("/add")
    public String toAddForm() {
        return "add";
    }

    @PostMapping("/add")
    public String addStudent(@ModelAttribute Student student) {
        studentService.addStudent(student);
        return "redirect:/home";
    }

    @GetMapping("/edit")
    public String toEditForm(int studentId, Model model) {
        model.addAttribute("student", studentService.getStudentByStudentId(studentId));
        return "edit";
    }

    @PostMapping("/edit")
    public String editStudent(@ModelAttribute Student student) {
        studentService.editStudent(student);
        return "redirect:/home";
    }

    @GetMapping("/remove")
    public String removeStudent(@ModelAttribute Student student) {
        studentService.removeStudentByStudentId(student.getStudentId());
        return "redirect:/home";
    }
}
