package web;

import javax.jws.WebService;

// import org.jboss.ws.api.annotation.EndpointConfig;

@WebService
// @EndpointConfig(configFile = "WEB-INF/jaxws-endpoint-config.xml", configName
// = "Custom WS-Security Endpoint")
public class TestWebserviceImpl implements TestWebservice {

	public String echo(String msg) {
		return "ws-" + msg;
	}

}
