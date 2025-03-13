fs = require('fs');

fs.readFile('./sec03/example.txt', 'utf-8', (err, data) => {
  if (err) {
    console.error(err);
  }

  //   writeFile: 비동기로 원하는 내용을 해당 경로에 적는다
  fs.writeFile('./text-2.txt', data, (err) => {
    if (err) {
      console.error(err);
    }
    console.log('text-2.txt is saved!');
  });
});
