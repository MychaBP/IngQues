(function () {
 'use strict';
    app.directive('mainNotes', mainNotes);

    function mainNotes() {
        var directive = {
            restrict : 'E',
            templateUrl : 'components/notes/mainNotes/mainNotes.html',
            bindToController : true,
            controllerAs : 'ctrl',
            controller : mainNotesCtrl
        };

        return directive;

        function mainNotesCtrl($scope, $routeParams) {
            $scope.noteId = $routeParams.id;

            var ctrl = this;
            init();

            function init() {
            }
        }
    }

})();