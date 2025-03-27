<template>
  <div>
    <div>
      <li
        style="list-style: none"
        class="d-flex justify-content-between item"
        v-for="(item, index) in lists"
        :key="index"
      >
        {{ item.name }}: {{ item.price.toLocaleString() }}원
        <button
          style="background-color: rgb(113, 109, 109); border: none"
          @click.stop="deleteHandler(index)"
        >
          ❌
        </button>
      </li>
    </div>
  </div>
</template>
<script>
import { computed } from 'vue';
export default {
  name: 'ExpenseList',
  props: {
    lists: {
      type: Array,
      required: true,
    },
  },
  setup(props, context) {
    const lists = computed(() => {
      return props.lists;
    });

    const deleteHandler = (index) => {
      console.log('delete');
      context.emit('delete-item', index);
    };

    return { lists, deleteHandler };
  },
};
</script>
<style scoped>
.item {
  background-color: rgb(113, 109, 109);
  color: white;
  border-radius: 5px;
  padding: 5px 0px 5px 8px;
  margin: 5px;
}
</style>
