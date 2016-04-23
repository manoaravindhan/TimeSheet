/**
 * 
 */
package com.timesheet;

/**
 * @author Mano
 *
 */
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * http://localhost:8080/TimeSheet/rest/UserService/users
 */
@Path("/UserService")
public class UserService {
	UserData userData = new UserData();

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserBean> getUsers(){
		return userData.getAllUserBeans();
	}
}