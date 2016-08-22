<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Officer Dashboard</title>
	<link rel="stylesheet" href='<spring:url value="/resources/css/jquery-ui.min.css"></spring:url>' type="text/css" />
	<link rel="stylesheet" href='<spring:url value="/resources/css/officerHome.css"></spring:url>' type="text/css" />
	<script type="text/javascript" src='<spring:url value="/resources/js/jquery.min.js"></spring:url>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/js/jquery-ui.min.js"></spring:url>'></script>
	<script type="text/javascript" src='<spring:url value="/resources/js/officerHome.js"></spring:url>'></script>

</head>
<body>
	
	<a href="#" onclick="showDialog('dialog-stud-ops', 'tabs-stud-ops')">Student Management</a>
	
<!--  ///////////////////// Student Management ////////////////////////////////////////	-->
	<div id="dialog-stud-ops" title="Student Management">
		
		<div id="tabs-stud-ops">
			<ul>
			    <li><a href="#stud-ops-tab-1">Add Student</a></li>
			    <li><a href="#stud-ops-tab-2">View/Edit/Remove Student</a></li>
		  	</ul>
			<div id="stud-ops-tab-1" >
			
					<form  id="add-stud-form">
								
							<table>
								<tr>
									<td style="min-width:50%; max-width:50%;">
										<table>
											<tr><td>
												<img src="#" style="min-width:70px;max-width:70px;min-height:90px;max-height:90;">
												<input type="file"  name="pro_pic">
											</td></tr>
											<tr><td><input type="text" id="stud_name" placeholder="Students Name"></td></tr>
											<tr><td><input type="text" id="stud_dob" placeholder="Date of Birth" size="30"></td></tr>
										</table>
									</td>
									<td style="min-width:50%; max-width:50%;">
										<table>
											<tr><td><input type="text" id="stud_mob" placeholder="Mobile Phone"></td></tr>
											<tr><td><input type="text" id="stud_email" placeholder="E Mail"></td></tr>	
										</table>
									</td>
								</tr>
							</table>
							
						
								<button type="submit" id="btn-add-stud" class="btn btn-primary btn-lg">Add</button>
							
					</form>
					<div id="add-stud-feedback">
						<h5>Successfully added student</h5>
						<table>
							<tr>
								<td>Name : </td>
								<td><p id="disp-stud-name"></p></td>
							</tr>
							<tr>
								<td> Id: </td>
								<td><p id="disp-stud-id"></p></td>
							</tr>
						</table>
					</div>
					<button id="btn-add-new-stud" onclick="addNewStudent()"> Add Another Student</button>
			</div>
			<div id="stud-ops-tab-2">
				
				<form id="get-studs-form">
					<div>
						<select id="stud_search_course" >
							<option>All Students</option>
							<option>Course 01</option>
							<option>Course 02</option>
							<option>Course 03</option>
							<option>Course 04</option>
						</select>
						
						<input type="text" placeholder="Student ID" id="stud_search_id" />
						<input type="text" placeholder="Student Name" id="stud_search_name" />
						
						<button type="submit" id="btn-get-studs" class="btn btn-primary btn-lg">Get</button>
					</div>
				</form>
					<div id="disp-studs">
						<table id="stud_list" style="width:100%;">
						    <thead>
								<tr id="stud_list_head" style="background-color:#8585e0;">
									<td style="width:11%">ID</td>
									<td style="width:45%">Name</td>
									<td style="width:11%">Edit</td>
									<td style="width:11%">Delete</td>
									<td style="width:11%">View</td>
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
	<div id="edit_stud_popup" title="Edit Student"></div>
	<div id="delete_stud_popup" title="Delete Student"></div>
	<div id="view_stud_popup" title="Student Profile"></div>
	<div id="courses_stud_popup" title="Select Courses"></div>
<!--  ////////////////////////////// End of Student Management ///////////////////////////////////////////-->
</body>
</html>