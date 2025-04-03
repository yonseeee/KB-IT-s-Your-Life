<template>
  <div>
    <div class="grid-item">
      <h3>{{ props.study.title }}</h3>
      <p>📌 카테고리: {{ props.study.category }}</p>
      <p>📅 등록일: {{ props.study.createdAt }}</p>
      <p>📆 마감일: {{ props.study.dueDate }}</p>
      <p>💙 좋아요: {{ props.study.likes }}</p>
      <span class="badge bg-success">
        D-{{
          Math.ceil(
            (new Date(study.dueDate).getTime() - new Date().getTime()) /
              (1000 * 3600 * 24)
          )
        }}</span
      >
    </div>
  </div>
</template>
<script setup>
const props = defineProps({
  study: { type: Object, required: true },
});
</script>
<style scoped>
.grid-item {
  border: 2px solid black;
  border-radius: 5px;
  margin: 1rem;
  padding: 1rem;
  height: 90%;
}
p {
  margin: 0;
  font-size: 0.8rem;
}
h3 {
  font-weight: bold;
}
</style>
