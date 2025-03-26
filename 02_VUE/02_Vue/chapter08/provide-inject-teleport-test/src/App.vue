<template>
  <div>
    <h2>최신 인기곡</h2>
    <SongList :songs="songs" />
    <br /><br />
    <button @click="changeModal">Teleport를 이용한 Modal 기능</button>
    <teleport to="#modal">
      <Modal v-if="isModal" />
    </teleport>
  </div>
</template>
<script>
import { computed } from 'vue';
import SongList from './components/SongList.vue';
import Modal from './components/Modal.vue';
export default {
  name: 'App',
  components: { SongList, Modal },
  data() {
    return {
      songs: [
        { id: 1, title: 'Blueming', done: true },
        { id: 2, title: 'Dynamite', done: true },
        { id: 3, title: 'Lovesick Girls', done: false },
        { id: 4, title: '마리아', done: false },
      ],
      isModal: false,
    };
  },
  // 모든 자식이 접근 가능
  // provide: 하위 요소 어디든 주입받을 수 있도록 상위요소에서 제공
  provide() {
    // proxy객체 리턴  -> 데이터에 변화 일어나면 바로 값들 변경
    return {
      icons: {
        checked: 'far fa-check-circle',
        unchecked: 'far fa-circle',
      },
      // songs 배열 중 done이 true인 곳의 길이 계산
      doneCount: computed(() => {
        return this.songs.filter((s) => s.done === true).length;
      }),
    };
  },
  methods: {
    changeModal() {
      this.isModal = true;
      setTimeout(() => {
        this.isModal = false;
      }, 2000);
    },
  },
};
</script>
<style>
@import url('https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css');
</style>
