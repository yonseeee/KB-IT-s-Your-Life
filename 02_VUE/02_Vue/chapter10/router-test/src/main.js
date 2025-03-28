import { createApp } from 'vue';
import 'bootstrap/dist/css/bootstrap.min.css';
import App from './App.vue';
import router from './router';

const app = createApp(App);

app.use(router); //라우터를 앱에 연결

app.mount('#app');
