package com.example.springbootcrudmysql.repository;

import com.example.springbootcrudmysql.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {
    List<Tasks> findByStatus(String status);
}
