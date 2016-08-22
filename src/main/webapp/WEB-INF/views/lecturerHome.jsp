<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>lecturer Dashboard</title>
	<link rel="stylesheet" href='<spring:url value="/resources/css/jquery-ui.min.css"></spring:url>' type="text/css" />
	<link rel="stylesheet" href='<spring:url value="/resources/css/officerHome.css"></spring:url>' type="text/css" />
	<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"></spring:url>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui.min.js"></spring:url>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/js/lecturerHome.js"></spring:url>'></script>


</head>
<body>
	
	<a href="#" onclick="showDialog('dialog-stud-ops', 'tabs-stud-ops')">Student</a>
	
	
<!--  ///////////////////// Student Management ////////////////////////////////////////	-->
	<div id="dialog-stud-ops" title="Student">
	<div id="tabs-stud-ops">
		<form id=get_std_crs>
		
		<div><label>Select Class</label></br>
											<select id="select_class"  size="5">
											
												<option id="opt1"> six</option>
												<option id="opt2" > seven</option>
												<option id="opt3"> eight</option>
												<option id="opt4" > o/l</option>
												
											</select>
											</div>
			<div><label>Select Course</label></br>				
											<select id="select_course"  size="5">
											
												<option id="opt1"> Chemistry 03</option>
												<option id="opt2" > Bio 04</option>
												<option id="opt3"> Art 05</option>
												<option id="opt4" > Politics 06</option>
												
											</select>
											
											<button id="btn-get-studs" class="btn btn-primary btn-lg" onclick="getStudentsDisplay()">Get</button>
										</div>
										</form>
			
			<div id="stud-ops-tab-2">
				
				
					<div id="disp-studs">
						<table id="stud_list" style="width:100%;">
						    <thead>
								<tr id="stud_list_head" style="background-color:#8585e0;">
									<td style="width:11%">ID</td>
									<td style="width:45%">Name</td>
									<td style="width:11%">View Results</td>
									<td style="width:11%">View Parent</td>
									<td style="width:11%">View Attendance</td>
									<td style="width:11%">Courses</td>
								</tr>
							</thead>
							<tbody id="stud_list_body">
							</tbody>		
						</table>
					</div>
			</div>
		</div>
	</div>
	
<!--  ////////////////////////////// End of Student Management ///////////////////////////////////////////

<!-- ////////////////////////////////view lecturers////////////////////////////////////////////////////// 

 
	<a href="#" onclick="showDialog('dialog-lec-ops', 'tabs-lec-ops')">lecturers</a>

<div id="dialog-lec-ops" title="lecturer">
	<div id=tabs-lec-ops>
	
		<button id="btn-get-lec" class="btn btn-primary btn-lg" onclick="getLecturer()">Get</button>
	
				<div id="lec-ops-tab-2">
				
				
					<div id="disp-lec">
						<table id="lec_list" style="width:100%;">
						    <thead>
								<tr id="lec_list_head" style="background-color:#8585e0;">
									<td style="width:11%">ID</td>
									<td style="width:45%">Name</td>
									<td style="width:11%">Email</td>
									
								</tr>
							</thead>
							<tbody id="lec_list_body">
							</tbody>		
						</table>
					</div>
			</div>
	
			
	</div>
	</div>
	
<!--  ////////////////////////////// End of View lecturer ///////////////////////////////////////////

<!-- ////////////////////////////////Course Content////////////////////////////////////////////////////// 

	<a href="#" onclick="showDialog('dialog-coz-ops', 'tabs-coz-ops')">Course Content</a>
 
<div id="dialog-coz-ops" title="Course Content">
	<div id=tabs-coz-ops>
	
				<div id="coz-ops-tab-2">
				<form id=get_crs>
				<div><label>Select Class</label></br>
											<select id="select_class_1"  size="5">
											
												<option id="opt1"> six</option>
												<option id="opt2" > seven</option>
												<option id="opt3"> eight</option>
												<option id="opt4" > o/l</option>
												
											</select>
											
											<button id="btn-get-coz" class="btn btn-primary btn-lg" onclick="getCourse()">Get</button>
											</div>
											</form>
				
					<div id="disp-coz">
						<table id="coz_list" style="width:100%;">
						    <thead>
								<tr id="coz_list_head" style="background-color:#8585e0;">
									<td style="width:11%">class</td>
									<td style="width:45%">Subject Name</td>
									<td style="width:11%">Lecturer name</td>
									
								</tr>
							</thead>
							<tbody id="coz_list_body">
							</tbody>		
						</table>
					</div>
			</div>
	
			
	</div>
	</div>

-->

</body>
</html>