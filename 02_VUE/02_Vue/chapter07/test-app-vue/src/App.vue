<template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr />
    <ul>
      <!-- 컴포넌트로 등록한 사용자 정의 태그 -->
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
      <CheckboxItem />
    </ul>
  </div>
</template>

<script>
import CheckboxItem from './components/CheckboxItem.vue';
export default {
  name: 'App',
  // 지역 컴포넌트 등록 방법, 해당  vue에서만 사용 가능
  components: { CheckboxItem },
};
</script>
