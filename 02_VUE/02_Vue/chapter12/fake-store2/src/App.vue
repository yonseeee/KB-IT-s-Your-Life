<template>
  <div class="container">
    <div class="mt-4 p-5 text-white" id="jumbotron">
      <h1>Fake Store</h1>
      <p>Vue3 연습 사이트</p>
    </div>

    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
      <span class="navbar-brand">
        <router-link class="nav-link" to="/"
          ><i class="fa-solid fa-house"></i>Fake Store</router-link
        >
      </span>
      <button class="navbar-toggler" type="button" @click="changeIsNavShow">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div :class="navClass">
        <ul class="navbar-nav">
          <li class="nav-item">
            <router-link class="nav-link" to="/electronics"
              ><i class="fa-solid fa-tv"></i>가전</router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/jewelery"
              ><i class="fa-solid fa-gem"></i>주얼리</router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/mensclothing"
              ><i class="fa-solid fa-person"></i>남성의류</router-link
            >
          </li>
          <li class="nav-item">
            <router-link class="nav-link" to="/womenclothing"
              ><i class="fa-solid fa-person-dress"></i>여성의류</router-link
            >
          </li>
        </ul>
      </div>
    </nav>

    <router-view></router-view>
    <p style="color: gray">ⓒ COPYRIGHT SEYEON KIM.</p>
  </div>
</template>
<script>
import { reactive, computed } from 'vue';
export default {
  name: 'App',

  setup() {
    const state = reactive({ isNavShow: false });

    // isNavShow 값에 따라서 각각 다른 클래스가 바인딩된다
    const navClass = computed(() =>
      state.isNavShow
        ? 'collapse navbar-collapse show'
        : 'collapse navbar-collapse'
    );

    const changeIsNavShow = () => {
      state.isNavShow = !state.isNavShow;
    };

    return { state, changeIsNavShow, navClass };
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css');
.container {
  text-align: center;
  margin-top: 10px;
}
#jumbotron {
  background-color: rgb(215, 172, 227);
  text-align: left;
}
</style>
