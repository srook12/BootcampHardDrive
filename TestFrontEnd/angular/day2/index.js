angular.module("AppMod", [])
	.controller("AppCtrl", [function() {
		var self = this;
		self.about = "AppMod";

		self.submit = function() {
			console.log("User clicked submit with user " + self.user);
		};


	}]); // end controller