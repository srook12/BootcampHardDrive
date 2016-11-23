appMod

	.controller("AppCtrl", ['$http', '$routeParams', '$location', function($http, $routeParams, $location) {
		var self = this;
		//console.log($routeParams);
		self.id = $routeParams.studentId;

		$http.get('http://localhost:8080/student')
			.then(function(resp){
				self.students = resp.data;
			},function(err) {

			});

		$http.get('http://localhost:8080/student/'+self.id)
			.then(function(resp){
				self.student = resp.data;
			},function(err) {

			});

		self.clear = function(student) {
			student.first_name = "";
			student.last_name = ""
			student.gpa = "";
			student.sat = "";
		};

		self.addupdStudent = function(func, id, firstName, lastName, sat, gpa) {
			var stud = {};
			stud.id = id;
			stud.first_name = firstName;
			stud.last_name = lastName;
			stud.sat = sat;
			stud.gpa = gpa;
			var method = func == 'add' ? 'POST' : 'PUT';
			$http({
					method: method,
					url: 'http://localhost:8080/student', 
					data: stud
				})
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$location.path('/student');
				},function(err) {
					console.log('FAILURE:', resp);
				});
		};

		self.addStudent = function(id, firstName, lastName, sat, gpa) {
			$("#loading").dialog('open').html("<p>Please Wait...</p>");
			var stud = {};
			stud.id = id;
			stud.first_name = firstName;
			stud.last_name = lastName;
			stud.sat = sat;
			stud.gpa = gpa;
			console.log(stud);
			$http.post('http://localhost:8080/student', stud)
				.then(function(resp){
					console.log('SUCCESS:', resp);
					$('#loading').html("<p>Result Complete...</p>");

					//$location.path('/student');
				},function(err) {
					console.log('FAILURE:', resp);
				});
		};

		self.updateStudent = function(id, firstName, lastName, sat, gpa) {
			self.addupdStudent('upd', id, firstName, lastName, sat, gpa)
		};

		self.deleteStudent = function(id) {
			$http.delete('http://localhost:8080/student/'+id)
				.then(function(resp){
					console.log("SUCCESS: ", resp);
				},function(err) {
					console.log('FAILURE:', resp);
				});

		};

	}]) // end controller
	

;// end all 