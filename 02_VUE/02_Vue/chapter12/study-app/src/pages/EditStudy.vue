<template>
  <div class="container mt-5">
    <h1 class="mb-3">✏스터디 등록</h1>
    <p>스터디명</p>

    <input type="text" v-model="title" />
    <br />
    <p>설명</p>
    <textarea v-model="desc"></textarea>
    <br />
    <p>카테고리</p>

    <select name="" id="" v-model="category">
      <option value="프론트엔드">프론트엔드</option>
      <option value="백엔드">백엔드</option>
      <option value="AI">AI</option>
      <option value="알고리즘">알고리즘</option>
      <option value="디자인">디자인</option>
      <option value="CS">CS</option>
      <option value="크리에이티브">크리에이티브</option>
      <option value="데이터 분석">데이터 분석</option>
      <option value="자격증">자격증</option>
      <option value="기타">기타</option>
    </select>
    <br />
    <p>마감일</p>

    <input type="date" v-model="dueDate" />
    <br />
    <p>최대 인원수</p>

    <input type="text" v-model="max" />
    <br />

    <button type="button" class="btn btn-primary" @click="editHandler">
      저장하기
    </button>

    <router-link
      :to="{ name: 'studies/id', params: { id: currentRoute.params.id } }"
      class="btn btn-outline-secondary"
      >취소</router-link
    >
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref } from 'vue';
import { useRouter, useRoute } from 'vue-router';

const router = useRouter();
const currentRoute = useRoute();
const url = '/api/studies/';
const url2 = '/api/studies';
const title = ref('');
const desc = ref('');
const category = ref('');
const dueDate = ref('');
const likes = ref(0);
const max = ref('');
const createdAt = ref('');

const requestAPI = async () => {
  let response = await axios.get(url + currentRoute.params.id);
  let data = response.data;
  console.log(response.data);

  title.value = data.title;
  desc.value = data.desc;
  category.value = data.category;
  dueDate.value = data.dueDate;
  max.value = data.max;
  likes.value = data.likes;
  createdAt.value = data.createdAt;
};

requestAPI();

const editHandler = async () => {
  console.log('hi');
  if (
    !title.value ||
    !desc.value ||
    !category.value ||
    !dueDate.value ||
    !max.value
  )
    alert('모든 항목은 입력 필수입니다!');
  else if (new Date(dueDate.value).getTime() - new Date().getTime() < 0)
    alert('지난 날짜를 선택하셨습니다!');
  else {
    let data = {
      title: title.value,
      desc: desc.value,
      category: category.value,
      dueDate: dueDate.value,
      createdAt: new Date().toISOString().split('T')[0],
      likes: 0,
      max: max.value,
    };
    try {
      let response = await axios.put(url + currentRoute.params.id, data);
      alert('수정 완료!');
      router.push({ name: 'studies' });
    } catch (error) {
      console.error(error);
    }
  }
};
</script>
<style scoped>
.container {
  width: 1000px;
}
input {
  width: 100%;
  margin-bottom: 1rem;
  border-radius: 5px;
  border: 1px solid black;
  padding: 0.5rem;
}
textarea {
  width: 100%;
  margin-bottom: 1rem;
  border-radius: 5px;
  padding: 0.5rem;
}
select {
  width: 100%;
  margin-bottom: 1rem;
  border-radius: 5px;
  padding: 0.5rem;
}
p {
  margin: 0;
}
button {
  margin-right: 0.5rem;
}
</style>
