var id = getParameterByName("id");
var mode = getParameterByName("mode");

// If id is null, set to a value that won't be found in the
// database, but can still be queried
if(id == null) {
	id = -1;
}

// Generate the details page based on the mode
$(document).ready(function() {
	//generateDetailsPage();
	$("#update_button").click(function() {
		validateForm();
	})
})


// Handle to the element representing the top level container
var first_name_row;
var last_name_row;
var sat_row;
var gpa_row;
var major_id_row;
var button_row;

// Handle to the individual data elements
var first_name;
var last_name;
var sat;
var gpa;
var major_id;

$(document).ready(function() {
	first_name_row = $("#first_name_row");
	last_name_row = $("#last_name_row");
	sat_row = $("#sat_row");
	gpa_row = $("#gpa_row");
	major_id_row = $("#major_id_row");
	button_row = $("#button_row");
})

angular.module("StudentDetailsMod", [])
	.controller("StudentDetailsCtrl", ['$scope','$http', function($scope, $http) {
		var self = this;
		
		// Get student data
		$http.get("http://localhost:8080/students/student_info/" + id).then(function(result){
			self.student = result;
			console.log(self.student);
			
			// Only get the data for a valid id
			if(id > 0) {
				first_name = result.data.first_name;
				last_name = result.data.last_name;
				sat = result.data.sat;
				gpa = (result.data.gpa).toFixed(2);
				major_id = result.data.major_id;				
			} else {
				first_name = "";
				last_name = "";
				sat = "";
				gpa = "";
			}
			
			self.generateFirstNameTd = function() {
				if(mode == "read" || mode == "delete") {
					first_name_row.append($("<td><label>" + first_name + "</label></td>"));
				} else if(mode == "edit" || mode == "create") {
					first_name_row.append($("<input id=\"first_name\" name=\"first_name\" type=\"text\" value=\"" + 
							first_name + "\" required />"));
				}
			}
			
			self.generateLastNameTd = function() {
				if(mode == "read" || mode == "delete") {
					last_name_row.append($("<td><label>" + last_name + "</label></td>"));
				} else if(mode == "edit" || mode == "create") {
					last_name_row.append($("<input id=\"last_name\" name=\"last_name\" type=\"text\" value=\"" + 
							last_name + "\" required />"));
				}
			}
			
			self.generateSatTd = function() {
				if(mode == "read" || mode == "delete") {
					sat_row.append($("<td><label>" + sat + "</label></td>"));
				} else if(mode == "edit" || mode == "create") {
					sat_row.append($("<input id=\"sat\" name=\"sat\" type=\"text\" value=\"" + 
							sat + "\" />"));
					sat_row.append($("<div id=\"sat_error\" class=\"error_text\">*SAT score must be between " +
							"400 and 1600 inclusive or left blank</div>"));									
				} 
			}
			
			self.generateGpaTd = function() {
				if(mode == "read" || mode == "delete") {
					gpa_row.append($("<td><label>" + gpa + "</label></td>"));
				} else if(mode == "edit" || mode == "create") {
					gpa_row.append($("<input id=\"gpa\" name=\"gpa\" type=\"text\" value=\"" + 
							gpa + "\" required />"));
					gpa_row.append($("<div id=\"gpa_error\" class=\"error_text\">*GPA must be between 0.0 and 4.0 inclusive</div>"));
				}
			}
			
			self.generateMajorIdTd = function() {
				var major_description;
				
				if(mode == "read" || mode == "delete") {
					if(major_id == null) {
						major_description = "Undeclared";
					} else {
						major_description = major_id.description;
					}
						
					major_id_row.append($("<td><label>" + major_description + "</label></td>"));
				} else if(mode == "edit" || mode == "create") {
					/*
					if(major_id != null) { 
						buildMajorDropdown(sat, major_id.id);
					} else {
						buildMajorDropdown(sat);
					}*/
				}
			}
			
			self.generateButtonTd = function() {				
				if(mode == "delete") {
					button_row.append($("<td colspan=\"2\" class=\"text-center\"><button id=\"delete_button\">Delete</button></td>"));
				} else if(mode == "edit") {
					button_row.append($("<td colspan=\"2\" class=\"text-center\"><button id=\"update_button\">Update</button></td>"));
				} else if(mode == "create") {
					button_row.append($("<td colspan=\"2\" class=\"text-center\"><button id=\"save_button\">Save</button></td>"));
				}
				
				$("#delete_button").click(function() {
					var proceed = confirm("Are you sure that you want to delete this student? This action cannot be undone.");
					
					if(proceed) {
						$http.get("http://localhost:8080/students/delete_student/" + id)
							.then(function() {
								window.location.href = "./student_list";
							})						
					}
				})
				
				$("#update_button").click(function() {
					console.log("Clicked update!");
				})
				
				$("#save_button").click(function() {
					console.log("Saved!");
				})
			}
			
			
			function buildMajorDropdown(sat, major_id) {
				sat = isNullOrEmptySat(sat);
				console.log(sat);
				console.log(major_id);
				
				if(isValidSat(sat)) {
					
					$http.get("http://localhost:8080/majors/list_eligible_majors/" + sat)
						.then(function(results) {
							//var select = $("<select></select>");
							
							/*
							while ( select.childNodes.length >= 1 )
							{
							    select.removeChild(select.firstChild);       
							}
						
							select.appendChild(new Option("Undeclared", "0"));
							for(var idx = 0; idx < result.length; idx++) {
								select.appendChild(new Option(result[idx]["description"] + " (" + result[idx]["req_sat"] + ")", result[idx]["id"]));
								
								if(major_id == data[idx]["id"]) {
									select.value = major_id;
								}
							}
							*/	
						});
					/*
					sat_row.change(function() {
						sat = sat_input.val();
						
						var e = document.getElementById("major_id");
						var major_id = e.options[e.selectedIndex].value;
				
						buildMajorDropdown(sat, major_id);
					})
					*/
				}
			}	
			
			
			
		}); 
		
		self.printGpa = function (gpa) {
			return gpa.toFixed(2);
		}
		
	}]) // end controller
	

	
