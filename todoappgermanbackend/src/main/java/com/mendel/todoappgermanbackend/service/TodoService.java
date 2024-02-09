package com.mendel.todoappgermanbackend.service;

import com.mendel.todoappgermanbackend.model.Todo;
import com.mendel.todoappgermanbackend.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Diese Klasse stellt Methoden zur Verwaltung von Todos bereit.
 */
@Service
public class TodoService {

    private final TodoRepository todoRepository;

    /**
     * Konstruktor für den TodoService.
     *
     * @param todoRepository Das TodoRepository für den Zugriff auf die Datenbank.
     */
    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    /**
     * Gibt alle Todos zurück.
     *
     * @return Die Liste der Todos.
     */
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    /**
     * Sucht ein Todo anhand seiner ID.
     *
     * @param id Die ID des gesuchten Todos.
     * @return Das Optional mit dem gefundenen Todo, falls vorhanden.
     */
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    /**
     * Erstellt ein neues Todo.
     *
     * @param todo Das zu erstellende Todo.
     * @return Das erstellte Todo.
     */
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    /**
     * Aktualisiert ein vorhandenes Todo.
     *
     * @param id          Die ID des zu aktualisierenden Todos.
     * @param todoDetails Das aktualisierte Todo mit den neuen Details.
     * @return Das aktualisierte Todo.
     */
    public Todo updateTodo(Long id, Todo todoDetails) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            Todo todo = todoOptional.get();
            todo.setTitle(todoDetails.getTitle());
            todo.setDescription(todoDetails.getDescription());
            todo.setCompleted(todoDetails.isCompleted());
            return todoRepository.save(todo);
        } else {
            return null; // Wenn die Todo mit der gegebenen ID nicht gefunden wurde
        }
    }

    /**
     * Löscht ein vorhandenes Todo anhand seiner ID.
     *
     * @param id Die ID des zu löschenden Todos.
     * @return true, wenn das Todo erfolgreich gelöscht wurde, false sonst.
     */
    public boolean deleteTodo(Long id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            todoRepository.deleteById(id);
            return true;
        } else {
            return false; // Wenn die Todo mit der gegebenen ID nicht gefunden wurde
        }
    }
}
