<template>
  <!-- Die Hauptkomponente für die Aufgabenliste -->
  <div class="task-list">
    <h2>Todo-Liste</h2>
    <!-- Liste der Aufgaben -->
    <ul>
      <!-- Iteration durch die Aufgaben -->
      <li v-for="todo in todos" :key="todo.id">
        <!-- Checkbox für den Status der Aufgabe -->
        <input type="checkbox" v-model="todo.completed" @change="updateTodoStatus(todo)">
        <!-- Anzeige des Status-Badges basierend auf dem abgeschlossenen Status der Aufgabe -->
        <span :class="{'badge': true, 'badge-red': !todo.completed, 'badge-green': todo.completed}"></span>
        <!-- Anzeige des Titels der Aufgabe oder Eingabefeld für die Bearbeitung -->
        <span v-if="!todo.editing">{{ todo.title }}</span>
        <input v-else type="text" v-model="todo.title" @blur="saveTodo(todo)" @keyup.enter="saveTodo(todo)">
        <!-- Anzeige der Beschreibung der Aufgabe oder Eingabefeld für die Bearbeitung -->
        <span class="description">{{ todo.description }}</span>
        <input v-if="todo.editing" type="text" v-model="todo.newDescription" @blur="saveTodoDescription(todo)" @keyup.enter="saveTodoDescription(todo)">
        <!-- Schaltfläche zum Bearbeiten der Aufgabe -->
        <button @click="editTodo(todo)">{{ todo.editing ? 'Speichern' : 'Bearbeiten' }}</button>
        <!-- Schaltfläche zum Löschen der Aufgabe -->
        <button @click="deleteTodo(todo.id)">Löschen</button>
      </li>
    </ul>
    <!-- Formular zum Hinzufügen einer neuen Aufgabe -->
    <form @submit.prevent="addTodo">
      <input type="text" v-model="newTodo.title" placeholder="Neue Aufgabe">
      <input type="text" v-model="newTodo.description" placeholder="Beschreibung">
      <button type="submit">Hinzufügen</button>
    </form>
  </div>
</template>

<script>
/**
 * Komponente für die Anzeige und Verwaltung der Todo-Liste.
 * Zeigt eine Liste von Aufgaben an, ermöglicht das Hinzufügen, Löschen und Bearbeiten von Aufgaben.
 *
 * @name TaskList
 * @component
 */
export default {
  name: 'TaskList',

  /**
   * Props, die von der übergeordneten Komponente übergeben werden.
   *
   * @property {Array} todos - Array von Aufgabenobjekten.
   */
  props: {
    todos: {
      type: Array,
      required: true
    }
  },

  /**
   * Daten der Komponente.
   *
   * @property {object} newTodo - Objekt zum Speichern einer neuen Aufgabe.
   * @property {string} newTodo.title - Titel der neuen Aufgabe.
   * @property {string} newTodo.description - Beschreibung der neuen Aufgabe.
   */
  data() {
    return {
      newTodo: {
        title: '',
        description: ''
      }
    }
  },

  /**
   * Methoden der Komponente für die Manipulation der Aufgabenliste.
   */
  methods: {
    // Methode zum Hinzufügen einer neuen Aufgabe
    addTodo() {
      if (this.newTodo.title.trim() !== '') {
        this.$emit('add-todo', this.newTodo);
        this.newTodo = {
          title: '',
          description: ''
        };
      }
    },
    // Methode zum Aktualisieren des Status einer Aufgabe
    updateTodoStatus(todo) {
      this.$emit('update-todo', todo);
    },
    // Methode zum Löschen einer Aufgabe
    deleteTodo(todoId) {
      this.$emit('delete-todo', todoId);
    },
    // Methode zum Bearbeiten einer Aufgabe
    editTodo(todo) {
      if (!todo.editing) {
        todo.newDescription = todo.description;
      }
      todo.editing = !todo.editing;
    },
    // Methode zum Speichern einer Aufgabe nach der Bearbeitung des Titels
    saveTodo(todo) {
      todo.editing = false;
      this.$emit('update-todo', todo);
    },
    // Methode zum Speichern einer Aufgabe nach der Bearbeitung der Beschreibung
    saveTodoDescription(todo) {
      todo.editing = false;
      todo.description = todo.newDescription;
      this.$emit('update-todo', todo);
    }
  }
}
</script>

<style scoped>
/**
 * Stildefinitionen für die TaskList-Komponente.
 *
 * @property {string} .task-list - Stildefinition für den Container der Aufgabenliste.
 * @property {string} .task-list h2 - Stildefinition für den Titel der Aufgabenliste.
 * @property {string} .task-list ul - Stildefinition für die ungeordnete Liste der Aufgaben.
 * @property {string} .task-list li - Stildefinition für die einzelne Aufgabe in der Liste.
 * @property {string} .task-list li button - Stildefinition für die Schaltflächen in einer Aufgabe.
 * @property {string} .task-list .description - Stildefinition für die Beschreibung einer Aufgabe.
 * @property {string} .badge - Stildefinition für das Status-Badge einer Aufgabe.
 * @property {string} .badge-red - Stildefinition für das rote Status-Badge einer nicht erledigten Aufgabe.
 * @property {string} .badge-green - Stildefinition für das grüne Status-Badge einer erledigten Aufgabe.
 */
.task-list {
  margin-top: 20px;
}

.task-list h2 {
  margin-bottom: 10px;
}

.task-list ul {
  list-style: none;
  padding: 0;
}

.task-list li {
  margin-bottom: 5px;
}

.task-list li button {
  margin-left: 10px;
}

.task-list .description {
  margin-left: 20px;
  color: #888;
}

.badge {
  width: 10px;
  height: 10px;
  display: inline-block;
  border-radius: 50%;
  margin-right: 5px;
}

.badge-red {
  background-color: red;
}

.badge-green {
  background-color: green;
}
</style>
