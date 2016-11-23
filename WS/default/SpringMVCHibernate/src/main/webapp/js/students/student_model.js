angular.module("StudentMod", [])
	.controller("StudentCtrl", ['$scope','$http', function($scope, $http) {
		var self = this;
				
		$scope.dummy = 12;
		
		$http.get("http://localhost:8080/students/list_students").then(function(data){
			self.students = data;		
			$scope.students = data;
		});
		
		self.formatGpa = function(gpa) {
			return gpa.toFixed(2);
		}
		
		self.getMajorDescription = function(major_id) {
			var description;
			
			if(major_id == null) {
				description = "Undeclared";
			} 
			
			else {
				description = major_id.description;
			}
			
			return description;
		}
		
		self.generateLink = function(id) {
			return("./student_details?id=" + id);
		}
	}]);

function formatMajor(id, major_id) {
	var major_col = $("#major_col_" + id);
	//var major_col = $("#major_col");	
	
	if(major_id == null) {
		major_col.append("Undeclared");
	} 
	
	else {
		major_col.append($("<a href=\"http://localhost:8080/majors/major_details?id=" + major_id.id + "&mode=read\">" + major_id.description + "</a>"));
	}
}

function echo(x) {
	console.log(x);
}