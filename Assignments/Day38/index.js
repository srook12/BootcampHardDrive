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