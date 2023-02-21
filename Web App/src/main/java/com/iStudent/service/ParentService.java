package com.iStudent.service;

import com.iStudent.model.entity.Parent;
import com.iStudent.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    @Autowired
    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    public Parent findParentById(Long parentId) {
        return parentRepository.findById(parentId).orElse(null);
    }
}
