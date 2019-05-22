package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();
}
