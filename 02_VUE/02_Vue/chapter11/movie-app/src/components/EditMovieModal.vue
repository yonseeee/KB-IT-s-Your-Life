<template>
  <div>
    <div class="modal-overlay">
      <div class="modal-container">
        <p>✏️</p>
        <input
          type="text"
          placeholder="제목"
          v-model="props.movie.title"
        /><br />
        <input
          type="text"
          placeholder="연도"
          v-model="props.movie.year"
        /><br />
        <input
          type="text"
          placeholder="감독"
          v-model="props.movie.director"
        /><br />

        <textarea
          placeholder="줄거리"
          v-model="props.movie.description"
        ></textarea>
        <br />
        <input
          type="text"
          placeholder="포스터 이미지 URL"
          v-model="props.movie.poster"
        />
        <br />
        <div class="buttons">
          <button @click="requestAPI">저장</button>
          <button @click="closeHandler">닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import axios from 'axios';
const props = defineProps({
  movie: { type: Object },
});
const emit = defineEmits(['update-done', 'close']);
const url = '/api/movies/';
const requestAPI = () => {
  let data = {
    title: props.movie.title,
    year: props.movie.year,
    director: props.movie.director,
    description: props.movie.director,
    poster: props.movie.poster,
  };
  axios.put(url + props.movie.id, data);
  emit('update-done');
};

const closeHandler = () => {
  emit('close');
};
</script>
<style scoped>
.buttons {
  width: 100%;
  display: flex;
  justify-content: space-between;
}
button {
  background-color: gold;
  margin-top: 3px;
  border-radius: 5px;
  border: none;
  padding: 0.5rem;
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
  background-color: white;
  padding: 30px;
  border-radius: 10px;
  width: 240px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
}
input {
  width: 230px;
  margin-bottom: 0.8rem;
  padding: 0;
  padding: 3px;
  border: 2;
}
textarea {
  width: 232px;
  padding: 3px;
  margin-bottom: 0.8rem;
  border: 1;
}
</style>
