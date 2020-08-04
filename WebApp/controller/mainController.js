var miapp = angular.module('miAp', [])
	.controller('MyTableData', ['$scope', function($scope) {
		$scope.buscar = function () {
			/*var mysql = require('mysql');
			var connection = mysql.createConnection({
			host: 'localhost',
			user: 'root',
			password: 'admin',
			database: 'company',
			port: 3306
			});
			connection.connect(function(error){
			if(error){
				throw error;
			}else{
				console.log('Conexion correcta.');
			}
			});
			var query = connection.query('SELECT title, protagonist, producer FROM game WHERE id_game > ?', [0], function(error, result){
				if(error){
					throw error;
				}else{
					var resultado = result;
					if(resultado.length > 0){
						console.log(resultado[0].title + ' ' + resultado[0].protagonist + ' / ' + resultado[0].producer);
					}else{
						console.log('Registro no encontrado');
					}
				}
			}
			);
			*/
			$scope.juegos =
			[
			{
				title: 'mass effect 1', protagonist: 'shepard', producer: 'ubisoft'
			}
			]
		};
	}])
	;