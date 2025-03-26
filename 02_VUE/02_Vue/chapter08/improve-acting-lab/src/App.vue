<template>
  <div>
    <h1>improv-acting-lab</h1>
    <LineReadyButton @ready="readyHandler">
      <template v-slot:ment>
        <p v-if="!isShow">준비되면 눌러주세요! 자신감을 가져요!</p>
        <p v-else="isShow">
          오늘도 넌 멋질 거야! 🎤 자신 있게 무대에 올라가렴!
        </p>
      </template>
    </LineReadyButton>

    <br />
    <LineCard v-show="isShow">
      <template v-slot:tip>
        <div class="tip">TIP: 표정은 풍부하게, 발음 또박또박!</div></template
      >
      <template v-slot:image
        ><img
          src="https://dimg.donga.com/wps/NEWS/IMAGE/2017/01/16/82389904.1.jpg"
      /></template>
    </LineCard>
    <LineQuizCard :lines="lines">
      <template #title>
        <h4>Q. 이 대사는 어디에서 나온 걸까요?</h4>
      </template>
      <template #hint>
        <p>힌트: 모두 유명 드라마 속 대사예여!</p>
      </template>
      <template #answer></template>
      <template #wrong></template>
    </LineQuizCard>
  </div>
</template>
<script>
import { computed } from 'vue';
import LineCard from './components/LineCard.vue';
import LineReadyButton from './components/LineReadyButton.vue';
import LineQuizCard from './components/LineQuizCard.vue';
export default {
  name: 'App',
  components: { LineReadyButton, LineCard, LineQuizCard },
  data() {
    return {
      isShow: false,
      lines: [
        {
          line: '조금은 친절해도 되잖아. 다들 니들처럼 익숙한 게 아니니까.',
          source: '청춘시대',
        },
        {
          line: '너와 함께한 시간 모두 눈부셨다. 날이 좋아서 날이 좋지 않아서 날이 적당해서 모든 날이 좋았다.',
          source: '도깨비',
        },
        {
          line: '당신이 좋은 이유? 그저 그 사람이라서. 바로 너라서.',
          source: '응답하라 1997',
        },
        {
          line: '인생에서 시련 오는 거, 진짜와 가짜를 한 번씩 걸러내라고 하나님이 주신 기회가 아닌가 싶다.',
          source: '별에서 온 그대',
        },
        {
          line: '잊지 말자. 나는 어머니의 자부심이다. 모자라고 부족한 자식이 아니다.',
          source: '미생',
        },
      ],
    };
  },
  provide() {
    return {
      RandomLineProvider: computed(() => {
        return this.lines;
      }),
      // return this.lines[Math.floor(Math.random() * 4)];
    };
  },
  methods: {
    readyHandler(e) {
      this.isShow = true;
      console.log(e);
    },
  },
};
</script>
<style>
div {
  text-align: center;
}
.slott {
  background-color: orange;
  border: 1px solid #dfe4ea;
  border-radius: 5px;
  padding: 14px;
  width: 400px;
}
</style>
