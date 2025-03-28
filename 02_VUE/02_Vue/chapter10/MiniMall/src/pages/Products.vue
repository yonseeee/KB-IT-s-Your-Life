<template>
  <div style="text-align: center">
    <br />
    <h3>상품 목록 페이지입니다.</h3>

    <div class="row justify-content-center" id="content">
      <div class="col-3" v-for="(product, index) in products" :key="index">
        <div class="card">
          <div class="card-body">
            <img :src="product.image" />
            <p>{{ product.name }}</p>
            <p>{{ product.price.toLocaleString() }}원</p>
            <router-link :to="'/products/' + product.id">상세보기</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import products from '@/data/products.json';

export default {
  name: 'Products',
  setup() {
    return { products };
  },
};
</script>
<style scoped>
img {
  width: 150px;
  margin-bottom: 10px;
}

.col-3 {
  text-align: center;
  /* margin: 3px; */
  margin-bottom: 10px;
}
.card {
  width: 180px;
  margin: auto;
  height: 290px;
}
.row {
}
p {
  margin: 0;
}
</style>
