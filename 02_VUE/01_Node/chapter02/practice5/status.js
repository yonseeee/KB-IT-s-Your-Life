let orderStatus = {
  samgyeopsal: '주문 대기',
  galbi: '주문 대기',
};
let updateStatus = function (menu, status) {
  new Promise((resolve) => {
    setTimeout(() => {
      resolve();
    }, 1000);
  });
};
