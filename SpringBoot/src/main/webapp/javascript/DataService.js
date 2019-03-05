var baseUrl = "/springBoot";
var baseUserUrl = "/springBoot/user";
var baseUserUrlctest = "/springBoot/ctest";
var baseUserUrlepatest = "/springBoot/epatest";

function ctest() {
	return $.ajax({
		url : baseUrl + "/ctest",
		type : "GET",
		async : true,
		dataType : "json",
		success : function(data) {
			console.log(data);
		},
	// context : context,
	// error : this.errorHandler,
	});
}

function login(object, successCallBack) {
	return $.ajax({
		url : baseUserUrl + "/login",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : successCallBack,
	// context : context,
	// error : this.errorHandler,
	});
}

function logintrue(object) {
	return $.ajax({
		url : baseUserUrl + "/logintrue",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (!data.bool) {				
				window.location.href = 'index.html'
			} 
		},
	});
}

function formtrue(object) {
	return $.ajax({
		url : baseUserUrl + "/formtrue",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (!data.bool) {
				window.location.href = 'homepage.html';
			} 
		},
	});
}

function formtruemovectest(object) {
	return $.ajax({
		url : baseUserUrl + "/formtrue",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {
				window.location.href = 'ctest.html';
			} 
		},
	});
}

function formtruemoveepatest(object) {
	return $.ajax({
		url : baseUserUrl + "/formtrue",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {
				window.location.href = 'epatest.html';
			} 
		},
	});
}

function addinfo(object) {
	return $.ajax({
		url : baseUserUrl + "/addinginfo",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {				
				window.location.href = 'ctest.html'
			}else{
				alert('You arent logged in  anymore please loggin before');
			}
		},
	});
}

function addinfo2(object) {
	return $.ajax({
		url : baseUserUrl + "/addinginfo",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {				
				window.location.href = 'epatest.html'
			}else{
				alert('You arent logged in  anymore please loggin before');
			}
		},
	});
}

function addanswers(object) {
	return $.ajax({
		url : baseUserUrlctest + "/addingtest",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {
				alert('Thanks for filling in the test :)');
				window.location.href = 'homepage.html'
			}else{
				alert('You did something wrong going back to home');
				window.location.href = 'homepage.html'
			}
		},
	});
}

function addanswersepa(object) {
	return $.ajax({
		url : baseUserUrlepatest + "/addingtest",
		type : "POST",
		async : true,
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(object),
		success : function(data) {
			if (data.bool) {
				alert('Thanks for filling in the test :)');
				window.location.href = 'homepage.html'
			}else{
				alert('You did something wrong going back to home');
				window.location.href = 'homepage.html'
			}
		},
	});
}

function goForm(string) {
	window.location.href = string;
}

function getAnswers(string) {
	var answer = '';
	$('#'+string+'>input').map(function () {
		answer = answer + $.trim(this.value)  + ',';
	});
	return answer.slice(0,-1);
}
