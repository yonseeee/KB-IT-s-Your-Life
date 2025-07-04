<script setup>
const props = defineProps({ username: String });

// 아바타 이미지 경로를 username을 이용해 생성
const avatar = `/api/member/${props.username}/avatar`;
</script>

<template>
  <li class="nav-item">
    <RouterLink class="nav-link" to="/auth/profile">
      <img :src="avatar" class="avatar avatar-sm" />
      {{ username }}
    </RouterLink>
  </li>
</template>
