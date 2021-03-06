package ch.hearc.gotit.controllers;

import ch.hearc.gotit.entities.UserEntity;
import ch.hearc.gotit.services.UserService;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/users")
public class UserController {
	
	private static final String START_URI = "standards/users/";
	
	private static final String LIST_URI = START_URI + "list";
	private static final String EDIT_URI = START_URI + "edit";
	private static final String SIGN_IN_URI = START_URI + "sign_in";
	private static final String SIGN_UP_URI = START_URI + "sign_up";
	private static final String VIEW_URI = START_URI + "view";
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String getList(Model model) {
		model.addAttribute("usersEntitiesList", userService.findAll());
		
		return LIST_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String getEditById(@PathVariable int id, Model model) {
		UserEntity userEntity = userService.find(id);
		
		if (userEntity == null) {
			return "redirect:/users";
		}
		
		model.addAttribute("userEntity", userEntity);
		
		return EDIT_URI;
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
	public String postEditById(@PathVariable int id, @Valid UserEntity userEntity, BindingResult result) {
		if (result.hasErrors()) {
			return EDIT_URI;
		}
		
		userEntity.setUserPk(id);
		userService.update(userEntity);
		
		return "redirect:/users/" + userEntity.getUserPk();
	}
	
	@RequestMapping(value = "/sign-in", method = RequestMethod.GET)
	public String getSignIn(@RequestParam(value = "error", required = false) String error) {
		return SIGN_IN_URI;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.GET)
	public String getSignUp(Model model) {
		model.addAttribute("userEntity", new UserEntity());
		
		return SIGN_UP_URI;
	}
	
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	public String postSignUp(@Valid UserEntity userEntity, BindingResult result) {
		if (result.hasErrors()) {
			return SIGN_UP_URI;
		}
		
		userService.create(userEntity);
		
		return "redirect:/users/" + userEntity.getUserPk();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getViewById(@PathVariable int id) {
		return VIEW_URI;
	}
}
