package com.mendel.todoappgermanbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Diese Klasse repräsentiert eine Aufgabe (Todo) in der Todo-Webanwendung.
 */
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private boolean completed; // Standardmäßig auf false initialisiert

    /**
     * Standardkonstruktor für die Todo-Klasse.
     * Initialisiert den Status der Aufgabe (completed) auf false.
     */
    public Todo() {
        this.completed = false;
    }

    /**
     * Konstruktor für die Todo-Klasse mit Titel und Beschreibung.
     * Initialisiert den Status der Aufgabe (completed) auf false.
     *
     * @param title       Der Titel der Aufgabe.
     * @param description Die Beschreibung der Aufgabe.
     */
    public Todo(String title, String description) {
        this.title = title;
        this.description = description;
        this.completed = false;
    }

    // Getter und Setter für alle Felder

    /**
     * Gibt die ID der Aufgabe zurück.
     *
     * @return Die ID der Aufgabe.
     */
    public Long getId() {
        return id;
    }

    /**
     * Setzt die ID der Aufgabe.
     *
     * @param id Die ID der Aufgabe.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gibt den Titel der Aufgabe zurück.
     *
     * @return Der Titel der Aufgabe.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Setzt den Titel der Aufgabe.
     *
     * @param title Der Titel der Aufgabe.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gibt die Beschreibung der Aufgabe zurück.
     *
     * @return Die Beschreibung der Aufgabe.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setzt die Beschreibung der Aufgabe.
     *
     * @param description Die Beschreibung der Aufgabe.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gibt den Status der Aufgabe zurück (erledigt oder nicht erledigt).
     *
     * @return true, wenn die Aufgabe erledigt ist, false sonst.
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Setzt den Status der Aufgabe (erledigt oder nicht erledigt).
     *
     * @param completed true, wenn die Aufgabe erledigt ist, false sonst.
     */
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
