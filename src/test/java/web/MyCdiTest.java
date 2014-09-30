package web;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class MyCdiTest {

	@Deployment(testable = true)
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class) //
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml") //
				.addClass(MyCdiBean.class) //
		;
	}

	@Inject
	private MyCdiBean	bean;

	@Test
	public void testCdi() throws InterruptedException {
		String hello = "Hello!";
		Assert.assertEquals("cdi-" + hello, bean.echo(hello));
	}

}
