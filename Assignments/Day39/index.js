angular.module("StudentMod", ["ngRoute"])
	.controller("StudentCtrl", ['$http', '$routeParams', function($http, $routeParams){
		var self = this;

		self.id = $routeParams.id;

		$http.get("http://localhost:8080/students/list_students")
			.then(function(results) {
				self.students = results.data;
			});

		if(self.id != undefined) {
			
			$http.get("http://localhost:8080/students/student_info/" + self.id)
				.then(function(result) {
					self.student = result.data;
				});
		}

		self.validate = function(id) {
			var first_name = $("#first_name").val();
			var last_name = $("#last_name").val();
			var sat = $("#sat").val();
			var gpa = $("#gpa").val();

			var url = "http://localhost:8080/students/update_student/" + id + "/" + first_name + "/"
	   			  	+ last_name + "/"
	     			+ sat + "/"
	     			+ gpa + "/" + "0";

			$http.get(url).then(function() {
				window.location.href = "#/student";
			});
		}

	}])
	.config(['$routeProvider', function($routeProvider){
		$routeProvider
		.when('/', {
			templateUrl: 'views/home.html'

		}).when('/student', {
			templateUrl: 'views/student.html',
			controller: 'StudentCtrl',
			controllerAs: 'ctrl'

		}).when('/student_details/:id', {
			templateUrl: 'views/student_details.html',
			controller: 'StudentCtrl',
			controllerAs: 'ctrl'
		}).when('/about', {
			templateUrl: 'views/about.html'

		})
		.otherwise({redirectTo: '/'});




	}]); // end config