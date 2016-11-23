angular.module("AppMod", [])
	.controller("AppCtrl", ["$http", function($http) {
		var self = this;
		self.hide = function(id) {
			console.log("Param of hide is [" + id + "]");
			for(var student of self.students) {
				if(student.id == id) {
					console.log("Found it");
				}
			}
		};

		$http.get("http://localhost:8080/student")
			.then(function(resp) {
				self.students = resp.data;
				// for( var s of self.students) {
				// 	s.vis = true;
				// }
			}, function(err) {
			});

	}]); // end controller