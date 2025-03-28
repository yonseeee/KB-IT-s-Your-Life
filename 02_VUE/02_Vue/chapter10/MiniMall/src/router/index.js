import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Cart from '@/pages/Cart.vue';
import Products from '@/pages/Products.vue';
import ProductDetail from '@/pages/ProductDetail.vue';
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
    {
      path: '/products',
      name: 'Products',
      component: Products,
    },
    {
      path: '/products/:id',
      name: 'Products/id',
      component: ProductDetail,
    },
  ],
});

export default router;
