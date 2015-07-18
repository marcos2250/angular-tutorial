var app = angular.module('myApp', []);
app.controller('pessoasCtrl', function($scope, $http) {
    $http.get("http://localhost:8080/pessoas")
    .success(function (response) {$scope.pessoas = response.pessoas;});
});