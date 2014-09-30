package web;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MyJPAEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int			id;

	private String	message;

	private Date		timestamp;

	public MyJPAEntity() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public boolean equals(Object obj) {
		if (null == obj) return false;
		if (this == obj) return true;
		if (obj instanceof MyJPAEntity) {
			MyJPAEntity that = (MyJPAEntity) obj;
			return id == that.id;
		}
		return false;
	}

	@Override
	public int hashCode() {
		return id;
	}

}
