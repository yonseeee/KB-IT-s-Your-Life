<template>
  <div>
    <h1>💸 Simple Budget Diary</h1>
    <div style="display: flex; align-items: center">
      <input type="text" placeholder="항목명 입력" v-model="item" />
      <input type="text" v-model.number="price" />
      <select @change="sHandler" v-model="category">
        <!-- <option selected disabled hidden>카테고리</option> -->
        <option value="식비">식비</option>
        <option value="교통">교통</option>
        <option value="쇼핑">쇼핑</option>
      </select>

      <button @click="priceHandler">추가</button>
    </div>
  </div>
</template>

<script>
import { ref } from 'vue';
export default {
  name: 'ExpenseForm',
  setup(props, context) {
    const item = ref('');
    const price = ref(0);
    const category = ref('');

    const priceHandler = () => {
      console.log(item.value, price.value, category.value);
      context.emit('add-item', item.value, price.value, category.value);
      item.value = '';
      price.value = 0;
    };

    const sHandler = (e) => {
      category.value = e.target.value;
    };

    return { item, price, priceHandler, sHandler };
  },
};
</script>
<style scoped>
h1 {
  color: aquamarine;
}
button {
  border-radius: 5px;
  background-color: aquamarine;
  margin: 2px;
}
/* input {
  background-color: rgb(113, 109, 109);

  border-radius: 5px;

  margin: 2px;
  color: white;
} */
input::placeholder {
  color: lightgray;
}

input,
select {
  background-color: rgb(113, 109, 109);

  border-radius: 5px;
  width: 170px;
  margin: 2px;
  color: white;
  padding: 5px;
}
</style>
