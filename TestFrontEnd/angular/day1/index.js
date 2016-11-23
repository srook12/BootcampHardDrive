angular.module("AppMod", [])
	.controller("AppCtrl", [function() {
		var self = this;
		self.about = "AppMod";

		self.changeAbout = function(parm1) {
			for(var std of self.students) {
				std.vis = true;
			}
		};

		self.students = [
			{id: 1, name: 'Greg Doud', sat: 1200, gpa: 1.5, vis: true},
			{id: 2, name: 'Cindy Doud', sat: 1600, gpa: 4.5, vis: false},
			{id: 3, name: 'Nick Doud', sat: 1400, gpa: 3.5, vis: true},
			{id: 4, name: 'Ken Doud', sat: 1400, gpa: 3.5, vis: false}
		];

	}]); // end controller