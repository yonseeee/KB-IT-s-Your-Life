<template>
  <div>
    <h2>콘솔을 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';

const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

const requestAPI = () => {
  let todoList = [];
  axios
    .get(listUrl)
    .then((response) => {
      todoList = response.data;
      console.log('# TodoList:' + todoList);
      return todoList[0].id;
    })
    .then((id) => {
      return axios.get(todoUrlPrefix + id);
    });
};

// const requestAPI = () => {
//   // const url = 'http://localhost:3000/todos/1';\
//   // 해당 url로 get 메소드 보낸 후 응답 데이터 출력
//   // 나의 서버에 대한 url
//   // 실제로는 proxy한테 전달해서 백엔드 서버에 요청 보내짐
//   // const url='/api/todos/1';

//   // // promise 응답
//   // // resolve됐을 때 response객체가
//   // axios.get(url).then((response) => {
//   //   console.log('#응답객체: ', response);
//   // });

//   const listUrl = '/api/todos';
//   const todoUrlPrefix = '/api/todos/';

//   const requestAPI = () => {
//     let todoList = [];
//     axios.get(listUrl);
//   };
// };

requestAPI();
</script>
