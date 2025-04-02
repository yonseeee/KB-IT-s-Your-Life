<template>
  <div>
    <h2>콘솔을 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';

const requestAPI = async () => {
  try {
    const url = '/api/todos';
    let data = { todo: '윗몸일으키기 3세트', desc: '너무 빠르지 않게...' };
    const resp1 = await axios.post(url, data);
    console.log(resp1, data);
  } catch (e) {
    console.error(e);
  }
};

requestAPI();
</script>
