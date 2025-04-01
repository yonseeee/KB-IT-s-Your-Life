<template>
  <div>
    <br /><br />
    <div class="item">
      <p style="font-size: 1.25rem">
        {{ item.name }}
      </p>
      <img :src="item.image" alt="" />
      <p style="margin-top: 1rem">가격: {{ item.price.toLocaleString() }}원</p>
      <button @click="cartHandler(item)" class="btn btn-primary">
        장바구니 담기
      </button>
      <br /><br />

      <router-link
        class="link"
        :to="'/products/' + id + '/desc'"
        exact-active-class="active-tab"
        >상세정보</router-link
      >

      <router-link
        class="link"
        :to="'/products/' + id + '/review'"
        exact-active-class="active-tab"
        >리뷰</router-link
      >
      <br /><br />
      <router-view class="router_view"></router-view>
    </div>
    <br /><br />
  </div>
</template>
<script setup>
import { useRoute, useRouter } from 'vue-router';
import { inject } from 'vue';
import products from '@/data/products.json';

const currentRoute = useRoute();
const router = useRouter();
const id = parseInt(currentRoute.params.id, 10);
const item = products.find((p) => p.id === id);

const addToCart = inject('addToCart');
const cartHandler = (item) => {
  addToCart(item);
  router.push({ name: 'cart' });
};
</script>
<!-- <script>
import { useRoute, useRouter } from 'vue-router';
import { inject } from 'vue';
import products from '@/data/products.json';
export default {
  setup() {
    const currentRoute = useRoute();
    const router = useRouter();
    const id = parseInt(currentRoute.params.id, 10);
    const item = products.find((p) => p.id === id);

    const addToCart = inject('addToCart');
    const cartHandler = (item) => {
      addToCart(item);
      router.push({ name: 'cart' });
    };
    return { item, id, cartHandler };
  },
};
</script> -->
<style scoped>
.item {
  width: 500px;
  justify-self: center;
}
img {
  border-radius: 10px;
  width: 60%;
}
.btn-primary {
  font-size: 0.9rem;
}
.link {
  font-size: 0.9rem;
  text-decoration: none;
  color: rgb(32, 32, 32);
  margin: 1rem;
}
.router-link-active {
  background-color: #007bff;
  padding: 8px;
  color: white;
  border-radius: 5px;
}
.router_view {
  width: 100%;
  font-size: 0.9rem;
  justify-content: center;
}
</style>
