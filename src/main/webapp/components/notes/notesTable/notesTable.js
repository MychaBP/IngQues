(function () {
 'use strict';
    app.directive('notesTable', notesTable);

    function notesTable() {
        var directive = {
            restrict: 'E',
			templateUrl: 'components/notes/notesTable/notesTable.html',
			bindToController: true,
			controllerAs: 'ctrl',
			controller: notesTableCtrl

            };

        return directive;

        function notesTableCtrl($scope, $http, $routeParams, $uibModal) {
			var clientId = $routeParams.id;
			var ctrl = this;

			ctrl.open = open;
			ctrl.addNote = addNote;
            init();

     		function init() {
                initNotesTable();
           	}

           	function initNotesTable() {
                $http.get("/notes/clientNotes/"+clientId).then(function(response) {
                    $scope.notes = response.data.notes;
                })
           	}

           	function open(note) {
           	    $http.get("/notes/canEdit/"+note.id).then(function(response) {
                     if (response.data) {
                        changeBlockStatus(note.id, true).then()
                        openNote(note);
                     } else {
                        showErrorPopup();
                     }
                });
           	}

           	function addNote() {
               openNote({
                 name: '',
                 clientNr: clientId,
                 isBlock: false
               });
           	}

           	function openNote(note) {
                console.log("lets Start!");
                var uibModalInstance = $uibModal.open({
                templateUrl: 'components/notes/notesTable/popup.html',
                controller: 'PopupNotesCtrl',
                controllerAs: '$ctrl',
                resolve: {
                    note: function () {
                        return note;
                        }
                    }
                });

                uibModalInstance.result.then(saveOrUpdateNote, function () {
                    if(note.id !== null, note.id !== '') {
                        changeBlockStatus(note.id, false);
                    }
                   });

           	}

           	function showErrorPopup(note) {
                var uibModalInstance = $uibModal.open({
                templateUrl: 'components/popups/errorPopup.html',
                controller: 'errorPopupCtrl',
                controllerAs: 'ctrl',
                resolve: {
                    message: function () {
                        return 'Edycja notatki niedostępna. Spróbuj ponownie za kilka minut.';
                        }
                    }
                });
            }

           	function saveOrUpdateNote(note) {
           	    $http.post("/notes/save", note)
           	    .then(function(response){
           	        init();
                });
           	}

           	function changeBlockStatus(id, status) {
           	   return $http.post("/notes/changeBlockStatus", {noteId: id,
                                           blockStatus: status });
           	}

        }
    }
})();