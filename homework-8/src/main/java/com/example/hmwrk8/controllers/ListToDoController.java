package com.example.hmwrk8.controllers;

import com.example.hmwrk8.entity.ListToDo;
import com.example.hmwrk8.repos.ListToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ListToDoController {
    @Autowired
    private ListToDoRepository listToDoRepository;

    @Transactional
    @PostMapping("/123")
    public void addToDo(@RequestBody ListToDo listToDo) {
        listToDoRepository.save(listToDo);
    }

    @GetMapping("/123")
    public List<ListToDo> getAllLists() {
        return listToDoRepository.findAll();
    }
}
