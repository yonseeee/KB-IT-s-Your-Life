<template>
  <div>
    <div class="card">
      <h2>저장된 MBTI 궁합 결과</h2>
      <div class="card-body">
        <div v-if="state.results.length > 0" class="list-group">
          <div
            class="list-group-item"
            v-for="(result, index) in state.results"
            :key="index"
          >
            <div>
              <h4>{{ result.myMBTI }}💗{{ result.friendMBTI }}</h4>
              <p>{{ result.result }}</p>
              <p>궁합률: {{ result.compatibility }}%</p>
            </div>
            <button
              @click="deleteResult(result.id)"
              class="btn btn-outline-danger"
            >
              삭제
            </button>
          </div>
        </div>
        <div v-else style="text-align: center">
          <p style="margin: 0 auto">저장된 결과가 없습니다.</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script setup>
import { useMatchStore } from '@/stores/matchStore.js';
import { ref, computed, onMounted } from 'vue';
import { useRoute } from 'vue-router';
const matchStore = useMatchStore();
const currentRoute = useRoute();

const { state, showResults, deleteResult } = matchStore;

showResults();

// onMounted(() => {
//   fetchResults();
// });
</script>
<style scoped>
.list-group-item {
  padding: 1rem;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
p {
  margin: 0;
}
h4 {
  font-weight: bold;
}

h2 {
  text-align: center;
  font-weight: bold;
  color: green;
  margin-top: 1rem;
}
</style>
