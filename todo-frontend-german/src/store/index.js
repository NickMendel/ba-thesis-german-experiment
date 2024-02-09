import { createStore } from 'vuex';

const store = createStore({
  state: {
    todos: []
  },
  mutations: {
    setTodos(state, todos) {
      state.todos = todos;
    },
    addTodo(state, todo) {
      state.todos.push(todo);
    },
    updateTodoStatus(state, updatedTodo) {
      const index = state.todos.findIndex(todo => todo.id === updatedTodo.id);
      if (index !== -1) {
        state.todos.splice(index, 1, updatedTodo);
      }
    },
    deleteTodo(state, todoId) {
      state.todos = state.todos.filter(todo => todo.id !== todoId);
    }
  },
  actions: {
    // Hier könnten weitere Aktionen definiert werden, z.B. für HTTP-Anfragen an das Backend
  }
});

export default store;
