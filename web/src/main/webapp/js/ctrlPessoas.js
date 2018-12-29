app.controller('ctrlPessoas',['$scope','servicos', function($scope, servicos) {

	$scope.Pessoa = Pessoa;
	$scope.opcoesSexo = opcoesSexo;
	
	var listaPessoas = function() {
		servicos.getPessoas().then( function(response) {
			$scope.pessoas = response.data;
		});
	}

	listaPessoas();

	$scope.abrir = function(id) {
		servicos.getPessoaId(id).then( function(response) {
			Pessoa.id = id;
			Pessoa.nome = response.data.nome;
			Pessoa.sobrenome = response.data.sobrenome;
			Pessoa.sexo = response.data.sexo;
			Pessoa.dataNascimento = response.data.dataNascimento;
			Pessoa.telefone = response.data.telefone;
			Pessoa.email = response.data.email;
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
			servicos.salvarPessoa(Pessoa).then(function() {
				alert("Informacoes salvas!");
			}).error(function(data, status) {
        			alert(data.mensagem);
			});
		} else {
			servicos.atualizarPessoa(Pessoa).then(function() {
				alert("Informacoes salvas!");
			}).error(function(data, status) {
	        		alert(data.mensagem);
			});
		}
		listaPessoas();
	}

	$scope.excluir = function() {
		servicos.removePessoa(Pessoa.id).then(function() {		
			listaPessoas();
		});
	}
	
}]);
