package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the Role database table.
 * 
 */
@Entity
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRole;

	private String role;

	//bi-directional many-to-many association to Friend
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<Friend> friends;

	public Role() {
	}

	public int getIdRole() {
		return this.idRole;
	}

	public void setIdRole(int idRole) {
		this.idRole = idRole;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<Friend> getFriends() {
		return this.friends;
	}

	public void setFriend(List<Friend> friends) {
		this.friends = friends;
	}
	
	public Friend addFriend(Friend friend) {
		getFriends().add(friend);
		friend.setRole(this);

		return friend;
	}

	public Friend removeFriend(Friend friend) {
		getFriends().remove(friend);
		friend.setRole(null);

		return friend;
	}

}