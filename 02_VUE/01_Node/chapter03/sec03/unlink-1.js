const fs = require('fs');

// unlinkSync :  해당 경로의 파일을 동기적으로 삭제
fs.unlinkSync('./sec03/text-1.txt');
console.log('file deleted');
