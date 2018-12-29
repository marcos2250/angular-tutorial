var app = angular.module('ctrlApp', ['ngRoute']);

app.config(function($routeProvider) {	
	$routeProvider
	.when('/Pessoas', {
	  templateUrl : 'partial/pessoas.html',
	  controller  : 'ctrlPessoas'
	})
	.when('/Empresas', {
	  templateUrl : 'partial/empresas.html',
	  controller  : 'ctrlEmpresas'
	})
	.otherwise({
	  redirectTo: '/Pessoas'
	});
});