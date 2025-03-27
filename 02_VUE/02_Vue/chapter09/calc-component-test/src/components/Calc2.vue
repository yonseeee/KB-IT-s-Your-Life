<template>
  <div>
    X: <input type="text" v-model.number="x" /><br />
    Y: <input type="text" v-model.number="y" /><br />
    <button @click="calcAdd">계산</button><br />
    <div>결과 : {{ result }}</div>
  </div>
</template>
<script>
import { ref } from 'vue';
export default {
  name: 'Calc2',
  setup() {
    const x = ref(10);
    const y = ref(20);
    const result = ref(30);

    const calcAdd = () => {
      // result=x+y;  (X)
      // script 내부에서 ref값에 접근할 때는 .value를 사용한다.
      result.value = x.value + y.value;
    };

    // 템플릿에서 사용하도록 내보내줌
    return { x, y, result, calcAdd };
  },
};
</script>
<style></style>
