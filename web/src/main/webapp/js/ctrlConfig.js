app.config(['$stateProvider', '$urlRouterProvider', '$httpProvider',
function($stateProvider, $urlRouterProvider) {
$urlRouterProvider.otherwise("/Pessoas");
	$stateProvider
		.state('Pessoas', {
			url: "/Pessoas",
			templateUrl: "./partial/pessoas.html"
		})
		.state('Empresas', {
			url: "/Empresas",
			templateUrl: "./partial/empresas.html"
		});
}]);