<style>
.static {
  background-color: #e6ffe6;
  border: 2px solid #8fbc8f;
  border-radius: 6px;
}
</style>
<template>
  <div class="static">
    <h1>주문 통계</h1>
    총 주문 횟수: {{ orders.length }}회 <br />
    총 매출: {{ sumPrice }}원 <br />
    가장 인기 있는 음료: {{ popular.name }} {{ popular.cnt }}회<br />
    가장 많이 선택된 사이즈: {{ bestSize.name }}<br />
    추가 샷 비율: {{ extrashotRatio }} %<br />
  </div>
</template>

<script>
export default {
  name: 'Statistic',
  props: ['orders'],
  data() {},
  computed: {
    sumPrice() {
      let sum = 0;
      this.orders.forEach((element) => {
        sum += element.price;
      });

      return sum;
    },
    popular() {
      let a = 0,
        b = 0,
        c = 0,
        d = 0;
      this.orders.forEach((element) => {
        if (element.drinkName === '아메리카노') a++;
        else if (element.drinkName === '카페라떼') b++;
        else if (element.drinkName === '바닐라라떼') c++;
        else d++;
      });
      let result = Math.max(...[a, b, c, d]);
      console.log(`result: ${result}`);
      if (a === result) return { name: '아메리카노', cnt: result };
      else if (b === result) return { name: '카페라떼', cnt: result };
      else if (c === result) return { name: '바닐라라떼', cnt: result };
      else return { name: '콜드브루', cnt: result };
    },
    bestSize() {
      let a = 0,
        b = 0,
        c = 0;
      this.orders.forEach((element) => {
        if (element.size === 'small') a++;
        else if (element.size === 'medium') b++;
        else c++;
      });
      let result = Math.max([a, b, c]);
      if (a === result) return { name: 'small', cnt: result };
      else if (b === result) return { name: 'medium', cnt: result };
      else return { name: 'large', cnt: result };
    },
    extrashotRatio() {
      let count = 0;
      this.orders.forEach((element) => {
        if (element.extraShot === '추가함') count++;
      });
      console.log(`추가횟수: ${count}`);
      return (
        (parseFloat(count) / parseFloat(this.orders.length)) *
        100
      ).toFixed(0);
    },
  },
};
</script>
