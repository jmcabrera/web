package web;

public class MyCdiBean {

	public String echo(String msg) {
		return "cdi-" + msg;
	}

}
