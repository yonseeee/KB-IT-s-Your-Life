let arr = [10, 20, 30];

const proxy = new Proxy(arr, {
  // 값을 가지고 올 때 처리
  get: function (target, key, receiver) {
    console.log('## get ' + key);
    // 해당 키에 존재하는 데이터가 없으면 에러 발생시킴
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    return target[key];
  },
  //   값을 설정할 때는 set 처리
  set: function (target, key, value) {
    console.log('## set ' + key);
    // 해당 키에 존재하는 데이터가 없으면 에러 발생시킴
    if (!target[key]) throw new Error(`존재하지 않는 속성(${key})입니다`);
    target[key] = value;
    return true;
  },
});

proxy[1] = 99;
