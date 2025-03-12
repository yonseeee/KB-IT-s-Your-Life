let flag = false;
let grillMeat = function (menu) {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (flag) {
        console.log(`${menu}가 다 구워졌습니다!`);
        resolve();
      } else {
        console.log(`${menu}가 아직 안 익었습니다!`);
        reject();
      }
    }, 2000);
  });

  //   얘는 부른쪽에서, async/await 사용하듯이
  //   meat.then((result) => console.log(result)).catch((err) => console.log(err));
};

module.exports = grillMeat;
