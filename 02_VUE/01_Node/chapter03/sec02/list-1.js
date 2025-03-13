const fs = require('fs');

// readdirSync: 현재 폴더에 있는 파일들 목록 보여주기(동기)
let files = fs.readdirSync('./');
console.log(files);
