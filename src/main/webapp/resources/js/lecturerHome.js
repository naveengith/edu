function setVisible(elementId){
		document.getElementById(elementId).style.display = "block";
	}
	
	function setHidden(elementId){
		document.getElementById(elementId).style.display = "none";
	}

// Load the dialog box and tabs inside it, uses loadTabs function 
	function showDialog(dialog_id, tabs_id){
		var dialogId = "#" + dialog_id;
		$( dialogId ).dialog("open");
		loadTabs(tabs_id);
		loadDatePicker('stud_dob');
	}

//// Load tabs when given id	
	function loadTabs(id){
		var tabList = "#" + id;
		$( tabList ).tabs();
	}
	
	function loadTabs(id){
		var tabList = "#" + id;
		$( tabList ).tabs();
	}
	
	
	$(function() {
	    $( "#dialog-stud-ops" ).dialog({autoOpen:false, width:800, minHeight:500});
	  });
	
	$(function() {
	    $( "#dialog-lec-ops" ).dialog({autoOpen:false, width:800, minHeight:500});
	  });

	$(function() {
	    $( "#dialog-coz-ops" ).dialog({autoOpen:false, width:800, minHeight:500});
	  });
	
	
	
	
	
	
	
	jQuery(document).ready(function($) {

		$("#get-std-crs").submit(function(event) {

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			getStudentsDisplay();

		});

	});
	jQuery(document).ready(function($) {

		$("#get-crs").submit(function(event) {

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			getCourse();

		});

	});
	
	function getStudentsDisplay() {
		
		//var s = document.getElementById("select_course");
		
		
		var StudentDisplay = {}                                        /// Bind values to the array

		StudentDisplay["courseId"] = $("#select_course").val();  
		
		StudentDisplay["classId"] = $("#select_class").val();
		
		

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Edu-matrix/getStudentsDisplay",
			data : JSON.stringify(StudentDisplay),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				if(data.code == '200'){
					
					dispStudentList(data.content);	
				}
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				alert('error');
				
			},
			done : function(e) {
				console.log("DONE");
			}
		});

	}
	
function dispStudentList(contentString){
		
		var obj = eval(contentString);
		////////////remove any previously added table rows
		if(document.getElementById("stud_list").rows.length > 1){
			   var newTBody = document.createElement("TBODY");
			   var oldTBody = document.getElementById("stud_list_body");
			   newTBody.id = "stud_list_body";
			   oldTBody.parentNode.replaceChild(newTBody, oldTBody);
			
		}
	///////////// set student id , name , and edit delete, view	
		for(i=0; i<obj.length; i++) {
		    
			document.getElementById("stud_list_body").innerHTML += " <tr>" + 
			                                                       " <td>" + obj[i].id + "</td>" +
			                                                       " <td>" + obj[i].name + "</td>" +
			                                                       " <td> <a onclick=\"editStudent('" + obj[i].id + "') \">View Results</a></td>" +
			                                                       " <td> <a onclick=\"deleteStudent('" + obj[i].id + "') \">View Parent</a></td>" +
			                                                       " <td> <a onclick=\"viewStudent('" + obj[i].id + "') \">View Attendance</a></td>" +
			                                                       " <td> <a onclick=\"setStudentCourses('" + obj[i].id + "') \">Courses</a></td>" +
			                                                       " </tr>";
		}

}


function getLecturer(){
	
	var viewlec = {}        
	
	
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/Edu-matrix/getLecturer",
		data : JSON.stringify(viewlec),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			if(data.code == '200'){
				
				dispLecList(data.content);	
			}
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			alert('error');
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
function dispLecList(contentString){
		
		var obj = eval(contentString);
		////////////remove any previously added table rows
		if(document.getElementById("lec_list").rows.length > 1){
			   var newTBody = document.createElement("TBODY");
			   var oldTBody = document.getElementById("lec_list_body");
			   newTBody.id = "lec_list_body";
			   oldTBody.parentNode.replaceChild(newTBody, oldTBody);
			
		}
	///////////// set student id , name , and edit delete, view	
		for(i=0; i<obj.length; i++) {
		    
			document.getElementById("lec_list_body").innerHTML += " <tr>" + 
			                                                       " <td>" + obj[i].id + "</td>" +
			                                                       " <td>" + obj[i].name + "</td>" +
			                                                       " <td>" + obj[i].email + "</td>" +
			                                                       " </tr>";
		}

}

	
	

	
	
}
function getCourse(){
	
	var CourseContent = {}        
	
	
	
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/Edu-matrix/getCourse",
		data : JSON.stringify(viewlec),
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			console.log("SUCCESS: ", data);
			if(data.code == '200'){
				
				dispCozList(data.content);	
			}
			
		},
		error : function(e) {
			console.log("ERROR: ", e);
			alert('error');
			
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
function dispCozList(contentString){
		
		var obj = eval(contentString);
		////////////remove any previously added table rows
		if(document.getElementById("coz_list").rows.length > 1){
			   var newTBody = document.createElement("TBODY");
			   var oldTBody = document.getElementById("coz_list_body");
			   newTBody.id = "coz_list_body";
			   oldTBody.parentNode.replaceChild(newTBody, oldTBody);
			
		}
	///////////// set student id , name , and edit delete, view	
		for(i=0; i<obj.length; i++) {
		    
			document.getElementById("coz_list_body").innerHTML += " <tr>" + 
			                                                       " <td>" + obj[i].id + "</td>" +
			                                                       " <td>" + obj[i].subject name + "</td>" +
			                                                       " <td>" + obj[i].name + "</td>" +
			                                                       " </tr>";
		}

}

	
	

	
	
}
