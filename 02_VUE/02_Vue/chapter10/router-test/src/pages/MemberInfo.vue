<template>
  <div class="mt-5">
    <img :src="member.photo" class="img" />
    <h4 class="mt-2">{{ member.name }}({{ member.role }})</h4>
    <p>{{ member.desc }}</p>

    <!-- 인스타 정보가 있는 경우에만 링크 생성 -->
    <a
      v-if="member.insta && member.insta !== ''"
      class="fa-brands fa-instagram m-1"
      :href="member.insta"
    ></a>
    <a
      v-if="member.facebook && member.facebook !== ''"
      class="fa-brands fa-facebook m-1"
      :href="member.facebook"
    ></a>
    <a
      v-if="member.youtube && member.youtube !== ''"
      class="fa-brands fa-youtube m-1"
      :href="member.youtube"
    ></a>
    <br /><br />
    <router-link :to="{ name: 'members' }">멤버 목록으로</router-link>
  </div>
  <!-- <div class="card card-body">
    <h2>Members</h2>
    요청 경로:{{ currentRoute.path }} <br />
    params로 해당 경로의 파라미터 중에 id 값만 가져온다
    id값: {{ currentRoute.params.id }} <br />
  </div> -->
</template>

<script>
import { useRoute } from 'vue-router';
// @/ : src
import members from '@/members.json';
export default {
  name: 'MemeberInfo',
  setup() {
    const currentRoute = useRoute();
    // 경로 내의 데이터는 문자열이기 때문에 파싱 필요
    const id = parseInt(currentRoute.params.id, 10);
    const member = members.find((m) => m.id === id);

    return { member };
  },
};
</script>
<style></style>
