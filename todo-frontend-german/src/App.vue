<template>
  <div id="app">
    <NavBar />
    <div class="content">
      <router-view />
    </div>
  </div>
</template>

<script>
import NavBar from "@/components/NavBar.vue";

export default {
  name: "App",
  components: {
    NavBar,
  },
};
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  display: flex;
  min-height: 100vh;
}

.content {
  flex: 1;
  padding: 20px;
  margin-left: 200px; /* Berücksichtige die Breite der Navbar */
  overflow: auto; /* Erlaube das Scrollen des Inhalts */
}
</style>
