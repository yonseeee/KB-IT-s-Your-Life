<template>
  <div class="card">
    <div class="card-body">
      <h2 style="color: blue">MBTI 궁합 테스트</h2>

      <label for="mine">나의 MBTI</label><br />
      <select id="mine" v-model="mine">
        <option value="" disabled selected>선택하세요</option>
        <option value="INTJ">INTJ</option>
        <option value="INTP">INTP</option>
        <option value="ENTJ">ENTJ</option>
        <option value="ENTP">ENTP</option>
        <option value="INFJ">INFJ</option>
        <option value="INFP">INFP</option>
        <option value="ENFJ">ENFJ</option>
        <option value="ENFP">ENFP</option>
        <option value="ISTJ">ISTJ</option>
        <option value="ISFJ">ISFJ</option>
        <option value="ESTJ">ESTJ</option>
        <option value="ESFJ">ESFJ</option>
        <option value="ISTP">ISTP</option>
        <option value="ISFP">ISFP</option>
        <option value="ESTP">ESTP</option>
        <option value="ESFP">ESFP</option>
      </select>
      <label for="friends">친구의 MBTI</label><br />
      <select id="friends" v-model="friend">
        <option value="" disabled selected>선택하세요</option>
        <option value="INTJ">INTJ</option>
        <option value="INTP">INTP</option>
        <option value="ENTJ">ENTJ</option>
        <option value="ENTP">ENTP</option>
        <option value="INFJ">INFJ</option>
        <option value="INFP">INFP</option>
        <option value="ENFJ">ENFJ</option>
        <option value="ENFP">ENFP</option>
        <option value="ISTJ">ISTJ</option>
        <option value="ISFJ">ISFJ</option>
        <option value="ESTJ">ESTJ</option>
        <option value="ESFJ">ESFJ</option>
        <option value="ISTP">ISTP</option>
        <option value="ISFP">ISFP</option>
        <option value="ESTP">ESTP</option>
        <option value="ESFP">ESFP</option>
      </select>

      <button
        @click="matchHandler"
        class="btn btn-primary w-100 py-2 form-control"
      >
        궁합 계산
      </button>
      <div class="alert alert-success" v-show="isShow">
        <h4>{{ mine }}💗{{ friend }}</h4>
        <p v-if="!mine || !friend">
          데이터 없음: 이 조합은 아직 분석되지 않았어요!
        </p>
        <p v-else>{{ matchResult.result }}</p>
        <p v-if="!mine || !friend"><b>궁합률</b>: ??%</p>
        <p v-else><b>궁합률</b>: {{ matchResult.compatibility }}%</p>
      </div>
      <button
        @click="saveHandler"
        v-if="isShow && mine && friend"
        class="btn btn-success form-control"
      >
        결과 저장
      </button>
      <div v-show="isShow2" class="alert alert-info">
        저장 완료! 결과 목록으로 이동 중...
      </div>
    </div>
  </div>
</template>
<script setup>
import { useMatchStore } from '@/stores/matchStore.js';
import { ref, computed } from 'vue';
import { useRouter } from 'vue-router';
const router = useRouter();
const mine = ref('');
const friend = ref('');

const matchStore = useMatchStore();
const isShow = ref(false);
const isShow2 = ref(false);
const { myMBTI, friendMBTI, matchFunc, saveResult } = matchStore;
const matchResult = computed(() => matchStore.Result);
const matchHandler = () => {
  isShow.value = true;
  matchFunc(mine.value, friend.value);
};

const saveHandler = () => {
  isShow2.value = true;
  setTimeout(() => {
    saveResult();
    router.push({ name: 'results' });
  }, 1000);
};
</script>

<style scoped>
select {
  width: 100%;
  margin-bottom: 2rem;
}
.card {
  max-width: 600px;
  box-shadow: 1px 2px 5px;
  margin: 0 auto;
  padding: 2rem;

  border-radius: 10px;
  justify-content: center;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
}
h2 {
  text-align: center;
  font-weight: bold;
  margin-bottom: 2rem;
}
button {
  font-weight: bold;
}
.alert {
  text-align: center;
  margin: 1rem;
}
p {
  margin: 0;
}
select {
  border-radius: 5px;
  padding: 0.5rem;
}
</style>
