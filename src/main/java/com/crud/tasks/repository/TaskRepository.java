package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface TaskRepository extends CrudRepository<Task, Long> {
    @Override
    List<Task> findAll();

    @Override
    Task findOne(Long id);

    Optional<Task> findById(Long id);

    @Override
    Task save(Task task);

    @Override
    void delete(Long id);

    @Override
    long count();
}
