package web;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface TestWebservice {

	@WebMethod
	public String echo(String msg);
}
