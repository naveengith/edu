//////////////////Common behaviours for officer dash board ///////////
	
/////// 2 functions to hide and view elements 
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


	function loadDatePicker(id){
		var datePicker = "#" + id;
		$( datePicker ).datepicker({ dateFormat:'yy-mm-dd'});
	}

////////////Dialog Box for Student Management//////////////////////////////////////////////

 $(function() {
    $( "#dialog-stud-ops" ).dialog({autoOpen:false, width:800, minHeight:500});
  });
  
////////////Controller Calls - Add New student //////////////////////
	jQuery(document).ready(function($) {

		$("#add-stud-form").submit(function(event) {

			// Disable the search button
			enableAddStudBtn(false);

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			addStudent();

		});

	});
/////////////// Add New Student form Ajax ////////////////////////////////////////
	function addStudent() {

		var newStudent = {}                                        /// Bind values to the array
		newStudent["name"] = $("#stud_name").val();                
		newStudent["bday"] = $("#stud_dob").val();         			/// Same value names as the binding entity object
		newStudent["tp_no"] = $("#stud_mob").val();
		newStudent["email"] = $("#stud_email").val();

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Edu-matrix/addStudent",
			data : JSON.stringify(newStudent),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				if(data.code == '200'){
					
					setHidden('add-stud-form');
					setVisible('add-stud-feedback');
					setVisible('btn-add-new-stud');
					document.getElementById('disp-stud-name').innerHTML=data.msg;
					document.getElementById('disp-stud-id').innerHTML=data.content;
				}
				
			},
			error : function(e) {
				console.log("ERROR: ", e);
				alert('error');
				
			},
			done : function(e) {
				console.log("DONE");
				enableAddStudBtn(true);
			}
		});

	}

	function enableAddStudBtn(flag) {
		$("#btn-add-stud").prop("disabled", flag);
	}

	
	function addNewStudent(){
		setHidden('add-stud-feedback');
		setHidden('btn-add-new-stud');
		setVisible('add-stud-form');
		document.getElementById('add-stud-form').reset();
	}
	
///////////////// View/Edit/Delete Student form Ajax ///////////////////////////////////////	
	
	jQuery(document).ready(function($) {

		$("#get-studs-form").submit(function(event) {

			// Prevent the form from submitting via the browser.
			event.preventDefault();

			getStudents();

		});

	});
	
	function getStudents() {

		var studentParams = {}                                        /// Bind values to the array

		studentParams["courseId"] = $("#stud_search_course").val();                
		studentParams["studId"] = $("#stud_search_id").val();         			/// Same value names as the binding entity object
		studentParams["studName"] = $("#stud_search_name").val();
		

		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Edu-matrix/getstudents",
			data : JSON.stringify(studentParams),
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
/////////////////// create student list nodes and append them 
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
			                                                       " <td> <a onclick=\"editStudent('" + obj[i].id + "') \">Edit</a></td>" +
			                                                       " <td> <a onclick=\"deleteStudent('" + obj[i].id + "') \">Delete</a></td>" +
			                                                       " <td> <a onclick=\"viewStudent('" + obj[i].id + "') \">View</a></td>" +
			                                                       " <td> <a onclick=\"setStudentCourses('" + obj[i].id + "') \">Courses</a></td>" +
			                                                       " </tr>";
		}
	}
	///////////////////////Pop up- popup functions //////////////
	//////////////delete student/////////////////////////
	function deleteStudent(studId){
		$("#delete_stud_popup").text("Are you sure? You cannot undo this.");
		$( "#delete_stud_popup" ).dialog({
		    height:200,
		    modal: true,
		    buttons: {
		        Delete: function() {
		        	deleteStud(studId);
		        	$(this).dialog('close');
		        },
		        Cancel: function() {		        	
		            $(this).dialog('close');
		        }
		    }
		});
	}
	function deleteStud(studId) {

		var student = {}                                        

		student["std_id"] = studId;                
        
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Edu-matrix/deletestudent",
			data : JSON.stringify(student),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);

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
	///////////////// view Student profile //////////////////////
	function viewStudent(studId){
		getStud(studId);
	}
	function getStud(studId) {

		var student = {}                                        

		student["std_id"] = studId;                
        
		$.ajax({
			type : "POST",
			contentType : "application/json",
			url : "/Edu-matrix/getstudent",
			data : JSON.stringify(student),
			dataType : 'json',
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);

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
	
	
	function editStudent(studId){
		alert(studId);
	}
	
	function setStudentCourses(studId){
		alert(studId);
	}
/////////////////////////////////// Dialog boxes for pop-popups /////////////////////////////


	