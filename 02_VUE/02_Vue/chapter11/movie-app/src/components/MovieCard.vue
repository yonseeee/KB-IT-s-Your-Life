<template>
  <div>
    <div class="grid-item">
      <div
        class="poster"
        :style="{ backgroundImage: `url(${props.movie.poster})` }"
      ></div>
      <h3>{{ props.movie.title }} ({{ props.movie.year }})</h3>
      <p><b>감독</b>: {{ props.movie.director }}</p>
      <button @click="editHandler" class="buttons">✏️ 수정</button>
      <button @click="deleteHandler" class="buttons">🗑️ 삭제</button>
      <br />
      <router-link
        class="link"
        :to="{ name: 'movies/id', params: { id: props.movie.id } }"
      >
        🔍 자세히 보기
      </router-link>
    </div>
  </div>
</template>

<script setup>
const props = defineProps({
  movie: { type: Object, required: true },
});
const emit = defineEmits(['edit-request', 'delete-request']);

const editHandler = () => {
  console.log('MovieCard');
  emit('edit-request', props.movie);
};

const deleteHandler = () => {
  emit('delete-request', props.movie.id);
};
</script>

<style scoped>
.link {
  /* cursor: pointer; */
  text-decoration: none;
  color: aliceblue;
  font-size: 0.8rem;
}
.grid-item {
  background-color: rgb(45, 44, 44);
  border-radius: 5px;
  margin: 0.4rem;
  text-align: center;
  justify-content: center;
  padding: 1rem;
}
.poster {
  background-size: cover;
  height: 300px;

  top: 10px;
  margin: 0 auto;
  background-position: center;
  padding: 1rem;
  border-radius: 5px;
}
.buttons {
  background-color: gold;
  border: none;
  border-radius: 5px;
  padding: 0.4rem;
  margin-right: 3px;
  margin-bottom: 1.5rem;
}

p,
h3 {
  color: white;
}
</style>
