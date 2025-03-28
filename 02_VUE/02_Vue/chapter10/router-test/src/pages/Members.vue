<template>
  <div class="card card-body">
    <h2 class="m-4">이날치 멤버</h2>
    <div class="container">
      <div class="row">
        <div
          v-for="m in members"
          :key="m.id"
          class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2"
        >
          <!-- 현재 돌고 있는 객체의 id를 넘겨준다 -->
          <!-- 파라미터 값은 params로 객체에 담아서 넘겨줄수 있다 -->
          <router-link :to="{ name: 'members/id', params: { id: m.id } }">
            <img
              class="img-thumbnail"
              style="width: 90px; height: 110px"
              :src="m.photo"
              :title="m.name"
            /><br />
            <h6 class="display-7">{{ m.name }}</h6>
          </router-link>
        </div>
      </div>
    </div>
    <!-- <h2>Members</h2>
    <p>요청 경로:{{ currentRoute.fullPath }}</p> -->
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';
export default {
  name: 'Memebers',
  setup() {
    return { members };
    // composition API 버전에서는 useRoute 함수 써서 현재 매칭 라우트 객체 가져온다
    // const currentRoute = useRoute();
    // return { currentRoute };
  },
};
</script>
<style></style>
