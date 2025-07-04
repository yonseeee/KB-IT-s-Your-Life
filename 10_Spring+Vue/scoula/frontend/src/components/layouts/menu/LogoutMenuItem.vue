<script setup>
import { useRouter } from 'vue-router';
import { useAuthStore } from '@/stores/auth';
const router = useRouter();
const store = useAuthStore();

const logout = (e) => {
  store.logout();
  router.push('/');
};
</script>

<template>
  <!-- #이니까 a태그 쓴것 -->
  <!-- prevent 수식어로 a 태그 기본 동작 방지 -->
  <a href="#" class="nav-link" @click.prevent="logout">
    <i class="fa-solid fa-right-from-bracket"></i>
    로그아웃
  </a>
</template>
