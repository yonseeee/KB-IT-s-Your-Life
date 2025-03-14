import _ from 'lodash';

const teacher = {
  name: 'yura',
  age: 20,
  emails: ['yura@gmail.com'],
};

//const copyTeacher = teacher;   -> 주소값이 복사돼서 값이 변경됨!

// 해결방법 1 : Object.assign 이용해서 target 객체에 출처 객체를 복사
//const copyTeacher = Object.assign({}, teacher);
// 해결방법 2: 전개 연산자 이용해서 객체 생성
// const copyTeacher = { ...teacher };
// =>참조형 데이터를 가지고 있을 때 한계(얕은 복사)

// 깊은 복사까지 하기 위한 lodash 사용법
const copyTeacher = _.cloneDeep(teacher);
console.log(copyTeacher === teacher);

teacher.age = 21;
console.log(teacher);
console.log(copyTeacher);

// 참조형 데이터까지 값을 복사해주진 못한다. ->한계 발생
teacher.emails.push('yura2@gmail.com');
console.log(teacher.emails === copyTeacher.emails);
console.log(teacher);
console.log(copyTeacher);
