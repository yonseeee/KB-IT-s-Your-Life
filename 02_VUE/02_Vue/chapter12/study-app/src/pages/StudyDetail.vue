<template>
  <div class="container m-5">
    <h1>{{ study.title }}</h1>
    <h5>{{ study.desc }}</h5>
    <br />
    <ul class="list-group">
      <li class="list-group-item">📆 마감일: {{ study.dueDate }}</li>
      <li class="list-group-item">📆 등록일: {{ study.createdAt }}</li>
      <li class="list-group-item">📌 카테고리: {{ study.category }}</li>
      <li class="list-group-item">👩🏼‍🤝‍👩🏻 최대 인원: {{ study.max }}</li>
      <li class="list-group-item">💙 좋아요: {{ study.likes }}</li>
    </ul>
    <br />
    <button
      type="button"
      class="btn btn-outline-danger"
      @click="likeHandler(study.id)"
    >
      ❤ 좋아요 누르기
    </button>

    <router-link
      :to="{ name: 'studies/id/edit', params: { id: study.id } }"
      class="btn btn-warning"
      >✏ 수정하기</router-link
    >

    <button type="button" class="btn btn-success">✅ 신청하기</button>
    <br />
    <div class="badge bg-success">
      D-{{
        Math.ceil(
          (new Date(study.dueDate).getTime() - new Date().getTime()) /
            (1000 * 3600 * 24)
        )
      }}
    </div>

    <br /><br />
    <router-link :to="{ name: 'studies' }" class="btn btn-outline-secondary"
      >◀ 목록으로</router-link
    >

    신청자 목록
    <p>아직 신청자가 없습니다.</p>
  </div>
</template>
<script setup>
import axios from 'axios';
import { useRoute } from 'vue-router';
import { ref } from 'vue';
const currentRoute = useRoute();

const url = '/api/studies/';

const study = ref(null);
const requestAPI = async () => {
  let response = await axios.get(url + currentRoute.params.id);
  study.value = response.data;
};

requestAPI();

const likeHandler = async (id) => {
  const updated = { ...study.value, likes: study.value.likes + 1 };
  await axios.put(url + id, updated);
  study.value.likes++;
};
</script>
<style scoped>
button {
  margin-right: 0.5rem;
}
</style>
