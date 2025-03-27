<template>
  <div>총 지출: {{ result }}</div>
</template>

<script>
import { computed } from 'vue';
export default {
  name: 'TotalDisplay',
  props: {
    totalSum: {
      type: Number,
      required: true,
    },
    formatNumber: {
      type: Function,
      required: true,
    },
  },
  setup(props) {
    const result = computed(() => {
      return props.formatNumber(props.totalSum);
    });
    return { result };
  },
};
</script>
<style scoped>
div {
  background-color: rgb(113, 109, 109);
  color: white;
  border-radius: 5px;
  padding: 5px;
  margin: 2px;
  text-align: center;
  color: aquamarine;
}
</style>
