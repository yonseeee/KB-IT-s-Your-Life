<template>
  <div>
    calc1 <br />
    <Calc />

    calc2 <br />
    <Calc2 />

    calc3 <br />
    <Calc3 />

    calc4 <br />
    <Calc4 />
  </div>
</template>
<script>
import Calc from './components/Calc.vue';
import Calc2 from './components/Calc2.vue';
import Calc3 from './components/Calc3.vue';
import Calc4 from './components/Calc4.vue';
export default {
  name: 'App',
  components: { Calc, Calc2, Calc3, Calc4 },
};
</script>
<style></style>
