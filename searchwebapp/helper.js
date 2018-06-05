/* 
* Search Webapp - Sample
*/
'use strict';
const mysql = require('mysql');

class Helper {

	constructor() {

		this.pool = mysql.createPool({
			connectionLimit: 100,
			host: 'database',
 			port: '3306',
			user: 'root',
			password: 'changeit',
			database: 'test',
			debug: false
		});
	}

	getSuggestion(key,callback){
		this.pool.getConnection( (err, connection) => {
			if (err) {
				callback({ "error": true });
			}

			connection.query("SELECT title FROM articles WHERE title LIKE '%" + key +"%'", (err, rows) => {
				if (!err) {
					callback({"error":false,"rows":rows});
				}
			});

			connection.on('error',  (err) => {
				callback({ "error": true });
			});
		});
	}

}

module.exports = new Helper();
