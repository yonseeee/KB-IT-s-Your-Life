const fs = require('fs');

// encoding 옵션으로 utf-8 형식으로 변경해줌
const data = fs.readFileSync('./sec03/example.txt', 'utf-8');
console.log(data);
