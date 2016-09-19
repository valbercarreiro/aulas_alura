angular.module('alurapic').controller('FotosController',function($scope, recursoFoto){
    $scope.fotos = [];
    $scope.filtro = '';
    $scope.mensagem = '';

    recursoFoto.query(function(fotos){
        $scope.fotos = fotos;
    }, function(erro){
        console.log(erro);
    });

    /*$http.get('v1/fotos')
    .success(function(fotos){
        $scope.fotos = fotos;
    }).error(function(error){
        console.log(error);
    });*/

    $scope.remover = function(foto){
        recursoFoto.delete({fotoId: foto._id}, function(fotos){
            var indiceFoto = $scope.fotos.indexOf(foto);
            $scope.mensagem = 'Foto '+foto.titulo+' foi removida com sucesso';
            $scope.fotos.splice(indiceFoto, 1);
        }, function(erro){
            console.log(erro);
            $scope.mensagem = 'Não foi possível remover a foto '+foto.titulo;
        });
        /*$http.delete('v1/fotos/' + foto._id)
        .success(function(fotos){
            var indiceFoto = $scope.fotos.indexOf(foto);
            $scope.mensagem = 'Foto '+foto.titulo+' foi removida com sucesso';
            $scope.fotos.splice(indiceFoto, 1);
        }).error(function(erro){
            console.log(erro);
            $scope.mensagem = 'Não foi possível remover a foto '+foto.titulo;
        });*/
    };

});
