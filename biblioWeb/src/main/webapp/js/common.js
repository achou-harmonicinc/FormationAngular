/**
 * 
 */


function ajouterLivre() {

}


function controleurPrincipal($scope, $rootScope) {
    $scope.titreSite = "biblio Web\n";
}

function controleurInscription($scope) {
    $scope.titrePage = "Inscription";
}

function controleurConsultation($scope, livreService) {
    $scope.titrePage = "Consultation";

    livreService.getLivres().success(function(livre) {
        $scope.livres = livre;
    });




}

function controleurContact($scope) {
    $scope.titrePage = "Contact";
}

function controleurAccueil($scope) {
    $scope.titrePage = "Accueil";
}

function controleurMenu($scope) {
    $scope.menu = [{ "titre": "accueil", "isActive": true },
    { "titre": "inscription", "isActive": false },
    { "titre": "consultation", "isActive": false },
    { "titre": "contact", "isActive": false },
    ];
    //$scope
    $scope.changerActif = function (index) {
        $scope.menu.forEach(item => item.isActive = false);
        $scope.menu[index].isActive = true;
    }
}


//demarrage d'angular
var monAppli = angular.module("monAppli", ['ngRoute']);

/*****************************************/
//DECLARATION DE SERVICE
/*****************************************/
//declaration des services (en singleton)
monAppli.factory("livreService", function($http) {
	return {
		getLivres: function() {
			return $http.get("/biblioWeb/livres.json");
		},
        saveLivre: function(livre) {
            return $http.post("/biblioweb/livre", livre);
        }
	};
});


//configuration de la cinematique
monAppli.config(function ($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl: "./template/accueil.html",
            //controller: MainController
        })
        .when("/inscription", {
            templateUrl: "./template/inscription.html",
            //controller: UserController
        })
        .when("/consultation", {
            templateUrl: "./template/consultation.html",
            //controller: UserController
        })
        .when("/contact", {
            templateUrl: "./template/contact.html",
            //controller: UserController
        })
        .otherwise({
            redirectTo: "/"
        });
});





/**********************************************/
// Declaration des controleurs dans AngularJS
/*********************************************/
monAppli.controller("controleurPrincipal", controleurPrincipal);
monAppli.controller("controleurConsultation", controleurConsultation);
monAppli.controller("controleurContact", controleurContact);
monAppli.controller("controleurInscription", controleurInscription);
monAppli.controller("controleurMenu", controleurMenu);
monAppli.controller("controleurAccueil", controleurAccueil);

