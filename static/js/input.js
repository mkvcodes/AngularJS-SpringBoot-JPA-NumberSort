var app = angular.module("mySortingApp", []); 
app.controller("myCtrl", function($scope, $http) {
    $scope.products = [1, 0, -9, 3];
    $scope.addItem = function () {
    	$scope.sortedNumbers = "";
    	$scope.prevResults = "";
        $scope.errortext = "";
        if (!$scope.addMe) {return;}
        if ($scope.products.indexOf($scope.addMe) == -1) {
            $scope.products.push($scope.addMe);
        } else {
            $scope.errortext = "The number is already in your sorting list.";
        }
    }
    $scope.removeItem = function (x) {
        $scope.errortext = "";    
        $scope.products.splice(x, 1);
    }
    $scope.sortNumbers = function () {
    	$scope.prevResults = "";
    	var t0 = performance.now();
    	var parameter = JSON.stringify({userValues: $scope.products});
    	
        $http.post('sortnumbers',parameter).
	        then (function(data) {
	            $scope.sortedNumbers = data;
	            var t1 = performance.now();
	            $scope.timeTaken = (t1 - t0);
	        }, function errorCallback (result) {
            	console.log(result);
        	});
    }
    $scope.diplayResults = function () {
    	$scope.sortedNumbers = "";
    	
    	$http.get('findall').
	        then (function(response) {
	            $scope.prevResults = response.data.reverse();
	        }, function errorCallback (result) {
            	console.log(result);
        	});
    }
});