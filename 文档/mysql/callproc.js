var mysql = require('mysql');

var TEST_DATABASE = 'dev_dnsdb65';

//创建连接  
var client = mysql.createConnection({
  'host': '',
  'port': '',
  'user': '',
  'password': '',
});

client.connect();
client.query('use ' + TEST_DATABASE);
client.query('CALL createTable_renho(0);', function(err, rows, fields) {
  if (err) {
    throw err;
  }
  console.info("ok");
  client.end();
});