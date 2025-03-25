<template>
  <h2>메뉴 선택</h2>

  <span v-for="(menu, index) in menus" :key="index">
    <button
      style="margin: 5px"
      @click="$emit('select-drink', menu)"
      type="button"
      value="{{ menu.name }}"
    >
      {{ menu.name }} ({{ menu.price }})
    </button>
  </span>
</template>

<script>
export default {
  name: 'MenuList',
  props: ['menus'],
  emits: ['select-drink'],
  borderStyle: {
    border: '2px solid blue',
  },
  data() {
    return {
      name: '',
    };
  },
};
</script>
