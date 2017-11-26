(function () {
 'use strict';
    app.directive('usersFilter', usersFilter);

    function usersFilter() {
        var directive = {
            restrict: 'E',
			templateUrl: 'components/clients/usersFilter/usersFilter.html',
			bindToController: true,
			controllerAs: 'ctrl',
			controller: usersFilterCtrl
        };

        return directive;

        function usersFilterCtrl($scope, $http) {
			var ctrl = this;
			ctrl.search = search;
			ctrl.doFilter = doFilter;
			ctrl.b = b;
            init();

     		function init() {

          	}

           	function search() {
                init();
           	}

           	function doFilter() {
           	    $http.post("/clients/filter", {region : ctrl.filter.region,
           	                                    branza : ctrl.filter.branza
           	                                    }).then(function(response){
           	                                    $scope.clients = response.data.clients;
           	                            });
           	}

           	function b() {
                            $http.get("/clients/clients").then(function(response) {
                                $scope.clients = response.data.clients;
                            })
                       	}
        }
    }
})();