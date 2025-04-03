<template>
  <div>
    <div class="modal-overlay">
      <div class="modal-container">
        <p style="font-size: 2rem">{{ movie.title }} ({{ movie.year }})</p>
        <p>감독: {{ movie.director }}</p>
        <p>줄거리: {{ movie.description }}</p>
        <div
          class="post"
          :style="{ backgroundImage: `url(${movie.poster})` }"
        ></div>
      </div>
    </div>
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
  width: 600px;
}
li {
  margin: 10px;
}

.post {
  height: 300px;
  background-size: cover;
  background-position: center;
  border-radius: 5px;
}

.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6); /* 어두운 반투명 배경 */
  display: flex;
  justify-content: center;
  align-items: center;
  z-index: 1000; /* 다른 요소보다 위에 올라오게 */
}

.modal-container {
  justify-content: center;
  background-color: rgb(52, 51, 51);
  padding: 30px;
  border-radius: 10px;
  width: 700px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
}
</style>
