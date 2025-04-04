import { ref, computed, reactive } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';
export const useMatchStore = defineStore('matchStore', () => {
  const myMBTI = ref('');
  const friendMBTI = ref('');
  const matchResult = ref('');
  const matchFunc = async (mine, friend) => {
    myMBTI.value = mine;
    friendMBTI.value = friend;
    console.log(myMBTI.value, friendMBTI.value);
    let response = await axios.get('http://localhost:3000/matches');
    let data = response.data;

    data.forEach((element) => {
      //   console.log(element.myMBTI, element.friendMBTI);
      if (
        element.myMBTI === myMBTI.value &&
        element.friendMBTI === friendMBTI.value
      ) {
        matchResult.value = element;
      } else if (
        element.friendMBTI === myMBTI.value &&
        element.myMBTI === friendMBTI.value
      ) {
        matchResult.value = element;
      }
    });
    // console.log(data);
    return data;
  };

  const saveResult = async () => {
    let data = matchResult.value;
    axios.post('http://localhost:3000/savedResults', data);
  };

  const state = reactive({ results: [] });
  const showResults = async () => {
    console.log('hello');
    let response = await axios.get('http://localhost:3000/savedResults');
    // console.log(response.data);
    state.results = response.data;
    console.log(state.results);
    // return response.data;
  };

  const deleteResult = async (id) => {
    let response = await axios.delete(
      `http://localhost:3000/savedResults/${id}`
    );
    let data = response.data;
    const index = state.results.findIndex((result) => result.id === id);
    state.results.splice(index, 1);
  };

  const Result = computed(() => matchResult.value);
  return {
    myMBTI,
    friendMBTI,
    Result,
    matchFunc,
    saveResult,
    showResults,
    state,
    deleteResult,
  };
});
