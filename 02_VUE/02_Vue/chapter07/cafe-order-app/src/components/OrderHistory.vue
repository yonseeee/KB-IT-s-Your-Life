<template>
  <div class="container">
    <h1>🥛 주문 내역</h1>
    <div v-if="orders.length === 0">주문 내역이 없습니다</div>

    <div v-else v-for="(order, index) in orders.reverse()" :key="index">
      🧭 {{ order.time }} <br />
      음료:{{ order.drinkName }} <br />
      사이즈: {{ order.size }} <br />
      추가샷: {{ order.extraShot }} <br />
      얼음 양: {{ order.ice }} <br />
      금액: {{ order.price }}
      <hr />
    </div>
  </div>
</template>

<script>
export default {
  name: 'OrderHistory',
  props: ['orders'],
  data() {
    return {};
  },
  method: {},
};
</script>
