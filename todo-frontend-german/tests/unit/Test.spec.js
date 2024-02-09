import { mount } from '@vue/test-utils';
import axios from 'axios';
import MockAdapter from 'axios-mock-adapter';
import TodoListPage from '@/views/TodoListPage.vue';

describe('TodoListPage', () => {
  let wrapper;
  let mock;

  beforeEach(() => {
    // Mocken von axios
    mock = new MockAdapter(axios);
    wrapper = mount(TodoListPage);
  });

  afterEach(() => {
    // Zurücksetzen des Mocks nach jedem Test
    mock.restore();
  });

  it('should edit todo when editTodo method is called', async () => {
    // Mock-Antwort definieren
    const updatedTodo = { id: 1, title: 'Updated Todo', description: 'Updated description', completed: false };
    mock.onPut('http://localhost:8080/api/todos/1').reply(200, updatedTodo);

    // Zustand vor der Bearbeitung
    expect(wrapper.vm.todos.length).toBe(0);

    // Bearbeiten der Aufgabe
    await wrapper.vm.editTodo(updatedTodo);

    // Überprüfen, ob die Aufgabe bearbeitet wurde
    expect(wrapper.vm.todos.length).toBe(1);
    expect(wrapper.vm.todos[0]).toEqual(updatedTodo);
  });

  // Fügen Sie weitere Tests für andere Methoden hinzu
});
