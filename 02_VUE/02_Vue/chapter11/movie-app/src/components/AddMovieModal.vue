<template>
  <div>
    <div class="modal-overlay">
      <div class="modal-container">
        <p>🎥</p>
        <input type="text" placeholder="제목" v-model="title" /><br />
        <input type="text" placeholder="연도" v-model="year" /><br />
        <input type="text" placeholder="감독" v-model="director" /><br />

        <textarea placeholder="줄거리" v-model="content"></textarea>
        <br />
        <input type="text" placeholder="포스터 이미지 URL" v-model="image" />
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
import { provide, ref } from 'vue';
import axios from 'axios';
const year = ref('');
const title = ref('');
const director = ref('');
const content = ref('');
const image = ref('');

const props = defineProps({
  visible: { type: Boolean },
});
const emit = defineEmits(['movie-added', 'close']);

const requestAPI = async () => {
  const url = '/api/movies';
  let data = {
    title: title.value,
    year: year.value,
    director: director.value,
    description: content.value,
    poster: image.value,
  };
  const resp1 = await axios.post(url, data);
  console.log(resp1);

  emit('movie-added');
};

const closeHandler = () => {
  emit('close');
};
</script>
<style scoped>
.buttons {
  display: flex;
  justify-content: space-between;
}
button {
  background-color: gold;
  margin-top: 3px;
  border-radius: 5px;
}
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6); /* 어두운 반투명 배경 */

  z-index: 1000; /* 다른 요소보다 위에 올라오게 */
}

.modal-container {
  margin-top: 100px;
  margin-left: 400px;
  background-color: white;
  padding: 30px;
  border-radius: 10px;
  width: 200px;
  box-shadow: 0 4px 15px rgba(0, 0, 0, 0.3);
}
input {
  width: 100%;
  margin-bottom: 3px;
}
textarea {
  width: 100%;
}
</style>
