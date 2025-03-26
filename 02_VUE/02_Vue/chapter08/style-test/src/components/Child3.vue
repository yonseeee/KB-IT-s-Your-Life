<template>
  <div :class="$style.child">
    <h2>Child3</h2>
  </div>
</template>
<script>
export default {
  name: 'Child3',
  //   데이터만 가지고 있는 상태
  // DOM에는 연결 안된 상태
  created() {
    console.log(this.$style);
  },
};
</script>
<style module>
.child {
  background-color: orange;
  border: solid 1px black;
  margin: 1.5em;
  padding: 1em;
}
</style>
