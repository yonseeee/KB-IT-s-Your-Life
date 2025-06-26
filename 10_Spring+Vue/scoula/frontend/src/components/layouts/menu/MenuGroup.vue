<script setup>
import MenuItem from './MenuItem.vue';
const props = defineProps({
  menus: { Type: Array, required: true },
});
</script>

<template>
  <ui class="navbar-nav">
    <!-- :menu는 자식한테 넘겨줄 props -->
    <MenuItem v-for="menu in menus" :key="menu.url" :menu="menu"></MenuItem>
  </ui>
</template>
