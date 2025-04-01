import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home.vue';
import Products from '@/pages/Products.vue';
import Cart from '@/pages/Cart.vue';
import ProductDetail from '@/pages/ProductDetail.vue';
import CategoryFilter from '@/pages/CategoryFilter.vue';
import ProductReview from '@/pages/ProductReview.vue';
import ProductDescription from '@/pages/ProductDescription.vue';
const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
    },
    {
      path: '/products',
      name: 'products',
      components: {
        default: Products,
        left: CategoryFilter,
      },
    },
    {
      path: '/products/:id',
      name: 'products/id',
      component: ProductDetail,
      children: [
        { path: 'review', name: 'productReview', component: ProductReview },
        {
          path: 'desc',
          name: 'productDescription',
          component: ProductDescription,
        },
      ],
    },
    {
      path: '/cart',
      name: 'cart',
      component: Cart,
    },
  ],
});

export default router;
