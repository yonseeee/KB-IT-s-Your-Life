import { fileURLToPath, URL } from 'node:url';

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import vueDevTools from 'vite-plugin-vue-devtools';

// https://vite.dev/config/
export default defineConfig({
  plugins: [vue(), vueDevTools()],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
  server: {
    proxy: {
      // api로 시작되는 요청
      '/api': {
        target: 'http://localhost:3000', //json-server
        changeOrigin: true,
        // 경로 수정
        // /api로 시작하냐? 그럼 빈문자열로 바꿔라
        // json-server에는 저 접두어가 없기 때문에
        // ex. /api/todos  => /todos
        //  / / 정규표현식을 나타내는 JS 리터럴
        // ^로 시작
        rewrite: (path) => path.replace(/^\/api/, ''),
      },
    },
  },
});
