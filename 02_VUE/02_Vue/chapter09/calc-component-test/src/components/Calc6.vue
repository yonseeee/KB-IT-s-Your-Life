<template>
  <div>
    X: <input type="text" v-model.number="x" /><br />

    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { reactive, ref, watch } from 'vue';
export default {
  name: 'Calc5',
  setup() {
    const state = reactive({ x: 0, result: 0 });

    // 기본형 데이터는 watch에 직접 넣으면 반응형 동작이 안된다
    // 무조건 getter함수를 통해서 추적해야 한다.
    watch(
      () => state.x,
      (current, old) => {
        console.log(`${old}=>${current}`);
        state.result = current * 2;
      }
    );

    return { state };
  },
};
</script>
<style></style>
