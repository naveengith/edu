package com.edumatrix.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edumatrix.core.entity.formfields.lecturer.CourseContent;
import com.edumatrix.core.entity.formfields.lecturer.StudentDisplay;
import com.edumatrix.core.entity.formfields.lecturer.Viewlec;
import com.edumatrix.core.jsonviews.AjaxResponse;
import com.edumatrix.core.jsonviews.Views;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
public class LecturerOps {
	
	
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/getStudentsDisplay", method=RequestMethod.POST)
	public AjaxResponse getStudentD(@RequestBody StudentDisplay StudentDisplay){
		
		System.out.println(StudentDisplay);
		
		AjaxResponse response = new AjaxResponse();
		
		response.setCode("200");
		response.setContent("[{\"id\":001, \"name\":\"pasan\"}, {\"id\":002, \"name\":\"pasan2\"}, {\"id\":003, \"name\":\"pasan3\"}]");
		System.out.println(response);
		return response;
	}
	
	
	
	
	@JsonView(Views.Public.class)
	@RequestMapping(value="/getLecturer", method=RequestMethod.POST)
	public AjaxResponse getlecView(@RequestBody Viewlec Viewlec){
		
		System.out.println(Viewlec);
		
		AjaxResponse response = new AjaxResponse();
		
		response.setCode("200");
		response.setContent("[{\"id\":001, \"name\":\"pasan\" ,\"email\":\"pasn@gmail.com\"}, {\"id\":002, \"name\":\"pasan2\",\"email\":\"pasn@gmail.com\"}, {\"id\":003, \"name\":\"pasan3\",\"email\":\"pasn@gmail.com\"}]");
		System.out.println(response);
		return response;
	}


@JsonView(Views.Public.class)
@RequestMapping(value="/getCourse", method=RequestMethod.POST)
public AjaxResponse getcourseContent(@RequestBody CourseContent CourseContent){
	
	System.out.println(CourseContent);
	
	AjaxResponse response = new AjaxResponse();
	
	response.setCode("200");
	response.setContent("[{\"id\":001,\"subject name\"maths\", \"name\":\"pasan\" ,}, {\"id\":002,\"subject name\"maths\", \"name\":\"pasan2\"}, {\"id\":003,\"subject name\"maths\", \"name\":\"pasan3\"}]");
	System.out.println(response);
	return response;
}

}
