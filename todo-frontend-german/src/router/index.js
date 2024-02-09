import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../views/HomePage.vue';
import AboutUsPage from '../views/AboutUsPage.vue';
import TodoListPage from '../views/TodoListPage.vue';

const routes = [
  {
    path: '/',
    name: 'HomePage',
    component: HomePage
  },
  {
    path: '/todo-list',
    name: 'TodoListPage',
    component: TodoListPage
  },
  {
    path: '/about-us',
    name: 'AboutUsPage',
    component: AboutUsPage
  }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;
