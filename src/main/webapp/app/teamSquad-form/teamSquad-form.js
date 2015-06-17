/**
 * Created by joanmarc on 21/05/15.
 */
(function(){
    var app = angular.module("teamSquadForm", [ ]);

    app.directive("teamSquadForm", function(){
        return {
            restrict: "E",
            templateUrl: "teamSquad-form/teamSquad-form.html"
        };
    });

})();
