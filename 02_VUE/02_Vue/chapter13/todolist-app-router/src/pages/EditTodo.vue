<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 수정</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할 일 :</label>
        <input
          type="text"
          class="form-control"
          id="todo"
          v-model="todoItem.todo"
        />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명 :</label>
        <textarea
          class="form-control"
          rows="3"
          id="desc"
          v-model="todoItem.desc"
        ></textarea>
      </div>
      <div class="form-group">
        <label htmlFor="done">완료여부: </label>;
        <input type="checkbox" v-model="todoItem.done" />
      </div>
      <div class="form-group">
        <!-- :disabled=[계산된 속성]으로 조건 채워지지 않으면 버튼 동작 안하게 하는 게 더 좋아보임~~ -->
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="updateTodoHandler"
        >
          수 정
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취 소
        </button>
      </div>
    </div>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useTodoListStore } from '@/stores/todoList';

const router = useRouter();
const currentRoute = useRoute();

const { todoList, updateTodo } = useTodoListStore();

const matchedTodoItem = todoList.find(
  (item) => item.id === currentRoute.params.id
);
if (!matchedTodoItem) {
  router.push('/todos');
}
const todoItem = reactive({ ...matchedTodoItem });
// // 왜 value???
// // todoList는 computed속성이다!!
// // =>computed속성은 ref객체랑 같다
// // find는 해당 element의 참조를 리턴(못 찾으면 null/undefined)
// // findIndex는 인덱스를 찾아줌(못 찾으면 -1 리턴)
// const matchedTodoItem = todoList.value.find(
//   (item) => item.id === parseInt(currentRoute.params.id)
// );
// if (!matchedTodoItem) {
//   router.push('/todos');
// }

const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할 일은 반드시 입력해야 합니다');
    return;
  }
  updateTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};

// 또 왜 펼쳤는가
// 원본 데이터로 연결하면 어떻게 될까? reactive(matchedTodoItem)
// 수정하려다가 취소버튼 누르면 이미 원본이 변경되고 난 후
// =>원본과의 관계를 끊기 위해서 복사본으로 넘겨준 것이다.!!
// const todoItem = reactive({ ...matchedTodoItem });

// const updateTodoHandler = () => {
//   let { todo } = todoItem;
//   if (!todo || todo.trim() === '') {
//     alert('할 일은 반드시 입력해야 합니다');
//     return;
//   }
//   updateTodo({ ...todoItem });
//   router.push('/todos');
// };
</script>
