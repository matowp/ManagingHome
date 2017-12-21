/**
 * 
 */
package pl.codeprime.webservices.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.codeprime.repositories.UserRepository;
import pl.codeprime.repositories.entity.bills.shopping.Role;
import pl.codeprime.repositories.entity.bills.shopping.User;
import pl.codeprime.services.UserService;

/**
 * @author MOwsians
 *
 */
@RestController
@RequestMapping("/api/user")
public class UserController extends AbstractRestHandler {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/add/{username}/{password}", 
			produces = "application/json" )
	Response addUser(@PathVariable String username, @PathVariable String password) {

		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setRole(Role.USER);
		
		User save = userRepository.save(user);
		
		return Response.status(Status.OK).entity(save.toString()).build();
	}
	
	/**
	 * TODO: Remmember about add permit for only ADMIN.
	 * 
	 * @param username
	 * @param password
	 * @param role
	 * @return
	 */
	@RequestMapping(
			method = RequestMethod.PUT, 
			value = "/add/{username}/{password}/{role}", 
			produces = "application/json" )
	Response addUser(@PathVariable String username, @PathVariable String password, @PathVariable String role) {

		User user = new User();
		user.setPassword(password);
		user.setUsername(username);
		user.setRole(Role.getByName(role));
		
		User save = userRepository.save(user);
		
		return Response.status(Status.OK).entity(save.toString()).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/find/all")
	Response findAll(){
		
		ArrayList<User> users = new ArrayList<>();
		Iterable<User> findAll = userRepository.findAll();
		findAll.forEach(users::add);
		
		return Response.status(Status.OK).entity(users).build();
	}
	
	@RequestMapping(method = RequestMethod.GET,
					value = "/find/name/{username}")
	Response findByUsername(@PathVariable String username){
		
		List<User> findByUsername = userService.findByUsername(username);
		
		return Response.status(Status.OK).entity(findByUsername).build();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/find/id/{id}")
	Response findById(@PathVariable String id) {
		
		Response response = Response.status(Status.BAD_REQUEST).build();
		User obtainedUser = null;
		if(StringUtils.isNotEmpty(id)) {
			
			Long idL = Long.parseLong(id);
			obtainedUser = userRepository.findById(idL).orElse(new User());
			
			response = Response.status(Status.OK).entity(obtainedUser).build();
		}
		
		return response;
	}
	
}
