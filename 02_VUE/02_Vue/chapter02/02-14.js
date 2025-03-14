let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
  }
  // bind를 통해서 this값을 지정한다
  inner = inner.bind(this);
  inner();
};

obj.add(3, 4);

console.log(obj);
console.log(result);
