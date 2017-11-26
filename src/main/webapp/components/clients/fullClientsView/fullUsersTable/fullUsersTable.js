(function () {
 'use strict';
    app.directive('fullUsersTable', fullUsersTable);

    function fullUsersTable() {
        var directive = {
            restrict: 'E',
			templateUrl: 'components/clients/fullClientsView/fullUsersTable/fullUsersTable.html',
			bindToController: true,
			controllerAs: 'ctrl',
			controller: fullUsersTableCtrl
            };

        return directive;

        function fullUsersTableCtrl($scope, $http, $routeParams) {
			var clientId = $routeParams.id;

			var ctrl = this;
			ctrl.getFullClientData = getFullClientData;
            init();

     		function init() {
                getFullClientData(clientId);
           	}

           	function getFullClientData() {
                $http.get("/clients/client/" + clientId).then(function(response) {
                    $scope.client = response.data;
                    ctrl.clientTest = response.data;
                })
           	}
        }
    }
})();