package code.sample.app.rest.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import code.sample.app.rest.ui.models.User;

@RestController("/user")
public class UserController {
	private AtomicLong userID = new AtomicLong(0l);
	private HashMap<Long,User> userList = new HashMap<Long,User>();

	/**
	 * Create user
	 * @param user
	 * @return
	 */
	@PostMapping
	public User createUser(@RequestBody User user) {

		Long id = userID.incrementAndGet();
		user.setId(id);
		userList.put(id,user);
		System.out.println(userList);
		return user;

	}
	
	/**
	 * Get user by userId
	 * @param userID
	 * @return
	 */
	 @GetMapping(value="/user/{userid}")
	 @ResponseBody
     public User getUser (@PathVariable(value= "userid") Long userID) {
		System.out.println("getting get ..."+userID+"    "+userList.get(userID));
		return  userList.get(userID);
	}
	 
	 /**
	  * Get all users 
	  * @return
	  */
	 @GetMapping
	 public List<User> getUser(){
		 
		return userList.values().stream().collect(Collectors.toList());
	 }
	 
	 
}
