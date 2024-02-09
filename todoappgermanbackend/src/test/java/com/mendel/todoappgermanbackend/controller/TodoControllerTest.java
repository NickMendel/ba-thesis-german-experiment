package com.mendel.todoappgermanbackend.controller;

import com.mendel.todoappgermanbackend.model.Todo;
import com.mendel.todoappgermanbackend.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {

    @Mock
    private TodoService todoService;

    @InjectMocks
    private TodoController todoController;

    @Test
    public void testGetAllTodos() {
        // Arrange
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Task 1", "Description 1"));
        todos.add(new Todo("Task 2", "Description 2"));

        when(todoService.getAllTodos()).thenReturn(todos);

        // Act
        ResponseEntity<List<Todo>> response = todoController.getAllTodos();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(todos, response.getBody());
    }

    @Test
    public void testGetTodoById() {
        // Arrange
        Todo todo = new Todo("Task 1", "Description 1");
        todo.setId(1L);

        when(todoService.getTodoById(1L)).thenReturn(Optional.of(todo));

        // Act
        ResponseEntity<Todo> response = todoController.getTodoById(1L);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(todo, response.getBody());
    }

    @Test
    public void testCreateTodo() {
        // Arrange
        Todo todo = new Todo("Task 1", "Description 1");

        when(todoService.createTodo(todo)).thenReturn(todo);

        // Act
        ResponseEntity<Todo> response = todoController.createTodo(todo);

        // Assert
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(todo, response.getBody());
    }

    @Test
    public void testUpdateTodo() {
        // Arrange
        Todo existingTodo = new Todo("Task 1", "Description 1");
        existingTodo.setId(1L);
        Todo updatedTodo = new Todo("Updated Task 1", "Updated Description 1");

        when(todoService.updateTodo(1L, updatedTodo)).thenReturn(updatedTodo);

        // Act
        ResponseEntity<Todo> response = todoController.updateTodo(1L, updatedTodo);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedTodo, response.getBody());
    }

    @Test
    public void testDeleteTodo() {
        // Arrange
        when(todoService.deleteTodo(1L)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = todoController.deleteTodo(1L);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
