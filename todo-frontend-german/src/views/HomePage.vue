<template>
  <HomeContent/>
</template>

<script>
import HomeContent from '@/components/HomeContent.vue';
export default {
  name: 'HomePage',
  components: {
    HomeContent
  }
}
</script>

<style scoped>
.home {
  padding: 20px;
  text-align: center;
}

.welcome-message {
  margin-bottom: 30px;
}

.action-buttons {
  display: flex;
  justify-content: center;
}

.btn {
  padding: 10px 20px;
  margin: 0 10px;
  background-color: #007bff; /* Beispiel für Farbe */
  color: #fff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #0056b3; /* Beispiel für Farbe */
}

.todos-btn {
  background-color: #28a745; /* Beispiel für Farbe */
}

.about-btn {
  background-color: #17a2b8; /* Beispiel für Farbe */
}
</style>
