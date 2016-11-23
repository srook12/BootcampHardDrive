/**
 * 
 */

var token= "Md8f09f24-ed48-c00e-07f9-17715fcb0651";
var url="https://apis.skype.com/v2/conversations/8:Starborn/activities";
var message = "Hi!";


var data = {"message": {"content" : "Hi! (wave)"}};

$.ajax(url, {
	headers: {"Authorization": "Bearer " + token}, body: JSON.stringify(data), method : "post"})
