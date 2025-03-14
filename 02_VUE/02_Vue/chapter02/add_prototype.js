// const seyeon = {
//   firstName: 'Seyeon',
//   lastName: 'Kim',
//   getFullName: function () {
//     return `${this.firstName} ${this.lastName}`;
//   },
// };

// // 일반 함수에서 this는 호출한 객체
// console.log(seyeon.getFullName());

// 생성자 함수
function User(first, last) {
  this.firstName = first;
  this.lastName = last;
}

// 프로토타입에 추가된 함수는 객체 전체가 공유한다
user.prototype.getFullName = function () {
  return `${this.firstName} ${this.lastName}`;
};

const seyeon = new User('seyeon', 'kim');
const jungwoo = new User('jungwoo', 'moon');

console.log(seyeon.getFullName());
console.log(jungwoo.getFullName());
