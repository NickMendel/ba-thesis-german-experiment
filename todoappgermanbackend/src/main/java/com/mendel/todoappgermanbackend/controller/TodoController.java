package com.mendel.todoappgermanbackend.controller;

import com.mendel.todoappgermanbackend.model.Todo;
import com.mendel.todoappgermanbackend.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Dieser Controller stellt Endpunkte für die Verwaltung von Todos bereit.
 */
@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    private final TodoService todoService;

    /**
     * Konstruktor für den TodoController.
     *
     * @param todoService Der TodoService für die Verwaltung von Todos.
     */
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    /**
     * Endpunkt zum Abrufen aller Todos.
     *
     * @return Die ResponseEntity mit der Liste aller Todos und dem HTTP-Status 200 OK.
     */
    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        List<Todo> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos);
    }

    /**
     * Endpunkt zum Abrufen eines Todos anhand seiner ID.
     *
     * @param id Die ID des gesuchten Todos.
     * @return Die ResponseEntity mit dem gefundenen Todo und dem HTTP-Status 200 OK,
     *         oder HTTP-Status 404 Not Found, falls das Todo nicht gefunden wurde.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id) {
        Optional<Todo> todo = todoService.getTodoById(id);
        return todo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpunkt zum Erstellen eines neuen Todos.
     *
     * @param todo Das zu erstellende Todo.
     * @return Die ResponseEntity mit dem erstellten Todo und dem HTTP-Status 201 Created.
     */
    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.createTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    /**
     * Endpunkt zum Aktualisieren eines vorhandenen Todos.
     *
     * @param id          Die ID des zu aktualisierenden Todos.
     * @param todoDetails Das aktualisierte Todo mit den neuen Details.
     * @return Die ResponseEntity mit dem aktualisierten Todo und dem HTTP-Status 200 OK,
     *         oder HTTP-Status 404 Not Found, falls das Todo nicht gefunden wurde.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo todoDetails) {
        Todo updatedTodo = todoService.updateTodo(id, todoDetails);
        if (updatedTodo != null) {
            return ResponseEntity.ok(updatedTodo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Endpunkt zum Löschen eines vorhandenen Todos.
     *
     * @param id Die ID des zu löschenden Todos.
     * @return Die ResponseEntity mit dem HTTP-Status 204 No Content,
     *         oder HTTP-Status 404 Not Found, falls das Todo nicht gefunden wurde.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id) {
        boolean deleted = todoService.deleteTodo(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
