app.controller('ctrlEmpresas',['$scope','servicos', function($scope, servicos) {

	$scope.Empresa = Empresa;
	$scope.opcoesTipoEmpresa = opcoesTipoEmpresa;
	
	var listaEmpresas = function() {
		servicos.getEmpresas().success( function(dado) {
			$scope.empresas = dado;
		});
	}

	listaEmpresas();

	$scope.abrir = function(id) {
		servicos.getEmpresaId(id).success( function(dado) {
			Empresa.id = id;
			Empresa.nome = dado.nome;
			Empresa.tipo = dado.tipo;
			Empresa.dataFundacao = dado.dataFundacao;
			Empresa.empregados = dado.empregados;
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
			servicos.salvarEmpresa(Empresa).success(function() {
				listaEmpresas();
			});
		} else {
			servicos.atualizarEmpresa(Empresa).success(function() {
				listaEmpresas();
			});
		}		
	}

	$scope.excluir = function() {
		servicos.removeEmpresa(Empresa.id).success(function() {		
			listaEmpresas();
		});
	}
	
}]);