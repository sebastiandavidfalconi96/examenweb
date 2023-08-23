//Productservice
package com.example.ProductApplication.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask() {
        return taskRepository.findAll();
    }

    public ResponseEntity<Object> createTask(Task product) {
        Optional<Task> existingProduct = taskRepository.findByNombre(product.getNombre());
        HashMap<String, Object> datos = new HashMap<>();
        if (existingProduct.isPresent()) {
            datos.put("data", false);
            datos.put("message", "La tarea ya existe");
            return new ResponseEntity<>(datos, HttpStatus.CONFLICT);
        } else {
            Task savedProduct = taskRepository.save(product);
            datos.put("data", savedProduct);
            datos.put("message", "Tarea creada");

            return new ResponseEntity<>(datos, HttpStatus.CREATED);
        }
    }

    public ResponseEntity<Object> updateTask(Task product) {
        Optional<Task> existingProduct = taskRepository.findById(product.getId());
        HashMap<String, Object> datos = new HashMap<>();
        if (existingProduct.isPresent()) {
            Task savedProduct = taskRepository.save(product);
            datos.put("data", savedProduct);
            datos.put("message", "Tarea actualizado");

            return new ResponseEntity<>(datos, HttpStatus.OK);
        } else {
            datos.put("data", false);
            datos.put("message", "La tarea con ID " + product.getId() + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Object> deleteTask(Long productId) {
        boolean exists = taskRepository.existsById(productId);
        HashMap<String, Object> datos = new HashMap<>();

        if (!exists) {
            datos.put("data", false);
            datos.put("message", "La tarea con id " + productId + " no existe");
            return new ResponseEntity<>(datos, HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(productId);
        datos.put("data", true);
        datos.put("message", "La tarea con id " + productId + " ha sido eliminado");
        return new ResponseEntity<>(datos, HttpStatus.OK);
    }
}