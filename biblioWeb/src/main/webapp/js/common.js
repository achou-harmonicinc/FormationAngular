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

    livreService.getLivres().success(function(livre) {
        $scope.livres = livre;
    });

    $scope.titrePage = "Consultation";

    $scope.idSort = 'id';
    $scope.togglerSort = function() {
        $scope.idSort = ($scope.idSort = 'id') ? '-id' : 'id';
    }
    $scope.newLivre = {"id": '', "isbn" : "", "titre": ""};
    $scope.ajouterLivre=function() {
        livreService.saveLivre($scope.newLivre).success(function(livreWS) {
            $scope.livres[$scope.livres.length] = livreWS;
        });
    }
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
			return $http.get("/biblioRS/serviceRS/livre");
		},
        saveLivre: function(livre) {
            return $http.post("/biblioRS/serviceRS/livre", livre);
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

