const order = require('./order');

for (let i = 0; i < order.length; i++) {
  if (order[i].menu == '삼겹살') {
    console.log(`삼겹살 주문 수량: ${order[i].serving}`);
    return;
  }
}
console.log('❌ 삼겹살 주문 내역이 없습니다.');
