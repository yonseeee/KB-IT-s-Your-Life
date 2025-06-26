<script setup>
import { useRouter } from 'vue-router';
const router = useRouter();

const logout = (e) => {
  router.push('/');
};
</script>

<template>
  <!-- #이니까 a태그 쓴것 -->
  <a href="#" class="nav-link" @click.prevent="logout">
    <i class="fa-solid fa-right-from-bracket"></i>
    로그아웃
  </a>
</template>
