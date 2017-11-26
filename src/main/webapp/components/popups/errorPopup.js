app.controller('errorPopupCtrl', function ($uibModalInstance, message) {
   var ctrl = this;
   ctrl.cancel = cancel;
   ctrl.message = message;

   function cancel () {
        $uibModalInstance.dismiss('cancel');
   }

});