<template>
  <div></div>
</template>
<script setup>
import axios from 'axios';

const requestAPI = () => {
  const url = 'http://localhost:3000/movies';
  axios.get(url).then((response) => {
    console.log('# 응답객체: ', response);
  });
};

requestAPI();
</script>
<style></style>
