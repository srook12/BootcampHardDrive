/**
 * 
 */
// Controllers can be added at other levels of HTML documents (e.g. two divs side by side can use different controllers)

// Controller always goes inside a module

// Anonymous function is always the last member of the array of the controller. Can be any
// number of arguments before it
                         // Dependencies if they exist
angular.module("AppMod", [])
	.controller("AppCtrl", [function() {
		var self = this;
		self.about = "AppMod";
		self.myattribute = "This is my attribute!";
		
		// attach to the model
		self.changeAbout = function(something) {
			console.log("here");
			self.about= "AngularJS " + something;
		};
		
		self.students = [
			{id: 1, name: "Papa Smurf", sat: 1200, gpa: 3.5, vis: true},
			{id: 2, name: "Jokey Smurf", sat: 1150, gpa: 2.9, vis: false},
			{id: 3, name: "Handy Smurf", sat: 1400, gpa: 3.8, vis: false},
			{id: 4, name: "Brainy Smurf", sat: 1600, gpa: 4.0, vis: true}
		];
		
		console.log(self.students);
		
		self.toggleVisibility = function() {
			console.log("here");
			
			for(var std of self.students) {
				if(std.vis == true) {
					std.vis = false;
				} else {
					std.vis = true;
				}
			}
		};
		
	}]); // end controller 