<template>
  <div>
    <img :src="product.image" />
    <p>{{ product.name }}</p>
    <p>{{ product.price.toLocaleString() }}원</p>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
// @/ : src
import products from '@/data/products.json';
export default {
  name: 'ProductDetail',
  setup() {
    const currentRoute = useRoute();
    const id = parseInt(currentRoute.params.id, 10);
    const product = products.find((p) => p.id === id);

    return { product };
  },
};
</script>

<style scoped>
img {
  width: 300px;
  margin: 0 auto;
}

div {
  text-align: center;
}
</style>
