// IIFE, Immediately-Invoked Function Expression: 즉시실행함수

const a = 8;
function multiply() {
  console.log(a * 2);
}

multiply();

(function () {
  console.log(a * 2);
})();

// 괄호를 안 쪽에 써도 OK
// (function () {
//     console.log(a * 2);
//   }());
