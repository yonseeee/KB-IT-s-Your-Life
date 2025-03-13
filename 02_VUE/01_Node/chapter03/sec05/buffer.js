const fs = require('fs');

fs.readFile('./sec05/example.txt', (err, data) => {
  if (err) return console.log(err);
  console.log(data);
  console.log('\n');
  console.log(data.toString());
});
