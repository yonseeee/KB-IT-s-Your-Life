import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import ElectronicPage from '@/pages/ElectronicPage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MEnsClothingPage from '@/pages/MEnsClothingPage.vue';
import WomenClothingPage from '@/pages/WomenClothingPage.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: ElectronicPage,
    },
    {
      path: '/jewelery',
      name: 'jewelery',
      component: JeweleryPage,
    },
    {
      path: '/mensclothing',
      name: 'mensclothing',
      component: MEnsClothingPage,
    },
    {
      path: '/womenclothing',
      name: 'womenclothing',
      component: WomenClothingPage,
    },
  ],
});

export default router;
