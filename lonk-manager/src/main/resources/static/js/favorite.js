angular.module('favoriteApp', ['ngDialog'])

    /*---------------------CONTROLLER POUR CATEGORY MODAL---------------------------*/

    .controller('AddCatController', function($scope, $http, ngDialog){
        $scope.validateCa = function() {
            console.log($scope.category)
        }
        $scope.validateCat = function() {
            $http.post('/api/category', { id: null, name: $scope.category}).then(
                function() {
                    $scope.$parent.refresh();
                    ngDialog.closeAll();
                }, function(error) {
                    alert(error.data.message);
                }
            )
        }

        $scope.cancel = function() {
            ngDialog.closeAll();
        }
    })


    /*---------------------CONTROLLER POUR LINK MODAL---------------------------*/


    .controller('AddController', function($scope, $http, ngDialog){
        $scope.categories = [];
        $scope.favorite ={
            category: 0
        }
        $scope.filter = {
        category: 0
        };
        $scope.favorites = [];
        $scope.refresh = function() {
            $http.get('api/categories').then(
                function(response) {
                    response.data.forEach(d => {
                        $scope.categories.push(d);
                    })
                    $scope.favorite.category = $scope.categories[0].id;
                }
            )
        }

        $scope.cancel = function() {
            ngDialog.closeAll();
        }

        $scope.refresh();

        $scope.validate = function() {
            $http.post('/api/category/' + $scope.favorite.category + "/links", { id: null, name: $scope.favorite.name, path: $scope.favorite.link }).then(
                function() {
                    $scope.$parent.refresh();
                    ngDialog.closeAll();
                }, function(error) {
                    alert(error.data.message);
                }
            )
        }
    })

    /*---------------------CONTROLLER POUR PAGE ACCUEIL---------------------------*/

    .controller('FavoritesController', function($scope, $http, ngDialog) {

        $scope.categories = [];
        $scope.realCategories = [];
        $scope.favorites = [];

        $scope.filter = {
        category: 0
        };

        $scope.mode = 'view';

        $scope.favorite = {};

        $scope.cancel = function() {
            $scope.setMode('view');
        }

        $scope.validate = function() {
            $http.post('/api/category/' + $scope.favorite.category + "/links", { id: null, name: $scope.favorite.name, path: $scope.favorite.link }).then(
                function() {
                    $scope.refresh();
                    $scope.setMode('view');
                }, function(error) {
                    alert(error.data.message);
                }
            )
        }

        $scope.kick = function(id) {
        Swal.fire({
          title: 'Are you sure?',
          text: "You won't be able to revert this!",
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                $http.delete('/api/link/' + id).then(
                    function() {
                        $scope.refresh();
                    }, function(error) {
                        alert(error.data.message);
                    }
                )
                Swal.fire(
                'Deleted!',
                'Your file has been deleted.',
                'success'
                )
            }
        })}

        $scope.refresh = function() {
            $http.get('api/categories').then(
                function(response) {
                    $scope.categories = [{id: 0, name: "Everything", references: 0}];
                    response.data.forEach(d => {
                        $scope.categories.push(d);
                    })

                    $http.get('api/links').then(
                        function(response) {
                            $scope.favorites = response.data.filter(f => $scope.filter.category === 0 || f.category.id === $scope.filter.category);
                        }
                    )
                }
            )
        }

    $scope.add= function(){
        ngDialog.open({
            template: 'views/modal-add.html',
            controller: 'AddController',
            scope:$scope
        });
    }

    $scope.addCat = function(){
        ngDialog.open({
            template: 'views/modal-add-cat.html',
            controller: 'AddCatController',
            scope:$scope
        })
    }

        $scope.refresh();
    });