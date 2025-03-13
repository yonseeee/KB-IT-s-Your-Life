const fs = require('fs');

// encoding 옵션으로 utf-8 형식으로 변경해줌
const data = fs.readFileSync('./sec03/example.txt', 'utf-8');

if (fs.existsSync('./sec03/text-1.txt')) {
  // 파일이 이미 존재한다면 여기서 처리
  console.log('file already exist');
} else {
  // 파일이 없다면 기록
  fs.writeFileSync('./sec03/text-1.txt', data);
}
