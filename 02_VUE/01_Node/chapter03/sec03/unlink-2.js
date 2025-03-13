const fs = require('fs');

if (!fs.existsSync('./sec03/text-1.txt')) {
  console.log('file does not exist');
} else {
  fs.unlinkSync('./sec03/text-1.txt');
  console.log('file deleted');
}
