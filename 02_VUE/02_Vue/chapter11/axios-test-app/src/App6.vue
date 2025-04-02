<template>
  <div></div>
</template>
<script>
import axios from 'axios';

const requestAPI = async () => {
  const url = '/api/todos2';
  axios.get(url, { timeout: 900 }).then((response) => {
    console.log('#응답객체: ', response);
  });
};
</script>
<style></style>
