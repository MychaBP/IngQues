(function () {
 'use strict';
    app.directive('usersTable', usersTable);

    function usersTable() {
        var directive = {
            restrict: 'E',
			templateUrl: 'components/clients/usersTable/usersTable.html',
			bindToController: true,
			controllerAs: 'ctrl',
			controller: usersTableCtrl

            };

        return directive;

        function usersTableCtrl($scope, $http) {
			var ctrl = this;
			ctrl.a = a;
            init();

     		function init() {
                a();
           	}

           	function a() {
                $http.get("/clients/clients").then(function(response) {
                    $scope.clients = response.data.clients;
                })
           	}
        }
    }
})();