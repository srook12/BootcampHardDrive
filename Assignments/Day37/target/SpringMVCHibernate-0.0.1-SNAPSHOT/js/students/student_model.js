angular.module("StudentMod", [])
	.controller("StudentCtrl", ['$scope','$http', function($scope, $http) {
		var self = this;
				
		$http.get("http://localhost:8080/students/list_students").then(function(data){
			
			self.students = data;
						
		});
		
		self.formatGpa = function(gpa) {
			return gpa.toFixed(2);
		}
		
		self.formatMajor = function(description) {
			if(description == null) {
				description = "Undeclared";
			}
			
			return description;
		}
		
		self.generateButton = function() {
			return $("<button>My Button</button>");
		}
	}]);