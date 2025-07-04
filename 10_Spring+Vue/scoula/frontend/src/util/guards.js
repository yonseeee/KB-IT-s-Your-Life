import { useAuthStore } from '@/stores/auth';

export const isAuthenticated = (to, from) => {
  const auth = useAuthStore();

  if (!auth.isLogin) {
    console.log('로그인 필요.....');
    // 로그인 페이지로 리다이렉트하면서 현재 이동하려는 페이지 이름을 쿼리로 전달
    return { name: 'login', query: { next: to.name } };
  }
  console.log('로그인 인증');
};
