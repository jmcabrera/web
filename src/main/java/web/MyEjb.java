package web;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class MyEjb {

	public String echo(String msg) {
		return "ejb-" + msg;
	}

}
