<template>
  <div>
    <h1 class="title">스터디 목록</h1>
    <router-link
      style="margin-left: 2rem"
      to="/studies/add"
      class="btn btn-primary mb-3"
    >
      ➕ 스터디 등록
    </router-link>
    <div class="form-box">
      <label
        ><input
          type="checkbox"
          v-model="isChecked"
          @change="checkHandler"
        />모집 중만 보기</label
      >
      <select v-model="criterion">
        <option value="1" selected>마감일 임박순</option>
        <option value="2">최신 등록일 순</option>
        <option value="3">좋아요 순</option>
      </select>
    </div>
    <div class="grid-container">
      <StudyCard
        v-for="(study, index) in sortLists"
        :key="index"
        :study="study"
        @click="cardHandler(study.id)"
      />
    </div>
  </div>
</template>
<script setup>
import axios from 'axios';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
import StudyCard from '@/components/StudyCard.vue';
const url = '/api/studies';

const studyList = ref([]);
const criterion = ref('1');
const isChecked = ref(false);

const requestAPI = async () => {
  let response = await axios.get(url);
  studyList.value = response.data;

  console.log(studyList.value);
};

requestAPI();

const router = useRouter();
const cardHandler = (id) => {
  console.log('hi');
  router.push({ name: 'studies/id', params: { id: id } });
};

const sortLists = computed(() => {
  if (criterion.value === '1') {
    studyList.value.sort((left, right) => {
      if (left.dueDate < right.dueDate) return -1;
      if (left.dueDate > right.dueDate) return 1;
      return 0;
    });
  } else if (criterion.value === '2') {
    studyList.value.sort((left, right) => {
      if (left.createdAt < right.createdAt) return -1;
      if (left.createdAt > right.createdAt) return 1;
      return 0;
    });
  } else {
    studyList.value.sort((left, right) => {
      if (left.likes < right.likes) return 1;
      if (left.likes > right.likes) return -1;
      return 0;
    });
  }
  return studyList.value;
});

const checkHandler = () => {
  isChecked.value = !isChecked.value;
};

const calcdate = (due) => {
  console.log(due);
  let result;
  if (new Date(due).getTime() - new Date().getTime() < 0) {
    result = -1;

    console.log(result);
  } else {
    result =
      (new Date(due).getTime() - new Date().getTime()) / (1000 * 3600 * 24);

    console.log(result);
  }

  return result;
};
// calcdate();
</script>
<style scoped>
.title {
  padding: 2rem;
  margin-bottom: 0;
}
.grid-container {
  padding: 2rem;
  display: grid;
  grid-template-columns: repeat(2, minmax(240px, 1fr));
}
.form-box {
  display: flex;
  justify-content: space-between;
  margin: 0 3rem;
}
</style>
