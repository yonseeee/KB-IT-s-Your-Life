<template>
  <div>
    <button @click.stop="quizHandler" class="btn btn-warning">
      📃 퀴즈 시작하기
    </button>

    <br />
    <br />
    <div v-show="isShow" class="container">
      <h2>즉흥 대사 출처 퀴즈</h2>
      <slot name="title"></slot>
      <i>{{ quizList[currentIndex].line }}</i>
      <slot name="hint"></slot>

      <span v-for="(quiz, index) in quizList" :key="index">
        <button
          @click.stop="answerHandler(index)"
          class="options"
          type="button"
        >
          {{ quiz.source }}
        </button>
      </span>

      <div v-show="showCorrectOrNot">
        <slot v-if="isCorrect" name="correct">🎉 정답입니다!</slot>
        <slot v-else name="wrong">아쉽네요! 다시 도전해 보세요!</slot>
        <p>당신의 선택: {{ yourAnswer.source }}</p>
        <p v-if="isCorrect">결과: 정답!</p>
        <p v-else>결과: 오답</p>

        <button @click="nextQuestion" class="nextButton" type="button">
          다음 문제 풀기 ->
        </button>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'LineQuizCard',
  props: ['lines'],
  data() {
    return {
      isShow: false,
      quizLine: '',
      quizResource: '',
      quizList: [],
      currentIndex: 0,
      optionList: [],
      isCorrect: false,
      showCorrectOrNot: false,
      yourAnswer: '',
    };
  },
  methods: {
    quizHandler() {
      this.isShow = !this.isShow;
      console.log(this.quizList);
    },
    answerHandler(index) {
      this.yourAnswer = this.quizList[index];
      if (index === this.currentIndex) {
        this.isCorrect = true;
      } else {
        this.isCorrect = false;
      }
      this.showCorrectOrNot = true;
    },
    nextQuestion() {
      this.currentIndex++;
      this.showCorrectOrNot = !this.showCorrectOrNot;
    },
  },
  created() {
    this.quizList = this.lines;
    this.quizList.sort(() => Math.random() - 0.5);
  },
};
</script>
<style scoped>
button {
  background-color: gold;
  border: none;
  border-radius: 10px;
  padding: 10px;
  color: white;
}
.container {
  border: 2px solid lightgray;
  border-radius: 10px;
  width: 500px;
  margin: 0 auto;
  padding: 10px;
}
.options {
  background-color: rgb(140, 195, 229);
  color: white;
  border-radius: 10px;
  margin: 2px;
}
.nextButton {
  background-color: green;
  color: white;
  border-radius: 10px;
}
</style>
