<template>
  <div class="row">
    <div class="col p-3">
      <!-- 버튼 모양으로 router-link만들기 -->
      <router-link class="btn btn-primary" to="/todos/add">
        할 일 추가
      </router-link>
      <button class="btn btn-primary ms-1" @click="fetchTodoList">
        새로고침
      </button>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoItem
          v-for="todoItem in todoList"
          :key="todoItem.id"
          :todoItem="todoItem"
        />
      </ul>
      <span>완료된 할일: {{ doneCount }}</span>
    </div>
  </div>
</template>
<script setup>
import { computed } from 'vue';
import { useTodoListStore } from '@/stores/todoList';
import TodoItem from '@/components/TodoItem.vue';

const todoListStore = useTodoListStore();
const { fetchTodoList } = todoListStore();
const doneCount = computed(() => todoListStore.doneCount);
const todoList = computed(() => todoListStore.todoList);
</script>
