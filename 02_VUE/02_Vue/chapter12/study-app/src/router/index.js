import StudyDetail from '@/pages/StudyDetail.vue';
import StudyList from '@/pages/StudyList.vue';
import Home from '@/pages/Home.vue';
import AddStudy from '@/pages/AddStudy.vue';
import EditStudy from '@/pages/EditStudy.vue';
import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/studies',
      name: 'studies',
      component: StudyList,
    },
    {
      path: '/studies/:id',
      name: 'studies/id',
      component: StudyDetail,
    },
    {
      path: '/studies/add',
      name: 'studies/add',
      component: AddStudy,
    },
    {
      path: '/studies/:id/edit',
      name: 'studies/id/edit',
      component: EditStudy,
    },
  ],
});

export default router;
