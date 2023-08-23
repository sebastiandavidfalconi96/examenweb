package com.example.ProductApplication.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllProducts() {
        return taskService.getTask();
    }

    @PostMapping
    public ResponseEntity<Object> crearProduct(@RequestBody Task product) {
        return taskService.createTask(product);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarProduct(@RequestBody Task product) {
        return taskService.updateTask(product);
    }

    @DeleteMapping(path = "{productId}")
    public ResponseEntity<Object> eliminarProduct(@PathVariable("productId") Long productId) {
        return taskService.deleteTask(productId);
    }
}