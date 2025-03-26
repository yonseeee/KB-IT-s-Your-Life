<template>
  <div class="container">
    <h3>
      <i> "{{ currentLine }}"</i>
    </h3>
    <br />
    <p style="color: gray" v-show="resource.length !== 0">
      출처: {{ resource }}
    </p>
    <!-- 출처 -->
    <!-- button -->
    <br />
    <button class="btn btn-primary" type="button" @click.stop="selectHandler">
      🎲 랜덤 대사 뽑기
    </button>
    <br /><br />
    <p>✨ 오늘의 즉흥대사입니다!</p>
    <br />
    <div class="slot-wrapper">
      <slot name="tip"></slot>
    </div>

    <br /><br />
    <slot name="image"></slot>
    <br />
    <p v-show="currentLine.length >= 30">
      대사가 길어요! 천천히 연기해 보세요.
    </p>
  </div>
</template>
<script>
export default {
  name: 'LineCard',
  inject: ['RandomLineProvider'],
  data() {
    return {
      currentLine: '아직 대사가 없습니다!',
      resource: '',
    };
  },

  methods: {
    selectHandler() {
      console.log('hello');
      let result = this.RandomLineProvider[Math.floor(Math.random() * 4)];
      this.currentLine = result.line;
      this.resource = result.source;
    },
  },
};
</script>
<style scoped>
.container {
  align-items: center;
  text-align: center;
  background-color: lightgray;
  border-radius: 10px;
  width: 600px;
  border: 2px solid gray;
  padding: 10px;
}
button {
  background-color: royalblue;
  border-radius: 5px;
  height: 40px;
}
.slot-wrapper {
  background-color: lightblue;
  margin: 0 auto;
  width: 300px;
}
/* @import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css'); */
</style>
