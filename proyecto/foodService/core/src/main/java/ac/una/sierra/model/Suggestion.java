package ac.una.sierra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.appfuse.model.BaseObject;

@Entity
public class Suggestion extends BaseObject {

	private Long id;
	private ServiceUser user;
	private Food food;
	private String commentary;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "user")
	public ServiceUser getUser() {
		return user;
	}

	public void setUser(ServiceUser user) {
		this.user = user;
	}

	@Column(name = "food")
	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@Column(name = "commentary", length = 100)
	public String getCommentary() {
		return commentary;
	}

	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentary == null) ? 0 : commentary.hashCode());
		result = prime * result + ((food == null) ? 0 : food.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Suggestion other = (Suggestion) obj;
		if (commentary == null) {
			if (other.commentary != null)
				return false;
		} else if (!commentary.equals(other.commentary))
			return false;
		if (food == null) {
			if (other.food != null)
				return false;
		} else if (!food.equals(other.food))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Suggestion [id=" + id + ", user=" + user + ", food=" + food + ", commentary=" + commentary + "]";
	}
	
}
