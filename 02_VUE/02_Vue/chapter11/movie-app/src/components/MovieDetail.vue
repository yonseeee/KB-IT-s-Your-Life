<template>
  <div>
    <p>{{ movie.title }} ({{ movie.year }})</p>
    <p>감독: {{ movie.director }}</p>
    <p>줄거리: {{ movie.description }}</p>
    <img :src="movie.poster" alt="" />
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRoute } from 'vue-router';

const currentRoute = useRoute();
const id = currentRoute.params.id;

const movie = ref('');
const urlPrefix = '/api/movies/';

const requestAPI = async () => {
  const response = await axios.get(urlPrefix + id);
  movie.value = response.data;
};
requestAPI();
</script>
<style scoped>
div {
  color: white;
  padding: 20px;
}
li {
  margin: 10px;
}

img {
  width: 600px;
}
</style>
