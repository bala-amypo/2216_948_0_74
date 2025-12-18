package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.studentEntity;
import com.example.demo.repository.studentRepo;
import com.example.demo.service.StudentService;

@Service
public class studentServiceImpl implements StudentService {

    @Autowired
    private studentRepo repo;

    @Override
    public List<studentEntity> getAllStudents() {
        return repo.findAll();
    }

    @Override
    public studentEntity addStudent(studentEntity student) {
        return repo.save(student);
    }
}