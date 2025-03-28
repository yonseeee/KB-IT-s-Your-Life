<template>
  <div class="card card-body">
    <h2>About</h2>
    <!-- 현재 route 객체의 전체 경로 -->
    <p>요청 경로: {{ $route.fullPath }}</p>
  </div>
</template>

<script>
export default {
  name: 'About',
  created() {
    // 옵션 API 버전으로 $route는 현재 매칭된 라우트 객체 의미
    console.log(this.$route);
  },
};
</script>
<style></style>
