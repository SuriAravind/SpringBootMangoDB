package com.example.demoMongodb.resource;

import java.util.List;
import java.util.Optional;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demoMongodb.document.Users;
import com.example.demoMongodb.repository.UserRepository;

@RestController
@RequestMapping("rest/users")
public class UserResource {
      private UserRepository userRepository;
	
	  public UserResource(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	  @RequestMapping(value ="/all",method=RequestMethod.GET)
	  public List<Users> gettAll(){
		  return userRepository.findAll();
	  }
	
	@GetMapping("/{id}")
	  public Optional<Users> findById(@PathVariable final Integer id){
		  return userRepository.findById(id);
	 }
	@RequestMapping(value="/delete/{id}",method=RequestMethod.DELETE)
	  public ModelAndView deleteById(@PathVariable final Integer id){
		  userRepository.deleteById(id);
		  return new ModelAndView("redirect:/rest/users/all");
	 }
	@RequestMapping(value="/update/{id}",method=RequestMethod.PUT)
	  public ModelAndView updateById(Users user,@PathVariable final Integer id){
		 userRepository.save(user);
		 return new ModelAndView("redirect:/rest/users/all");
	 }
	@RequestMapping(value ="/add",method=RequestMethod.POST)
    public  ModelAndView addUser(Users user) {
        userRepository.save(user);
        return new ModelAndView("redirect:all");
    }
	
}
