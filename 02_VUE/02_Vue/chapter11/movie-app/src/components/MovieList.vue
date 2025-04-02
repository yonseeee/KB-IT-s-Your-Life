<template>
  <div>
    <ul>
      <li v-for="(movie, index) in movies" :key="index">
        <router-link
          class="link"
          :to="{ name: 'movies/id', params: { id: movie.id } }"
        >
          🎬 {{ movie.title }} - {{ movie.director }}</router-link
        >
      </li>
    </ul>
  </div>
</template>
<script setup>
import { inject } from 'vue';
const movies = inject('movieList');
</script>
<style scoped>
div {
  color: white;
  padding: 20px;
}
li {
  margin: 10px;
}
p {
  font-size: 2rem;
}
.link {
  text-decoration: none;
  color: gold;
}
</style>
