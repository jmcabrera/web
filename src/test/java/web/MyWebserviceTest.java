package web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyWebserviceTest {

	@Deployment(testable = true)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "web.war") //
				.addClass(MyWebservice.class) //
				.addClass(MyWebserviceImpl.class) //
		;
	}

	@Test
	public void testWs() throws MalformedURLException {
		String hello = "Hello!";
		URL wsdlURL = new URL("http://localhost:8080/web/MyWebserviceImpl?wsdl");
		QName SERVICE_NAME = new QName("http://web/", "MyWebserviceImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		MyWebservice client = service.getPort(MyWebservice.class);
		Assert.assertEquals("ws-" + hello, client.echo(hello));
	}

}
