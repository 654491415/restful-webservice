package com.cn;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@WebService
@Path(value="/users/")
public interface UserService {

    @GET
    @Path("/")  //http://localhost:8080/webservice_restful/ws/users
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    List<User> getUsers();

    @DELETE
    @Path("{id}")  //http://127.20.54.206:8080/webservice_restful/ws/users/1
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML}) //请求accept
    Response delete(@PathParam("id") int id);

    @GET
    @Path("{id}") //http://ip:port/users/1
    @Produces(MediaType.APPLICATION_JSON)
    User getUser(@PathParam("id") int id);

    @POST
    @Path("add")
    Response insert(User user);
    @PUT
    @Path("update")
    Response update(User user);
}

