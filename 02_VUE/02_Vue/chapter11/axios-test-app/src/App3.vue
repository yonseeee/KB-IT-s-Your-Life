<template>
  <div>
    <h2>콘솔을 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';

const requestAPI = async () => {
  const url = '/api/todos';
  const response = await axios.get(url);
  console.log('# 응답객체 : ', response);
};

requestAPI();
</script>
