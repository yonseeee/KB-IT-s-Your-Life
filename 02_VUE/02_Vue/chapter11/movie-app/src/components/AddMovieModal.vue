<template>
  <div>
    <div class="modal-overlay">
      <div class="modal-container">
        <p>🎥</p>
        <input type="text" placeholder="제목" v-model="status.title" /><br />
        <input type="text" placeholder="연도" v-model="status.year" /><br />
        <input type="text" placeholder="감독" v-model="status.director" /><br />

        <textarea placeholder="줄거리" v-model="status.description"></textarea>
        <br />
        <input
          type="text"
          placeholder="포스터 이미지 URL"
          v-model="status.poster"
        />
        <br />
        <div class="buttons">
          <button @click="requestAPI">등록</button>
          <button @click="closeHandler">닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { provide, ref, reactive } from 'vue';
import axios from 'axios';

const status = reactive({
  year: '',
  title: '',
  director: '',
  description: '',
  poster: '',
});
// const year = ref('');
// const title = ref('');
// const director = ref('');
// const content = ref('');
// const image = ref('');

const props = defineProps({
  visible: { type: Boolean },
});
const emit = defineEmits(['movie-added', 'close']);

const requestAPI = async () => {
  const url = '/api/movies';
  let data = {
    title: status.title,
    year: status.year,
    director: status.director,
    description: status.description,
    poster: status.poster,
  };
  const resp = await axios.post(url, data);
  console.log(resp);

  emit('movie-added');
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
