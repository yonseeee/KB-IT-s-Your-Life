import { orders, addOrder } from './app.mjs';

addOrder('삼겹살', '3인분');
addOrder('목살', '2인분');

console.log('✅ 현재 주문 내역:');
for (let i = 0; i < orders.length; i++) {
  console.log(`${orders[i].menu}: ${orders[i].quantity}`);
}
