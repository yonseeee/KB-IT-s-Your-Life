<template>
  <div>
    <h2>콘솔을 확인</h2>
  </div>
</template>
<script setup>
import axios from 'axios';

// 개발자용 에러 처리
const requestAPI = async () => {
  try {
    const response = await axios.get(url, { timeout: 900 });
    console.log('#응답 객체 : ', response);
  } catch (e) {
    console.log('## 다음 오류가 발생했습니다.');
    if (e instanceof Error) console.log(e.message);
    else console.log(e);
  }
};

requestAPI();
</script>
