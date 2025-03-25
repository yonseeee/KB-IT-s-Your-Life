<style>
.statisticButton {
  background-color: #8fbc8f;
  color: white;
  padding: 20px;
  border-radius: 6px;
}
.statisticButton:hover {
  background-color: #78a678;
}
</style>
<template>
  <h1>카페 선택 앱 ☕</h1>
  <MenuList :menus="menuList" @select-drink="drinkHandler" />
  <br /><br />
  <p style="background-color: lightgray; height: 30px">
    선택한 음료: {{ selectedDrink.name }}
  </p>

  <DrinkOptions
    :selectedDrink="selectedDrink"
    @option-changed="selectionHandler"
  />

  <br />
  <div style="background-color: lightgray">
    현재 선택 옵션: <br />
    사이즈: {{ size }} <br />
    샷 추가:
    <span v-if="add">추가함</span>
    <span v-else>없음</span>
    <br />
    얼음 양:{{ ice }}
  </div>
  <br />
  <OrderSummary
    @send-order="orderListHander"
    :drink="selectedDrink"
    :optionData="{ size, add, ice }"
  />
  <br /><br />
  <br />
  <OrderHistory :orders="orders" />

  <br />

  <button
    class="statisticButton"
    v-show="!showStatus"
    @click="
      () => {
        showStatus = true;
      }
    "
    type="button"
  >
    통계 보기
  </button>
  <button
    class="statisticButton"
    v-show="showStatus"
    @click="
      () => {
        showStatus = false;
      }
    "
    type="button"
  >
    통계 숨기기
  </button>
  <Statistic v-show="showStatus" :orders="orders" />
</template>

<script>
import MenuList from './components/MenuList.vue';
import DrinkOptions from './components/DrinkOptions.vue';
import OrderSummary from './components/OrderSummary.vue';
import OrderHistory from './components/OrderHistory.vue';
import Statistic from './components/Statistic.vue';

export default {
  name: 'App',
  components: { MenuList, DrinkOptions, OrderSummary, OrderHistory, Statistic },

  data() {
    return {
      menuList: [
        { name: '아메리카노', price: 4000 },
        { name: '카페라떼', price: 4500 },
        { name: '바닐라라떼', price: 4800 },
        { name: '콜드브루', price: 5000 },
      ],
      selectedDrink: {},
      size: '',
      add: '',
      ice: '',
      orders: [],
      showStatus: false,
    };
  },
  methods: {
    drinkHandler(e) {
      console.log(e);
      this.selectedDrink = e;
    },
    selectionHandler(a, b, c) {
      console.log('selection');
      this.size = a;
      if (b) this.add = '추가함';
      else this.add = '없음';
      this.ice = c;
    },
    orderListHander() {
      this.orders.push({
        time: new Date().toLocaleString(),
        drinkName: this.selectedDrink.name,
        size: this.size,
        extraShot: this.add,
        ice: this.ice,
        price: this.selectedDrink.price,
      });
      console.log(this.orders);
    },
  },
};
</script>
