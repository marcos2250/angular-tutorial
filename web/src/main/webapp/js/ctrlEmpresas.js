app.controller('ctrlEmpresas',['$scope','servicos', function($scope, servicos) {

	$scope.Empresa = Empresa;
	$scope.opcoesTipoEmpresa = opcoesTipoEmpresa;
	
	var listaEmpresas = function() {
		servicos.getEmpresas().then( function(response) {
			$scope.empresas = response.data;
		});
	}

	listaEmpresas();

	$scope.abrir = function(id) {
		servicos.getEmpresaId(id).then( function(response) {
			Empresa.id = id;
			Empresa.nome = response.data.nome;
			Empresa.tipo = response.data.tipo;
			Empresa.dataFundacao = response.data.dataFundacao;
			Empresa.empregados = response.data.empregados;
		});
	}

	$scope.nova = function(id) {
		Empresa.id = 0;
		Empresa.nome = "";
		Empresa.tipo = "";
		Empresa.dataFundacao = "";
		Empresa.empregados = [];
	}
	
	$scope.salvar = function() {
	    if (Empresa.id == 0) {
			servicos.salvarEmpresa(Empresa).then(function() {
				listaEmpresas();
			});
		} else {
			servicos.atualizarEmpresa(Empresa).then(function() {
				listaEmpresas();
			});
		}		
	}

	$scope.excluir = function() {
		servicos.removeEmpresa(Empresa.id).then(function() {		
			listaEmpresas();
		});
	}
	
}]);