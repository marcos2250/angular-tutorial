app.controller('ctrlPessoas',['$scope','servicos', function($scope, servicos) {

	$scope.Pessoa = Pessoa;
	$scope.opcoesSexo = opcoesSexo;
	
	var listaPessoas = function() {
		servicos.getPessoas().success( function(dado) {
			$scope.pessoas = dado;
		});
	}

	listaPessoas();

	$scope.abrir = function(id) {
		servicos.getPessoaId(id).success( function(dado) {
			Pessoa.id = id;
			Pessoa.nome = dado.nome;
			Pessoa.sobrenome = dado.sobrenome;
			Pessoa.sexo = dado.sexo;
			Pessoa.dataNascimento = dado.dataNascimento;
			Pessoa.telefone = dado.telefone;
			Pessoa.email = dado.email;
		});
	}

	$scope.nova = function(id) {
		Pessoa.id = 0;
		Pessoa.nome = "";
		Pessoa.sobrenome = "";
		Pessoa.sexo = "";
		Pessoa.dataNascimento = "";
		Pessoa.telefone = "";
		Pessoa.email = "";		
	}
	
	$scope.salvar = function() {
 	        if (Pessoa.id == 0) {
			servicos.salvarPessoa(Pessoa).success(function() {
				alert("Informacoes salvas!");
			}).error(function(data, status) {
        			alert(data.mensagem);
			});
		} else {
			servicos.atualizarPessoa(Pessoa).success(function() {
				alert("Informacoes salvas!");
			}).error(function(data, status) {
	        		alert(data.mensagem);
			});
		}
		listaPessoas();
	}

	$scope.excluir = function() {
		servicos.removePessoa(Pessoa.id).success(function() {		
			listaPessoas();
		});
	}
	
}]);
