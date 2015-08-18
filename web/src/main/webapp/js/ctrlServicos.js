app.service('servicos', ['$http', function($http) {
var servidor = "http://localhost:8080/rest";

this.getPessoas = function() {
	return $http.get( servidor + "/pessoas/");
}

this.getPessoaId = function(id) {
	return $http.get( servidor + "/pessoas/" + id);
}

this.salvarPessoa = function(pessoa) {
	return $http.post( servidor + "/pessoas/", pessoa);
}

this.atualizarPessoa = function(pessoa) {
	return $http.put( servidor + "/pessoas/", pessoa);
}

this.removePessoa = function(id) {
	return $http.delete( servidor + "/pessoas/" + id);
}

this.getEmpresas = function() {
	return $http.get( servidor + "/empresas/");
}

this.getEmpresaId = function(id) {
	return $http.get( servidor + "/empresas/" + id);
}

this.salvarEmpresa = function(empresa) {
	return $http.post( servidor + "/empresas/", empresa);
}

this.atualizarEmpresa = function(empresa) {
	return $http.put( servidor + "/empresas/", empresa);
}

this.removeEmpresa = function(id) {
	return $http.delete( servidor + "/empresas/" + id);
}

}]);