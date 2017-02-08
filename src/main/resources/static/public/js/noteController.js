(function () {
    "use strict";

    var noteController = function ($scope, noteService) {
        $scope.sortBy = 'name';
        $scope.reverse = false;
       
        function init() {
             noteService.getNotes()
                .then(function(response) {
                     
                   var in_notes = []; 
                   var i;
                   
                   for(i = 0; i <response.data.length ; i++){
                   
                   		var obj={
                   			id: response.data[i].id,
                   			title: response.data[i].title,
                   			content: response.data[i].content
                   		}
                   		in_notes.push(obj);	
                   	}
                   	
                   	$scope.notes =in_notes;
                    console.log($scope.notes);
                    
                    
                }, function(data, status, headers, config) {
                    $log.log(data.error + ' ' + status);
                });
        }
        
        init();
        
        $scope.doSort = function (propName) {
            $scope.sortBy = propName;
            $scope.reverse = !$scope.reverse;
        };
    };
    
    
    noteController.inject = ['$scope','noteService'];
    
    angular.module('noteApp').controller('noteController', noteController);
    
}());