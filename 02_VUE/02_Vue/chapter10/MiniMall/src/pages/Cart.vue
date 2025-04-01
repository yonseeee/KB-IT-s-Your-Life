<template>
  <div class="cart-page">
    <br /><br /><br /><br />
    <p style="font-size: 1.25rem">🛒 장바구니</p>

    <ul class="list">
      <li
        style="list-style: none"
        class="list-item"
        v-for="(item, index) in injectedCart"
        :key="index"
      >
        <div>
          <img :src="item.image" alt="" />
        </div>
        <div class="desc">
          <h5>{{ item.name }}</h5>
          <p>{{ item.price.toLocaleString() }}원</p>
        </div>
      </li>
    </ul>
    <br />
    <p style="font-size: 1.25rem">총합: {{ totalSum.toLocaleString() }}원</p>
    <br />
  </div>
</template>

<script setup>
import { inject, computed } from 'vue';
const injectedCart = inject('status').cart;

const totalSum = computed(() => {
  return injectedCart.reduce((acc, cur) => (acc += cur.price), 0);
});
</script>
<!-- <script>
import { inject, computed } from 'vue';
export default {
  setup() {
    const injectedCart = inject('status').cart;

    const totalSum = computed(() => {
      return injectedCart.reduce((acc, cur) => (acc += cur.price), 0);
    });
    return { injectedCart, totalSum };
  },
};
</script> -->
<style scoped>
img {
  width: 120px;
  height: 120px;
  border-radius: 20px;
}
.list {
  width: 600px;
  justify-content: center;
  align-items: center;
  margin: 0 auto;
}
.list-item {
  width: 100%;
  display: flex;
  border-bottom: 1px solid rgb(185, 181, 181);
  padding: 0.5rem;
}
.desc {
  text-align: left;
  align-content: center;
  /* justify-content: center; */
  padding-left: 1rem;
}
</style>
