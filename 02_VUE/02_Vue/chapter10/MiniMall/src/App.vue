<template>
  <div>
    <Header />
    <div class="changePart">
      <router-view></router-view>
    </div>
  </div>
</template>
<script>
import Header from '@/components/Header.vue';
import { provide } from 'vue';
import { reactive } from 'vue';
export default {
  name: 'App',
  components: { Header },
  setup() {
    const cart = reactive({ items: [] });
    const addToCart = (product) => {
      cart.items.push(product);
    };
  },
};
</script>
<style>
.changePart {
  background-color: lightgray;
  height: 100%;
}
</style>
