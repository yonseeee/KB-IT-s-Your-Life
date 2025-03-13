const fs = require('fs');

let content = '김종국, 나이: 45, 체중: 80kg, 운동: 벤치프레스 100kg';
fs.writeFileSync('./members/kim_jong_kook.txt', content);
console.log('파일 생성 완료!');

// const data=fs.readFileSync('./kim_jong_kook.txt','utf-8');
// const path=require('path');

const path = require('path');

const dir = path.dirname(__filename);
const filePath = path.join(dir, 'kim_jong_kook.txt');
const fn = path.basename(filePath);
const extname = path.extname(filePath);
const exceptExt = path.basename(filePath, extname);

console.log(`디렉터리 경로 : ${dir}`);
console.log(`파일 이름: ${fn}`);
console.log(`파일 확장자: ${extname}`);
console.log(`파일 이름(확장자 제외): ${exceptExt}`);
