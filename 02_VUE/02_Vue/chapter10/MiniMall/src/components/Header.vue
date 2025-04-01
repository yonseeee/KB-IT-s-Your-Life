<template>
  <div>
    <nav class="navbar navbar-expand-sm justify-content-center">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" :to="{ name: 'home' }">홈</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{ name: 'products' }"
            >상품 목록</router-link
          >
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{ name: 'cart' }"
            >장바구니</router-link
          >
        </li>
      </ul>
    </nav>
  </div>
</template>
<script>
export default {};
</script>
<style scoped>
.navbar {
  box-shadow: 0 4px 10px rgb(0, 0, 0, 0.5);
}
.navbar-nav {
  gap: 1rem;
}
.nav-item {
  font-size: 1.25rem;
}
.router-link-active {
  color: rgb(82, 131, 177) !important;
  font-weight: bold;
}
</style>
