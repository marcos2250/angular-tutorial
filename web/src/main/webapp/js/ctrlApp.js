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

app.config(['$httpProvider', function ($httpProvider) {
    $httpProvider.interceptors.push(function ($q,$rootScope) {
        return {
            'responseError': function (responseError) {
                alert(responseError.data.mensagem);
                return $q.reject(responseError);
            }
        };
    });
}]);