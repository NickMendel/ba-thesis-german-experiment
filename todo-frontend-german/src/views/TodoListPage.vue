<template>
  <div class="todo-list-page">
    <TaskList :todos="todos" @add-todo="addTodo" @update-todo="editTodo" @delete-todo="deleteTodo" />
  </div>
</template>

<script>
import TaskList from '@/components/TaskList.vue';
import axios from 'axios';

export default {
  name: 'TodoListPage',
  components: {
    TaskList
  },
  data() {
    return {
      todos: [],
      isLoading: false,
      errorMessage: ''
    };
  },
  methods: {
    fetchTodos() {
      this.isLoading = true;
      axios.get('http://localhost:8080/api/todos')
        .then(response => {
          this.todos = response.data;
          this.isLoading = false;
        })
        .catch(error => {
          console.error('Fehler beim Abrufen der Todos:', error);
          this.errorMessage = 'Fehler beim Abrufen der Todos. Bitte versuchen Sie es später erneut.';
          this.isLoading = false;
        });
    },
    addTodo(newTodo) {
      this.isLoading = true;
      axios.post('http://localhost:8080/api/todos', { title: newTodo.title, description: newTodo.description, completed: false })
        .then(response => {
          this.todos.push(response.data);
          this.isLoading = false;
        })
        .catch(error => {
          console.error('Fehler beim Hinzufügen des Todos:', error);
          this.errorMessage = 'Fehler beim Hinzufügen des Todos. Bitte versuchen Sie es später erneut.';
          this.isLoading = false;
        });
    },
    editTodo(updatedTodo) {
      this.isLoading = true;
      axios.put(`http://localhost:8080/api/todos/${updatedTodo.id}`, updatedTodo)
        .then(() => {
          const index = this.todos.findIndex(todo => todo.id === updatedTodo.id);
          if (index !== -1) {
            this.todos[index] = updatedTodo;
            // Emit the update-todo event with the updated todo object
            this.$emit('update-todo', updatedTodo);
          }
          this.isLoading = false;
        })
        .catch(error => {
          console.error('Fehler beim Bearbeiten des Todos:', error);
          this.errorMessage = 'Fehler beim Bearbeiten des Todos. Bitte versuchen Sie es später erneut.';
          this.isLoading = false;
        });
    },
    deleteTodo(todoId) {
      this.isLoading = true;
      axios.delete(`http://localhost:8080/api/todos/${todoId}`)
        .then(() => {
          this.todos = this.todos.filter(todo => todo.id !== todoId);
          this.isLoading = false;
        })
        .catch(error => {
          console.error('Fehler beim Löschen des Todos:', error);
          this.errorMessage = 'Fehler beim Löschen des Todos. Bitte versuchen Sie es später erneut.';
          this.isLoading = false;
        });
    }
  },
  created() {
    this.fetchTodos();
  }
}
</script>

<style scoped>
.todo-list-page {
  padding: 20px;
}

.todo-list-page h2 {
  margin-bottom: 20px;
  color: #333;
}

.todo-list-page .loading {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 18px;
  color: #666;
  margin-top: 20px;
}

.todo-list-page .error-message {
  color: red;
  margin-top: 10px;
}
</style>
