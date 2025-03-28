<template>
  <div>
    <nav id="nav" class="navbar navbar-expand-md bg-light navbar-light mt-2">
      <ul class="navbar-nav">
        <li class="nav-item">
          <!-- router-link는 a 태그처럼 동작, to 경로로 이동 -->
          <!-- router/index.js에 명시된 to 경로와 연결된 컴포넌트로 이동 -->
          <router-link class="nav-link" to="/">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/products">상품목록</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/cart">장바구니</router-link>
        </li>
      </ul>
    </nav>
  </div>
</template>
<script>
export default {
  name: 'Header',
  setup() {},
};
</script>
<style scoped>
.navbar {
  box-shadow: 2px 2px 5px;
  margin: 2px auto;
}
.nav-item {
  margin: 0 20px;
}
.navbar-nav {
  margin: 0 auto;
}
.router-link-active {
  color: rgb(211, 118, 188) !important;
  font-weight: bold;
}
</style>
