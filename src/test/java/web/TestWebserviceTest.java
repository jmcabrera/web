package web;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class TestWebserviceTest {

	@Deployment(testable = true)
	public static WebArchive createDeployment() {
		WebArchive wa = ShrinkWrap.create(WebArchive.class, "web.war") //
				.addClass(TestWebservice.class) //
				.addClass(TestWebserviceImpl.class) //
		;
		System.out.println("~~~ v Web Archive Content v ~~~");
		wa.writeTo(System.out, Formatters.VERBOSE);
		System.out.println();
		System.out.println("~~~ ^ Web Archive Content ^ ~~~");
		return wa;
	}

	@Test
	public void testWs() throws MalformedURLException {
		String hello = "Hello!";
		URL wsdlURL = new URL("http://localhost:8080/web/TestWebserviceImpl?wsdl");
		QName SERVICE_NAME = new QName("http://web/", "TestWebserviceImplService");
		Service service = Service.create(wsdlURL, SERVICE_NAME);
		TestWebservice client = service.getPort(TestWebservice.class);
		Assert.assertEquals("ws-" + hello, client.echo(hello));
	}

}
