import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
// AuthResultDTO의 모양
const initState = {
  token: '',
  user: {
    username: '',
    email: '',
    roles: [],
  },
};

export const useAuthStore = defineStore('auth', () => {
  // ...  :객체 복사 표현
  //객체지만 ref사용->통으로 변경하기 쉽게 하기 위해
  const state = ref({ ...initState });

  //   computed사용 이유: read only로 운영하기 위해=> pinia밖에서는 수정 불가
  //   강제로 boolean 형변환
  const isLogin = computed(() => !!state.value.user.username);

  const username = computed(() => state.value.user.username);

  const email = computed(() => state.value.user.email);

  const login = async (member) => {
    // state.value.token = 'test token';
    // state.value.user = {
    //   username: member.username,
    //   email: member.username + '@test.com',
    // };
    const { data } = await axios.post('/api/auth/login', member);
    state.value = { ...data };

    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  const logout = () => {
    localStorage.clear();
    state.value = { ...initState };
  };

  const getToken = () => state.value.token;

  const load = () => {
    const auth = localStorage.getItem('auth');
    if (auth != null) {
      state.value = JSON.parse(auth);
      console.log(state.value);
    }
  };

  const changeProfile = (member) => {
    state.value.user.email = member.email;
    localStorage.setItem('auth', JSON.stringify(state.value));
  };

  load();

  return {
    state,
    username,
    email,
    isLogin,
    changeProfile,
    login,
    logout,
    getToken,
  };
});
