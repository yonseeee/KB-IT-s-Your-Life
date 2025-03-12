let processOrder = function (order) {
  return new Promise((resolve) => {
    setTimeout(() => {
      console.log(`${order.menu} ${order.quantity}인분 주문 처리 완료!`);
      resolve();
    }, 1000);
  });
};

module.exports = processOrder;
