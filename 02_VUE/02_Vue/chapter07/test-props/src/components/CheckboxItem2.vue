<template>
  <!-- 부모에서 객체를 통째로 넘겨줬기 때문에 자식에서 객체 접근 필요 -->
  <li><input type="checkbox" :checked="idol.checked" />{{ idol.name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem', // 이 컴포넌트의 이름
  //   부모 컴포넌트에게서 받아온 속성 배열
  props: ['idol'],
};
</script>
