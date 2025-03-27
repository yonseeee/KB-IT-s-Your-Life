<template>
  <div>
    X: <input type="text" v-model.number="state.x" /><br />
    Y: <input type="text" v-model.number="state.y" /><br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { reactive, computed } from 'vue';
export default {
  name: 'Calc4',
  setup() {
    // state:Proxy
    const state = reactive({ x: 10, y: 20 });
    // x와 y가 수정되면 자연스럽게 computed로 result 값 갱신
    const result = computed(() => {
      return state.x + state.y;
    });
    return { state, result };
  },
};
</script>
<style></style>
