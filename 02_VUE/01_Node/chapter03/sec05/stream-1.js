const fs = require('fs');

const rs = fs.createReadStream('./sec05/example.txt');

// data: 데이터가 읽힐 때마다 발생하는 이벤트
rs.on('data', (chunk) => {
  console.log('new chunk received');
  console.log('chunk length: ', chunk.length);
  console.log('chunk content: ', chunk);
})
  .on('end', () => {
    // end: 데이터 읽기가 완료 됐을 때 발생하는 이벤트
    console.log('Finished reading data');
  })
  .on('error', (err) => {
    console.error('Error reading the file: ${err.message}');
  });
