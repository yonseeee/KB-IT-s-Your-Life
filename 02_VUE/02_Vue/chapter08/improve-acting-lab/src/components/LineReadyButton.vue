<template>
  <div class="container">
    <button type="button" @click.stop="clickHandler">🎬 대사 준비 완료!</button>
    <br /><br />
    <p>버튼을 누른 횟수: {{ number }}회</p>
    <br />

    <div class="slot-wrapper">
      <slot name="ment">여기에 세연이의 코멘트가 들어갑니다.</slot>
    </div>
  </div>
</template>
<script>
export default {
  name: 'LineReadyButton',
  emits: ['ready'],
  data() {
    return {
      number: 0,
    };
  },
  methods: {
    clickHandler() {
      this.number++;
      this.$emit('ready', `대사 준비 완료! 총 (${this.number}회 눌림)`);
    },
  },
};
</script>
<style scoped>
.container {
  text-align: center;
}
button {
  background-color: #ff7675;
  border: 1px solid #dfe4ea;
  border-radius: 12px;
  width: 400px;
  height: 100px;
  font-size: 32px;
}
button:hover {
  background-color: #d63031;
}
.slot-wrapper {
  background-color: #f1f2f6;
  border: 1px solid #dfe4ea;
  border-radius: 5px;
  padding: 14px;
  width: 400px;
  margin: 0 auto;
}
</style>
