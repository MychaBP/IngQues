app.controller('PopupNotesCtrl', function ($uibModalInstance, note) {
   var $ctrl = this;
   $ctrl.cancel = cancel;
   $ctrl.save = save;
   $ctrl.getNote = getNote;
   $ctrl.note = getCurrentNote();
   $ctrl.getSubject = getSubject;

   function init() {

   }

   function cancel () {
        $uibModalInstance.dismiss('cancel');
   }

   function save () {
        $uibModalInstance.close($ctrl.note);
   }

   function getNote () {
        return note;
   }

   function getSubject() {
       return note.name;
   }

   function getCurrentNote() {
        return {
            id: note.id,
            name: note.name,
            text: note.text,
            clientNr: note.clientNr,
            isBlock: note.isBlock
        }
   }

});