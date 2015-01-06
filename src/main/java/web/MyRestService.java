/**
 * 
 */
package web;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * @author a208220 - Juan Manuel CABRERA
 *
 */
public class MyRestService {

	@GET
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/greeting")
	public Response greeting() {
		return Response.ok().entity("Hello").build();
	}

}
