<template>
  <nav class="navigation">
    <ul>
      <li><router-link to="/">Startseite</router-link></li>
      <li><router-link to="/todo-list">Todo-Liste</router-link></li>
      <li><router-link to="/about-us">Über Uns</router-link></li>
    </ul>
  </nav>
</template>

<script>
export default {
  name: 'NavBar'
}
</script>

<style scoped>
.navigation {
  background-color: #333;
  padding: 10px;
  width: 80px; /* Breite der Navbar anpassen */
  height: 100vh; /* Höhe der Navbar anpassen */
  position: fixed;
  top: 0;
  left: 0;
}

.navigation ul {
  list-style: none;
  padding: 0;
  margin: 0;
}

.navigation ul li {
  margin-bottom: 10px;
}

.navigation ul li:last-child {
  margin-bottom: 0;
}

.navigation ul li a {
  color: #fff;
  text-decoration: none;
  font-size: 16px;
}

.navigation ul li a:hover {
  text-decoration: underline;
}
</style>
