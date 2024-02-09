<template>
  <div class="home-content">
    <h2>Willkommen zur Todo-Verwaltungsanwendung</h2>
    <p>Dies ist eine moderne Anwendung zur effizienten Verwaltung von Aufgaben.</p>
    <router-link to="/todo-list" class="btn">Zur Todo-Liste</router-link>
    <router-link to="/about-us" class="btn">Über Uns</router-link>
  </div>
</template>

<script>
/**
 * Komponente für den Startinhalt der Todo-Verwaltungsanwendung.
 * Zeigt eine Willkommensnachricht und Links zur Todo-Liste und Über Uns Seite an.
 *
 * @name HomeContent
 * @component
 */
export default {
  name: 'HomeContent',

  /**
   * Daten der Komponente.
   *
   * @property {string} name - Name der Komponente.
   */
  data() {
    return {
      // Keine Daten für diese Komponente
    };
  }
}
</script>

<style scoped>
/**
 * Stildefinitionen für die HomeContent-Komponente.
 *
 * @property {string} .home-content - Stildefinition für den Container der Komponente.
 * @property {string} .home-content h2 - Stildefinition für den Titel der Komponente.
 * @property {string} .home-content p - Stildefinition für den Text der Komponente.
 * @property {string} .btn - Stildefinition für die Schaltflächen in der Komponente.
 * @property {string} .btn:hover - Stildefinition für die Schaltflächen im Hover-Zustand.
 */
.home-content {
  text-align: center;
}

.home-content h2 {
  font-size: 24px;
  margin-bottom: 20px;
}

.home-content p {
  font-size: 16px;
  color: #666;
  margin-bottom: 20px;
}

.btn {
  display: inline-block;
  padding: 10px 20px;
  font-size: 16px;
  color: #fff;
  background-color: #007bff;
  border: none;
  border-radius: 5px;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.btn:hover {
  background-color: #0056b3;
}
</style>
