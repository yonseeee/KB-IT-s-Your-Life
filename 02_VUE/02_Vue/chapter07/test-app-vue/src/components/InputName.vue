<template>
  <div style="border: solid 1px gray; padding: 5px">
    이름: <input type="text" v-model="name" />
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>

<script>
export default {
  name: 'InputName',
  emits: ['nameChanged'],
  data() {
    return { name: '' };
  },
};
</script>
