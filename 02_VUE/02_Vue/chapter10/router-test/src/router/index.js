import { createRouter, createWebHistory } from 'vue-router';

import Home from '@/pages/Home.vue';
import About from '@/pages/About.vue';
import Members from '@/pages/Members.vue';
import Videos from '@/pages/Videos.vue';
import MemberInfo from '@/pages/MemberInfo.vue';
import VideoPlayer from '@/pages/VideoPlayer.vue';
const router = createRouter({
  history: createWebHistory(), //히스토리 모드 설정
  routes: [
    //해당 path로 접근 시 해당 컴포넌트로 렌더링
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/about',
      name: 'about',
      component: About,
    },
    {
      path: '/members',
      name: 'members',
      component: Members,
    },
    {
      // 경로에 :이 붙으면 동적할당 가능
      path: '/members/:id',
      name: 'members/id',
      component: MemberInfo,
    },
    {
      path: '/videos',
      name: 'videos',
      component: Videos,
      // 하나의 라우트 내에서 또다른 라우트를 띄우는 중첩 라우트 구조
      children: [{ path: '/id', name: 'videos/id', component: VideoPlayer }],
    },
  ],
});

export default router;
