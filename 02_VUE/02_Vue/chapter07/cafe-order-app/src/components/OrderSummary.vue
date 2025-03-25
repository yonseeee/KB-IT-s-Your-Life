<style>
.container {
  background-color: #fffaf0;
  border: 2px solid #d2b48c;
}

.affirm {
  background-color: moccasin;
}

hr {
  border: 2px dashed moccasin;
}
</style>
<template>
  <div class="container">
    <div>
      <h1>주문 내역서</h1>
      주문시간: {{ nowTime }}
    </div>
    <hr />
    <div>
      음료: {{ drink.name }} <br />
      사이즈: {{ optionData.size }} <br />
      추가 샷: {{ optionData.add }} <br />얼음 양: {{ optionData.ice }} <br />
    </div>
    <hr />
    결제 금액: {{ drink.price }} <br />
    <button @click="$emit('send-order')" class="affirm" type="button">
      주문 확정하기
    </button>
  </div>
</template>

<script>
export default {
  name: 'OrderSummary',
  props: ['drink', 'optionData'],
  emits: ['send-order'],
  data() {
    return {
      currentTime: '',
    };
  },
  computed: {
    nowTime() {
      this.currentTime = new Date();
      return this.currentTime;
    },
  },
};
</script>
