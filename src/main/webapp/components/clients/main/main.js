(function () {

    angular.module('ing').directive('main', main);

    function main() {
        var directive = {
            restrict: 'E',
			templateUrl: 'components/clients/main/main.html',
			bindToController: true,
			controllerAs: 'ctrl',

			controller: mainCtrl
        };

        return directive;

        function mainCtrl($scope) {
			var ctrl = this;
            init();

     		function init() {

           	}
        }
    }
})();