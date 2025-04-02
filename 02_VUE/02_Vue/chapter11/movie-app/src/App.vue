<template>
  <div>
    <p>📽 지브리 영화 리스트</p>
    <button @click="visible = true">🎬 영화 추가하기</button>
    <router-view></router-view>

    <AddMovieModal
      v-if="visible"
      @close="visible = false"
      @movie-added="addHandler"
    />
  </div>
</template>
<script setup>
import axios from 'axios';
import { provide } from 'vue';
import { ref } from 'vue';
import MovieList from './components/MovieList.vue';
import AddMovieModal from './components/AddMovieModal.vue';
const movieList = ref([]);
const visible = ref(false);

provide('movieList', movieList);
const url = '/api/movies';

const requestAPI = async () => {
  let response = await axios.get(url);
  movieList.value = response.data;
};

requestAPI();

const addHandler = async () => {
  let response = await axios.get(url);

  movieList.value = response.data;
};
</script>
<style scoped>
div {
  background-color: rgb(51, 51, 51);
}
p {
  color: white;
  font-size: 2rem;
  padding: 10px;
}

* {
  margin: 0;
}

button {
  background-color: gold;
  border-radius: 5px;
  padding: 5px;
  margin: 10px;
  box-shadow: none;
}
</style>