function getParameterByName(name, url) {
	if (!url) {
		url = window.location.href;
    }
    	
    name = name.replace(/[\[\]]/g, "\\$&");
    var regex = new RegExp("[?&]" + name + "(=([^&#]*)|&|#|$)"),
    results = regex.exec(url);
    		
    if (!results) { 
    	return null;
    }
    if (!results[2]) {
    	return '';
    }
    	
    return decodeURIComponent(results[2].replace(/\+/g, " "));
}

function isValidSat(sat) {
	return((sat >= 400 && sat <= 1600) || sat == 0);
}

function isNullOrEmptySat(sat) {
	if(sat == null || sat == "") {
		sat = 0;
	}
	
	return sat;
}


/*
function generateDetailsPage() {
	var details = $("#details");
		
	details.append(generateRow("First name", "first_name"));
	details.append(generateRow("Last name", "last_name"));
	details.append(generateRow("SAT Score", "sat"));
	details.append(generateRow("GPA", "gpa"));
	
	$("#first_name").html("{{2+7}}");
}

function generateFirstNameSection(details) {
	var first_name_row = $("<tr>");

	// Label
	var first_name_label = $("<td class='text-right body_font'>First Name:</td>");
	first_name_row.append(first_name_label);
	
	// Value
	first_name_row.append(generateValueTd());
	
	first_name_row.append($("</tr>"));
	
	return first_name_row;
}

function generateRow(label_name, id) {
	var row = $("<tr>");
	
	var label = $("<td class='text-right body_font'>" + label_name + ":</td>");
	row.append(label);
	
	var value = generateValueTd(id);
	row.append(value);
	
	row.append($("</tr>"));
	
	return row;
}

function generateValueTd(id) {
	var value_td = $("<td class='body_font'>");
	if(mode == "read" || mode == "delete") {
		value_td.append(generateElementWithId("label", id));
	} else if (mode == "create" || mode == "edit") {
		value_td.append(generateElementWithId("text", id)); 
	}	
	value_td.append($("</td>"));
	
	return value_td;
}

function generateElementWithId(type, id) {
	var element;
	if(type == "label") {
		element = $("<label id='" + id + "'></label>");
	} else if(type == "text") {
		element = $("<input id='" + id + "' type='text' />");
	}
	
	return element;
}
*/

function validateForm() {
	var valid = true;
	var sat = $("#sat").val();
	var gpa = $("#gpa").val();
	
	if(!isValidSat(sat)) {
		$("#sat_error").show();
		$("#sat").addClass("error_border");
		valid = false;
	} else {
		$("#sat_error").hide();
		$("#sat").removeClass("error_border");
	}
	
	if(gpa < 0.0 || gpa > 4.0) {
		$("#gpa_error").show();
		$("#gpa").addClass("error_border");
		valid = false;
	} else {
		$("#gpa_error").hide();
		$("#gpa").removeClass("error_border");
	}
	
	if(valid == true) {
		submitForm();
	}
}

function submitForm() {
	var first_name = $("#first_name").val();
	var last_name = $("#last_name").val();
	var sat = $("#sat").val();
	var gpa = $("#gpa").val();
	/*
	var e = document.getElementById("major_id");
	var major_id = e.options[e.selectedIndex].value;
	*/		
	if(sat === "") {
		sat = 0;
	}
	
	url = "http://localhost:8080/students/update_student/" + id + "/" + first_name + "/"
	     + last_name + "/"
	     + sat + "/"
	     + gpa + "/" + "0";
			
	$.ajax({url: url});
	
	
	
	window.location.href = "./student_list";
}