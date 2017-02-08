(function() {
    var noteFactory = function($http) {
    
        var factory = {};
        
        factory.getNotes = function() {
            return $http.get('/getNote');
        };
        
        
        return factory;
    };
    
    noteFactory.$inject = ['$http'];
        
    angular.module('noteApp').factory('noteFactory', 
    		noteFactory);
                                           
}());