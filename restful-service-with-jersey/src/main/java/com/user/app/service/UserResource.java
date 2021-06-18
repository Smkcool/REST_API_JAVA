package main.java.com.user.app.service;



import java.util.List;

import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import main.java.com.user.app.model.ResponseVO;
import main.java.com.user.app.model.UserVO;
import main.java.com.user.app.util.UserUtil;
 
   

@Path("/users") 
public class UserResource { 
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	public List<UserVO> getAllUsers() {
		
		return UserUtil.getUsers();
	}
	
	@GET 
	@Produces(MediaType.APPLICATION_JSON) 
	@Path("/{id}") 
	public UserVO getUser(@PathParam("id") int userid) {
		
		return UserUtil.getUser(userid);
	}
	
	@PUT
	public ResponseVO addNewUser (UserVO userVo) {
		System.out.println(userVo);
		UserUtil.addUser(userVo);
		return new ResponseVO(true,"New user Created successfully");
	}
	
	@POST 
	public ResponseVO updateUser (UserVO userVo) {
		System.out.println(userVo);
		UserUtil.updateUser(userVo);
		return new ResponseVO(true,"User data updated successfully");
	}
	
	@DELETE
	@Path("/{id}") 
	public ResponseVO deleteUser (@PathParam("id") int userid) {
		System.out.println(userid);
		UserUtil.deleteUser(userid);
		return new ResponseVO(true,"User deleted successfully");
	}
}
