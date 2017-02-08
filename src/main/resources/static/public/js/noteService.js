/*global angular*/
(function () {
    "use strict";
    var noteService = function ($http) {
       
        this.getNotes = function () {
        	return $http.get('/getNote');
        };
        
        noteService.$inject = ['$http'];
    };
    
    angular.module('noteApp').service('noteService', noteService);
    
}());