package web;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class MyEjb {

	@PersistenceContext
	private EntityManager	em;

	public String echo(String msg) {
		MyJPAEntity entity = new MyJPAEntity();
		entity.setMessage(msg);
		entity.setTimestamp(new Date());
		em.persist(entity);
		return "ejb-" + msg;
	}

}
