package web;

import java.net.MalformedURLException;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.formatter.Formatters;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyEjbTest {

	@Deployment(testable = true)
	public static WebArchive createDeployment() {
		WebArchive wa = ShrinkWrap.create(WebArchive.class) //
				.addAsWebInfResource(new StringAsset("<ejb-jar />"), "ejb-jar.xml") //
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml") //
				.addClass(MyEjb.class) //
		;
		System.out.println("~~~ v Web Archive Content v ~~~");
		wa.writeTo(System.out, Formatters.VERBOSE);
		System.out.println();
		System.out.println("~~~ ^ Web Archive Content ^ ~~~");
		return wa;
	}

	@Inject
	private MyEjb	ejb;

	@Test
	public void testEjb() throws MalformedURLException {
		String hello = "Hello!";
		Assert.assertEquals("ejb-" + hello, ejb.echo(hello));
	}
}
