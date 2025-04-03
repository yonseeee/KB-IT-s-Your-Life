<template>
  <div class="row">
    <div class="col p-3">
      <h2>할 일 추가</h2>
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
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="addTodoHandler"
        >
          추가
        </button>
        <button
          type="button"
          class="btn btn-primary m-1"
          @click="router.push('/todos')"
        >
          취소
        </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { inject, reactive } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();

const { addTodo } = inject('actions');
const todoItem = reactive({ todo: '', desc: '' });

const addTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim === '') {
    alert('할일은 반드시 입력해야 합니다');
    return;
  }

  addTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};

// const addTodoHandler = () => {
//   let { todo } = todoItem;
//   if (!todo || todo.trim === '') {
//     alert('할일은 반드시 입력해야 합니다');
//     return;
//   }
//   //   addTodo(todoItem)이렇게 하지 않은 이유?
//   //이거는 reactive객체(proxy객체)  => 순수한 데이터에 proxy객체를 넣게 됨. 잘못된 데이터이다

//   //   펼치면 순수데이터 객체로 만들수 있음
//   addTodo({ ...todoItem }); //객체 복사
//   router.push('/todos');
// };
</script>
