package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;
import com.example.demo.repository.StudentRepo;
import com.example.demo.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo repo;

    @Override
    public List<StudentEntity> getAll() {
        return repo.findAll();
    }

    @Override
    public StudentEntity addStudent(StudentEntity student) {
        return repo.save(student);
    }

    @Override
    public StudentEntity getById(Long id) {
        Optional<StudentEntity> data = repo.findById(id);
        return data.orElse(null);
    }

    @Override
    public String updateStudent(Long id, StudentEntity newStu) {
        if (repo.existsById(id)) {
            newStu.setId(id);
            repo.save(newStu);
            return "Student updated";
        }
        return "Student not found";
    }

    @Override
    public String deleteStudent(Long id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
            return "Student deleted";
        }
        return "Student not found";
    }
}

