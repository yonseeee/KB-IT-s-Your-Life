<script setup>
import { defineAsyncComponent } from 'vue'
// import TheWelcome from '../components/TheWelcome.vue'

const TheWelcome = defineAsyncComponent(() => import('../components/TheWelcome.vue'))
</script>

<template>
  <main>
    <TheWelcome />
  </main>
</template>
