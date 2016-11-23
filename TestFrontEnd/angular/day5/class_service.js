appMod
	.service('ClassService', function() {
		var self = this;

		self.sayHello = function() {
			return "Hello, service!";
		}

	});