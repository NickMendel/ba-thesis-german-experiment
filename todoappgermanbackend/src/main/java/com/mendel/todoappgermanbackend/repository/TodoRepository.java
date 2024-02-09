package com.mendel.todoappgermanbackend.repository;

import com.mendel.todoappgermanbackend.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Dieses Interface stellt Methoden zum Zugriff auf die Datenbank für die Todo-Entität bereit.
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
