package com.mendel.todoappgermanbackend.service;

import com.mendel.todoappgermanbackend.model.Todo;
import com.mendel.todoappgermanbackend.repository.TodoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoService todoService;

    @Test
    public void testGetAllTodos() {
        // Arrange
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Task 1", "Description 1"));
        todos.add(new Todo("Task 2", "Description 2"));

        when(todoRepository.findAll()).thenReturn(todos);

        // Act
        List<Todo> result = todoService.getAllTodos();

        // Assert
        assertEquals(2, result.size());
    }

    @Test
    public void testGetTodoById() {
        // Arrange
        Todo todo = new Todo("Task 1", "Description 1");
        todo.setId(1L);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        // Act
        Optional<Todo> result = todoService.getTodoById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals(todo, result.get());
    }

    @Test
    public void testCreateTodo() {
        // Arrange
        Todo todo = new Todo("Task 1", "Description 1");

        when(todoRepository.save(todo)).thenReturn(todo);

        // Act
        Todo result = todoService.createTodo(todo);

        // Assert
        assertEquals(todo, result);
    }

    @Test
    public void testUpdateTodo() {
        // Arrange
        Todo existingTodo = new Todo("Task 1", "Description 1");
        existingTodo.setId(1L);
        Todo updatedTodo = new Todo("Updated Task 1", "Updated Description 1");

        when(todoRepository.findById(1L)).thenReturn(Optional.of(existingTodo));
        when(todoRepository.save(existingTodo)).thenReturn(updatedTodo);

        // Act
        Todo result = todoService.updateTodo(1L, updatedTodo);

        // Assert
        assertEquals(updatedTodo.getTitle(), result.getTitle());
        assertEquals(updatedTodo.getDescription(), result.getDescription());
    }

    @Test
    public void testDeleteTodo() {
        // Arrange
        Todo todo = new Todo();
        todo.setId(1L);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        // Act
        boolean result = todoService.deleteTodo(1L);

        // Assert
        assertTrue(result);
        verify(todoRepository, times(1)).deleteById(1L);
    }
}
