const grillMeat = require('./grill');

async function startGrilling(menu) {
  try {
    await grillMeat(menu);
    console.log('🍽️ 식사 시작!');
  } catch (err) {
    console.error(err);
  }
}
startGrilling('삼겹살');
