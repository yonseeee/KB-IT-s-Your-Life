<template>
  <li
    :class="
      todoItem.done
        ? 'list-group-item list-group-item-success'
        : 'list-group-item'
    "
  >
    <!-- todo-done은 main.css에서 정의하고 있다 -->
    <span
      :class="todoItem.done ? 'todo-done pointer' : 'pointer'"
      @click="toggleDone(todoItem.id)"
    >
      {{ todoItem.todo }}
      {{ todoItem.done ? '(완료)' : '' }}
    </span>
    <span
      class="float-end badge bg-secondary pointer m-1"
      @click="router.push(`/todos/edit/${todoItem.id}`)"
      >편집
    </span>
    <!-- router.push({name:~, params:{id}}) -->
    <span
      class="float-end badge bg-secondary pointer m-1"
      @click="deleteTodo(todoItem.id)"
      >삭제
    </span>
  </li>
</template>
<script setup>
import { useRouter } from 'vue-router';
import { inject } from 'vue';

defineProps({
  todoItem: { type: Object, required: true },
});

const router = useRouter();

// 분해 할당
const { deleteTodo, toggleDone } = inject('actions');
</script>
