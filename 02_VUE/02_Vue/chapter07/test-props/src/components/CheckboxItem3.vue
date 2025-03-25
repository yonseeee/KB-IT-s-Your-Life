<template>
  <!-- 체크 박스의 체크 여부 = "부모한테서 받아온 불린값" -->
  <li><input type="checkbox" :checked="checked" />{{ id }} - {{ name }}</li>
</template>

<script>
export default {
  name: 'CheckboxItem',

  props: {
    id: [Number, String], //id 값은 Number나 String 타입
    name: String, //name 값은 String 타입
    checked: {
      type: Boolean,
      required: false,
      default: false,
    },
  },
};
</script>
