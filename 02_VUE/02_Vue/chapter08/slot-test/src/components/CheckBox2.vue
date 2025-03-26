<template>
  <div>
    <input
      type="checkbox"
      :value="id"
      :checked="checked"
      @change="$emit('check-changed', { id, checked: $event.target.checked })"
    />
    <!-- 부모가 넘겨준 템플릿이 없다면 기본 텍스트인 Item이 출력 -->
    <!-- Item 은 slot이 없을 경우 디폴트 값 -->
    <slot>Item</slot>
  </div>
</template>
<script>
export default {
  name: 'CheckBox1',
  props: ['id', 'checked'],
};
</script>
<style></style>
