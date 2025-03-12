const processOrder = require('./orderProcessor');

let a = { menu: '삼겹살', quantity: '2' };
let b = { menu: '목살', quantity: '3' };
let c = { menu: '갈비', quantity: '1' };

async function processOrders() {
  try {
    await processOrder(a);
    await processOrder(b);
    await processOrder(c);
    console.log('🍽️ 모든 주문 처리 완료! 식사 시작!');
  } catch (err) {
    console.error(err);
  }
}

processOrders();
