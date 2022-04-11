package com.example.hmwrk8.repos;

import com.example.hmwrk8.entity.ListToDo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ListToDoRepository extends JpaRepository<ListToDo, Long> {

}
