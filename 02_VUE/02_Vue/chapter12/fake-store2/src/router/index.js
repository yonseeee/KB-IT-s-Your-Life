import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '@/pages/HomePage.vue';
import ElectronicsPage from '@/pages/ElectronicsPage.vue';
import JeweleryPage from '@/pages/JeweleryPage.vue';
import MensClothingPage from '@/pages/MensPage.vue';
import WomensClothingPage from '@/pages/WomensClothingPage.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/electronics',
      name: 'electronics',
      component: () => import('../pages/ElectronicsPage.vue'),
    },
    {
      path: '/jewelery',
      name: 'jewelery',
      component: () => import('../pages/JeweleryPage.vue'),
    },
    {
      path: '/mensclothing',
      name: "mens's clothing",
      component: () => import('../pages/MensPage'),
    },
    {
      path: '/womensclothing',
      name: "women's clothing",
      component: () => import('../pages/WomensClothingPage.vue'),
    },
    {
      path: '/product/:id',
      name: 'product/id',
      component: () => import('../pages/ProductDetailPage.vue'),
    },
    {
      path: '/product/write',
      name: 'product/write',
      component: () => import('../pages/ProductWritePage.vue'),
    },
    {
      path: '/product/edit:id',
      name: 'product/edit',
      component: () => import('../pages/ProductEditPage.vue'),
    },
  ],
});

export default router;
