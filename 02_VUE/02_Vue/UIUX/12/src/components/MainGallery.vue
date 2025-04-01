<script setup lang="ts">
import BaseAlert from './UI/BaseAlert.vue'
import BaseButton from './UI/BaseButton.vue'
import BaseBadge from './UI/BaseBadge.vue'
</script>

<template>
  <main class="component-grid">
    <!-- 컴포넌트 그룹(그리드 아이템) -->
    <section class="component-card">
      <h2>버튼</h2>
      <BaseButton variant="primary"></BaseButton>
      <BaseButton variant="outline">Outline</BaseButton>
      <BaseButton variant="pill">Pill</BaseButton>
    </section>

    <section class="component-card">
      <h2>알림창</h2>
      <BaseAlert variant="success">success</BaseAlert>
      <BaseAlert variant="warning">warning</BaseAlert>
      <BaseAlert variant="error">error</BaseAlert>
    </section>
    <section class="component-card">
      <h2>뱃지</h2>
      <BaseBadge variant="success">success</BaseBadge>
      <BaseBadge variant="number">number</BaseBadge>
    </section>
  </main>
</template>
