<template>
  <div>
    <div class="grid-container">
      <MovieCard
        v-for="(movie, index) in movies"
        :key="index"
        :movie="movie"
        @edit-request="handleEditRequest"
        @delete-request="deleteRequest"
      />
    </div>
  </div>
</template>
<script setup>
import axios from 'axios';
import { inject } from 'vue';
import MovieCard from '@/components/MovieCard.vue';

const emit = defineEmits(['edit-request', 'refresh']);
const movies = inject('movieList');

const handleEditRequest = (movie) => {
  console.log('MovieList');
  emit('edit-request', movie);
};

const url = '/api/movies/';
const deleteRequest = async (id) => {
  const isConfirmed = confirm(`정말 삭제하시겠습니까?`);
  if (isConfirmed) {
    await axios.delete(url + id);
    alert('삭제 완료!');
    emit('refresh');
  }
};
</script>
<style scoped>
.grid-container {
  padding: 0;
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(240px, 1fr));
}
</style>
