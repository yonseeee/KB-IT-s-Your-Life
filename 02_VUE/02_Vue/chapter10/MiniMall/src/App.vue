<template>
  <div>
    <Header />
    <div class="layout">
      <router-view class="left-view" name="left"></router-view>
      <main class="main">
        <router-view class="router-view"></router-view>
      </main>
    </div>
  </div>
</template>
<script setup>
import { reactive } from 'vue';
import { provide } from 'vue';

import Header from './components/Header.vue';

const status = reactive({ cart: [] });
const addToCart = (product) => {
  status.cart.push(product);
  console.log(status.cart);
};
provide('status', status);
provide('addToCart', addToCart);
</script>
<!-- <script>
import { reactive } from 'vue';
import { provide } from 'vue';

import Header from './components/Header.vue';
export default {
  components: { Header },
  setup() {

    // return { status, addToCart };
  },
};
</script> -->
<style scoped>
Header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  background-color: #fff;
  z-index: 1000; /* Header가 다른 요소들 위에 있도록 설정 */
}
.layout {
  display: flex;
  justify-content: space-evenly;
  padding: 1rem;
  background-color: rgb(217, 227, 231);
}
.left-view {
  /* background-color: rgb(217, 227, 231); */
  margin: 0;
}

.router-view {
  justify-content: center;
  height: 100%;
  /* background-color: rgb(217, 227, 231); */
  text-align: center;
  justify-content: center;
  justify-items: center;
  align-items: center;
}
</style>
