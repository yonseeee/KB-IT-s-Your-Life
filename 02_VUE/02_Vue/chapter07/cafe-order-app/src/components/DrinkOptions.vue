<template>
  <h1>{{ selectedDrink.name }} 옵션 선택</h1>

  <form style="background-color: lightblue">
    사이즈: <br />
    <input
      @change="changeHandler"
      type="radio"
      name="size"
      v-model="size"
      value="small"
    />Small
    <input
      @change="changeHandler"
      type="radio"
      name="size"
      v-model="size"
      value="medium"
      checked
    />Medium
    <input
      @change="changeHandler"
      type="radio"
      name="size"
      v-model="size"
      value="large"
    />Large
    <br />
    <input @change="changeHandler" type="checkbox" v-model="add" />샷 추가
    <br />
    얼음 양:
    <select @change="changeHandler" name="ice" title="얼음" v-model="ice">
      <option value="적게">적게</option>
      <option value="보통" selected>보통</option>
      <option value="많이">많이</option>
    </select>
  </form>
</template>

<script>
export default {
  name: 'DrinkOptions',
  props: ['selectedDrink'],
  emit: ['option-changed'],
  data() {
    return {
      size: '',
      add: '',
      ice: ' ',
    };
  },
  methods: {
    changeHandler() {
      console.log(`size: ${this.size} add: ${this.add} ice: ${this.ice}`);
      this.$emit('option-changed', this.size, this.add, this.ice);
    },
  },
};
</script>
