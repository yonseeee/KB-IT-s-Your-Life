const fs = require('fs');

// encoding 옵션으로 utf-8 형식으로 변경해줌
const data = fs.readFileSync('./sec03/example.txt', 'utf-8');

// fs.writeFileSync : 넣어준 내용으로 새로운 파일을 쓴다
fs.writeFileSync('./sec03/text-1.txt', data);
