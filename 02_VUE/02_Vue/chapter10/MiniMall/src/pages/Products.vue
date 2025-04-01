<template>
  <div>
    <br />
    <p>상품 목록 페이지입니다.</p>

    <div class="row">
      <div class="col-4 col-sm-3" v-for="(item, index) in items" :key="index">
        <div class="card">
          <img :src="item.image" />
          <p>{{ item.name }}</p>
          <p>{{ item.price.toLocaleString() }}</p>
          <router-link
            class="goto-detail"
            :to="{ name: 'products/id', params: { id: item.id } }"
            >상세보기</router-link
          >
          <br />
        </div>

        <!-- hello -->
      </div>
    </div>
  </div>
</template>

<script setup>
import products from '@/data/products.json';
const items = products;
</script>
<!-- <script>
import products from '@/data/products.json';
export default {
  setup() {
    const items = products;

    return { items };
  },
};
</script> -->
<style scoped>
.row {
  padding: 1rem;
}
.col-4 {
  margin-bottom: 1rem;
}
.card {
  /* background-color: white; */
  /* position: relative; */
  align-items: center;
  padding: 0;

  height: 100%;
  /* align-content: center; */
}
img {
  width: 100%;
  padding: 1rem;
  border-radius: 20px;
}
p {
  margin: 0;
}
.goto-detail {
  color: rgb(58, 192, 149);
  text-decoration: none;
}
</style>
