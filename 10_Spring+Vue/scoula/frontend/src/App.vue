<script setup>
import { RouterView } from 'vue-router';
import DefaultLayout from './components/layouts/DefaultLayout.vue';
</script>

<template>
  <DefaultLayout>
    <!-- RouterView가 DefaultLayout의 slot으로 들어감 -->
    <RouterView />
  </DefaultLayout>
</template>

<style scoped></style>
