var App = angular.module('myApp', []);

App.controller('QuoteController', function ($scope,$http) {

        $http.get("/api/quote/random")
                .success(function (response) {
                    $scope.randomQuote = response.text;
                });

        $scope.newQuote = function() {
            $http.get("/api/quote/random")
                .success(function (response) {
                    $scope.randomQuote = response.text;
                });
        };
    });


