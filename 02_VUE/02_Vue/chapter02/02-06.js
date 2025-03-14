// 맨 뒤에만 가변 매개변수 지정 가능
function foodReport(name, age, ...favoriteFoods) {
  console.log(name + ', ' + age);
  console.log(favoriteFoods);
}

foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');
