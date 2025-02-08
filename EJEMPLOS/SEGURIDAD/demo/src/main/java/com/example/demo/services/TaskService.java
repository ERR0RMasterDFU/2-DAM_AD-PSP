package com.example.demo.services;

import com.example.demo.models.Task;
import com.example.demo.repositories.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public Task findById(Long id) {
        Optional<Task> optTask = taskRepository.findById(id);

        if(optTask.isPresent()) {
            return optTask.get();
        } else {
            throw new RuntimeException("No se haqn enconrtrado 'Tasks'.");
        }
    }

    public Task save(Task task) {
        return taskRepository.save(task);
    }

    public Task edit(Task task, Long id) {
        return taskRepository.findById(id)
                .map(old -> {
                    old.setTitle(task.getTitle());
                    return taskRepository.save(old);
                })
                .orElseThrow(() -> new EntityNotFoundException("No existe ninguna 'Task' con ID: "+ id));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }





}
