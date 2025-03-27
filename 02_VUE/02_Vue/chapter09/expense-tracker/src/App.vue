<template>
  <div class="container mt-3">
    <ExpenseForm @add-item="listHandler"> </ExpenseForm>
    <br />
    <div>
      <p style="color: aquamarine">⭐ 지출 내역</p>
      <ExpenseList
        :lists="state.lists"
        @delete-item="deleteHandler2"
      ></ExpenseList>
    </div>

    <br />
    <p style="color: aquamarine">😅 카테고리별 지출 합계</p>
    <div v-show="state.lists.length > 0">
      <li style="list-style: none" class="item">
        🍕 식비: {{ categoryExpense.sum1.toLocaleString() }}원
      </li>
      <li style="list-style: none" class="item">
        🚗 교통: {{ categoryExpense.sum2.toLocaleString() }}원
      </li>
      <li style="list-style: none" class="item">
        🔥 쇼핑: {{ categoryExpense.sum3.toLocaleString() }}원
      </li>
    </div>

    <TotalDisplay
      :totalSum="totalSum"
      :formatNumber="formatNumber"
    ></TotalDisplay>
  </div>
</template>

<script>
import { reactive, computed } from 'vue';
import ExpenseForm from './components/ExpenseForm.vue';
import TotalDisplay from './components/TotalDisplay.vue';
import ExpenseList from './components/ExpenseList.vue';
export default {
  name: 'App',
  components: { ExpenseForm, TotalDisplay, ExpenseList },
  setup() {
    const state = reactive({ lists: [] });
    const listHandler = (a, b, c) => {
      console.log(`c: ${c}`);
      state.lists.push({ name: a, price: b, category: c });
    };
    const totalSum = computed(() => {
      let sum = 0;
      for (let i of state.lists) {
        sum += i.price;
      }
      return sum;
    });

    const formatNumber = (num) => {
      return '₩' + num.toLocaleString();
    };

    const deleteHandler2 = (index) => {
      state.lists.splice(index, 1);
    };

    const categoryExpense = computed(() => {
      let sum1 = 0,
        sum2 = 0,
        sum3 = 0;
      state.lists.forEach((element) => {
        if (element.category === '식비') sum1 += element.price;
        else if (element.category === '교통') sum2 += element.price;
        else sum3 += element.price;
      });

      return { sum1, sum2, sum3 };
    });

    return {
      state,
      listHandler,
      totalSum,
      formatNumber,
      deleteHandler2,
      categoryExpense,
    };
  },
};
</script>
<style scoped>
.container {
  width: 600px;
  padding: 10px;
  background-color: rgb(54, 53, 53);
  border-radius: 10px;
}
.item {
  background-color: rgb(62, 60, 60);
  color: white;
  border-radius: 5px;
  padding: 5px;
  margin: 5px;
}
</style>
