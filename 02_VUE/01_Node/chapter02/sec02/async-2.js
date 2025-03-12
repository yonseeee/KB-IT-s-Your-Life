// 동기 방식, 순차적으로 처리
function displayA() {
  console.log('A');
}
function displayB(callback) {
  setTimeout(() => {
    console.log('B');
    // 받아 온 콜백함수를 언제 실행해줄 지 결정, 비동기
    callback();
  }, 2000);
}
function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
