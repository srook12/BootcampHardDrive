var app = angular.module("todos", []);

/*
app.controller("TodosCtrl", ["$http", function($http) {
	
}])
*/

app.controller("TodosCtrl", TodosCtrl);

TodosCtrl.$inject = ["Items"]
function TodosCtrl(Items) {
	var self = this;
	self.todos = Items.all;
	/*
	self.todos = [
		{description: "First thing", timestamp: new Date(), complete: false},
		{description: "Second thing", timestamp: new Date(), complete: true},
		{description: "Third thing", timestamp: new Date(), complete: true},
		{description: "Fourth thing", timestamp: new Date(), complete: false},
	];*/

	self.limit = 2;

	self.reverseList = function() {
		self.todos.reverse();
		self.limit++;
	}

	self.markComplete = function(item) {
		item.complete = true;
	}

	self.createItem = function() {
		
	}
}

angular
	.module("todos")
	.service("Items", Items)

function Items() {
	return {all: [1,2,3,4,5]};
}

angular
	.module("todos")
	.controller("TodosCountCtrl", TodosCountCtrl)

TodosCountCtrl.$inject = ["Items"]
function TodosCountCtrl(Items) {
	var self = this;
	console.log(Items);
	self.count = Items.all.length;
}

