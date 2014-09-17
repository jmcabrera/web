package web;

public class TestCdiBean {

	public String echo(String msg) {
		return "cdi-" + msg;
	}

}
