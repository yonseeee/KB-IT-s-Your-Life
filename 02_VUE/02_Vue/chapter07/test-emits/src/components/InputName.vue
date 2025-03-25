<template>
  <div style="border: solid 1px gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <!-- nameChanged라는 이벤트명으로 name을 객체로ㅗ 감싸서 부모 컴포넌트로 전달 -->
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  data() {
    return { name: '' };
  },
};
</script>
