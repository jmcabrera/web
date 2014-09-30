package web;

import javax.jws.WebService;

@WebService
public class MyWebserviceImpl implements MyWebservice {

	public String echo(String msg) {
		return "ws-" + msg;
	}

}
