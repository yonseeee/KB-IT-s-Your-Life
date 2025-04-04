<template>
  <div class="container">
    <Header />
    <router-view></router-view>
    <Loading v-if="isLoading" />
  </div>
</template>

<script setup>
//초기 데이터 준비

import { computed } from 'vue';
import Header from '@/components/Header.vue';
import { useTodoListStore } from '@/stores/todoList.js';
import Loading from '@/components/Loading.vue';

const todoListStore = useTodoListStore();
const isLoading = computed(() => todoListStore.isLoading);
const fetchTodoList = todoListStore.fetchTodoList;
fetchTodoList();

// import { reactive, computed, provide } from 'vue';
// import Header from '@/components/Header.vue';
// import axios from 'axios';

// const BASEURI = '/api/todos';
// const states = reactive({ todoList: [] });
// // states.todoList=[  ]   ->todoList내용 싹 바꾸고 싶을 때 용이하다
// // const states = reactive({
// //   todoList: [
// //     { id: 1, todo: 'ES6학습', desc: '설명1', done: false },
// //     { id: 2, todo: 'React학습', desc: '설명2', done: false },
// //     { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
// //     { id: 4, todo: '야구경기 관람', desc: '설명4', done: false },
// //   ],
// // });
// const fetchTodoList = async () => {
//   try {
//     const response = await axios.get(BASEURI);
//     if (response.status === 200) {
//       states.todoList = response.data;
//     } else {
//       alert('데이터 조회 실퍂');
//     }
//   } catch (error) {
//     alert('에러발생:' + error);
//   }
// };

// const addTodo = async ({ todo, desc }, successCallback) => {
//   try {
//     const payload = { todo, desc };
//     const response = await axios.post(BASEURI, payload);
//     if (response.status === 201) {
//       states.todo.push({ ...response.data, done: false });
//       successCallback();
//     } else {
//       alert('Todo 추가 실패');
//     }
//   } catch (error) {
//     alert('에러 발생' + error);
//   }
// };
// // const addTodo = ({ todo, desc }) => {
// //  //todo:todo 줄임
// //   states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
// // };
// const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
//   try {
//     const payload = { id, todo, desc, done };
//     const response = await axios.put(BASEURI + `${id}`, payload);
//     if (response.status === 200) {
//       let index = states.todoList.findIndex((todo) => todo.id === id);
//       states.todoList[index] = payload;
//       successCallback();
//     } else {
//       alert('Todo 추가 실패');
//     }
//   } catch (error) {
//     alert('에러 발생' + error);
//   }
// };

// // const updateTodo = ({ id, todo, desc, done }) => {
// // // 사용자에게 받아온 id와 일치하는 객체의 인덱스 찾기
// //   let index = states.todoList.findIndex((todo) => todo.id === id);
// //   // 다른 언어였다면 a[ix].todo=todo; a[ix].desc=desc; a[ix].done=done 이런 식으로 하나씩 해야함
// //  // 전개 연산자로 기존 값 복사 후 받아온 값 추가
// //   states.todoList[index] = { ...states.todoList[index], todo, desc, done };
// // };

// const deleteTodo = async (id) => {
//   try {
//     const response = await axios.delete(BASEURI + `/${id}`);
//     console.log(response.status, response.data);
//     if (response.status === 200) {
//       let index = states.todoList.findIndex((todo) => todo.id === id);
//       states.todoList.splice(index, 1);
//     } else {
//       alert('Todo 삭제 실패');
//     }
//   } catch (error) {
//     alert('에러 발생');
//   }
// };

// // const deleteTodo = (id) => {
// //   let index = states.todoList.findIndex((todo) => todo.id === id);
// //   states.todoList.splice(index, 1);
// //   // Array.prototype.removeAt() 정의하면 todoList.removeAt()으로 간단하게 삭제 가능!! 한 번 해보기
// // };

// const toggleDone = async (id) => {
//   try {
//     let todo = states.todoList.find((todo) => todo.id === id);
//     let payload = { ...todo, done: !todo.done };
//     const response = await axios.put(BASEURI + `/${id}`, payload);
//     if (response.status === 200) {
//       todo.done = payload.done;
//     } else {
//       alert('Todo 삭제 실패');
//     }
//   } catch (error) {
//     alert('에러 발생');
//   }
// };

// // const toggleDone = (id) => {
// //   let index = states.todoList.findIndex((todo) => todo.id === id);
// //   states.todoList[index].done = !states.todoList[index].done;
// // };

// // 왜 굳이 computed를 썼을까 어차피 reactive인데
// // 읽기 전용으로 만들기 위해서
// // provide('todoList', states.todoList)=>하위 컴포넌트 어디에서도 수정 가능
// provide(
//   'todoList',
//   computed(() => states.todoList)
// );
// provide('actions', {
//   addTodo,
//   deleteTodo,
//   toggleDone,
//   updateTodo,
//   fetchTodoList,
// });
</script>
