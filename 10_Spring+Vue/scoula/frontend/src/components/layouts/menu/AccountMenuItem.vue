<script setup>
defineProps({ username: String });
</script>

<template>
  <li class="nav-item">
    <RouterLink class="nav-link" to="/auth/profile">
      <i class="fa-solid fa-user"></i>
      {{ username }}
    </RouterLink>
  </li>
</template>
