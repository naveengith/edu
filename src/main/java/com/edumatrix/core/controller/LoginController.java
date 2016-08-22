package com.edumatrix.core.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.edumatrix.core.entity.User;
import com.edumatrix.core.service.InstituteService;
import com.edumatrix.core.service.UserService;


@Controller
public class LoginController {
	
	/*@Autowired
	private InstituteService intituteService;
	@Autowired
	private UserService	userService;
	
	
	
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String getLoginForm(HttpServletRequest request, Model model){
		
		
		String saved_inst_id = "";
		String saved_inst_title = "";
		String saved_inst_city = "";
		
		if(request.getCookies() != null){
			Cookie[] cookies = request.getCookies();
			for(Cookie c : cookies){
				
				if(c.getName().equals("saved_inst_id")){saved_inst_id = c.getValue();}
				if(c.getName().equals("saved_inst_title")){saved_inst_title = c.getValue();}
				if(c.getName().equals("saved_inst_city")){saved_inst_city = c.getValue();}
			}
			
			if((!saved_inst_title.equals("")) && (!saved_inst_id.equals("0")) ){
				model.addAttribute("saved_inst_title", saved_inst_title);
				model.addAttribute("saved_inst_id", saved_inst_id);
				model.addAttribute("saved_inst_city", saved_inst_city);
			}
		}
		
		
		return "login";
		
		return "officerHome";
	}
	


	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(value="inst_id", defaultValue="0") int inst_id,
						@RequestParam(value="username", defaultValue="") String username,
						@RequestParam(value="password", defaultValue="") String password,
						HttpServletResponse response, HttpServletRequest request, 
						Model model){
		
		
		if((inst_id != 0) && (!username.equals("")) && (!password.equals(""))){
		
			int isAuthorized = userService.getUserAuthenticated(inst_id, username, password);
			
			if(isAuthorized > 0){
				
				User user = userService.getUser(isAuthorized);
				
				String inst_name = user.getInstitute().getInst_name();
				String inst_city = user.getInstitute().getInst_city();
				
			
				Cookie titleCookie = new Cookie("saved_inst_title", inst_name);
				Cookie idCookie = new Cookie("saved_inst_id", ""+inst_id+"");
				Cookie cityCookie = new Cookie("saved_inst_city", inst_city); 
				
				
				titleCookie.setPath("/");
				idCookie.setPath("/");
				cityCookie.setPath("/");
				
				
				
				response.addCookie(idCookie);
				response.addCookie(titleCookie);
				response.addCookie(cityCookie);
				
				request.getSession().setAttribute("user", user);
				
				if(user.getAuthLevel().toLowerCase().equals("officer")){
					return "officerHome";
				}else if(user.getAuthLevel().toLowerCase().equals("manager")){
					return "managerHome";
				}else if(user.getAuthLevel().toLowerCase().equals("lecturer")){
					return "lecturerHome";
				}else{
					return "error";
				}	
				
			}else{
				model.addAttribute("login_status", "Invalid");
				return "login";
			}
		}else{
			model.addAttribute("login_status", "Invalid");
			return "login";
		}
		
	}



	
	@RequestMapping(value="/freshLogin", method=RequestMethod.GET)
	public String getFreshLogin(){
		
		Cookie id = new Cookie("saved_inst_id", null);
		Cookie name = new Cookie("saved_inst_name", null);
		Cookie city = new Cookie("saved_inst_city", null);
		
		id.setPath("/");
		name.setPath("/");
		city.setPath("/");
		
		id.setMaxAge(0);
		name.setMaxAge(0);
		city.setMaxAge(0);
		
		return "login";
	}



	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public void destroySession(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		request.getSession().setAttribute("user", null);
		response.sendRedirect("/Edu-Matrix/");
		
	}



/////////////////////////////// Common Methods ////////////////////////////////////////////////	
	@ModelAttribute
	public void addInstListForAll(Model model){
		model.addAttribute("inst_list", intituteService.fetchAllInstitutes());
	}
	

*/
	@RequestMapping(value="/", method=RequestMethod.GET )
	public String getLoginForm(){ return "lecturerHome"; }
}
