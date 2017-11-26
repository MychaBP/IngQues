app.config(function($routeProvider, $locationProvider){
    $locationProvider.hashPrefix('');
    $routeProvider
    .when("/", {
        templateUrl : "components/clients/main/main.html"
    })
    .when("/note/:id", {
            templateUrl : "components/notes/mainNotes/mainNotes.html"
    })
    .when("/details/:id", {
            templateUrl : "components/clients/fullClientsView/fullClientsViewMain.html"
    });

});