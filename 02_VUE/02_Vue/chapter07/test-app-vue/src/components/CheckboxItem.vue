<template>
  <li><input type="checkbox" v-model="checked" />옵션 1</li>
</template>

<script>
export default {
  name: 'CheckboxItem', // 이 컴포넌트의 이름
  data() {
    return {
      checked: false,
    };
  },
};
</script>
