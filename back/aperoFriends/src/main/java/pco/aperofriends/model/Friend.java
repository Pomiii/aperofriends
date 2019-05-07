package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the FRIEND database table.
 * 
 */
@Entity
//@NamedQuery(name="Friend.findAll", query="SELECT f FROM Friend f")
public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFriend;
	
	@Size(max = 50)
	private String firstnameFriend;

	@Size(max = 50)
	private String lastnameFriend;

	@Size(max = 50)
	private String mailFriend;

	@Size(max = 50)
	private String passFriend;
	
	@OneToMany(mappedBy="buyer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties("buyer")
	private List<Bucket> buckets;
	
	private int idAf;

	public int getIdFriend() {
		return idFriend;
	}

	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}

	public String getFirstnameFriend() {
		return firstnameFriend;
	}

	public void setFirstnameFriend(String firstnameFriend) {
		this.firstnameFriend = firstnameFriend;
	}

	public String getLastnameFriend() {
		return lastnameFriend;
	}

	public void setLastnameFriend(String lastnameFriend) {
		this.lastnameFriend = lastnameFriend;
	}

	public String getMailFriend() {
		return mailFriend;
	}

	public void setMailFriend(String mailFriend) {
		this.mailFriend = mailFriend;
	}

	public String getPassFriend() {
		return passFriend;
	}

	public void setPassFriend(String passFriend) {
		this.passFriend = passFriend;
	}

	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}
	
	public int getIdAf() {
		return idAf;
	}

	public void setIdAf(int idAf) {
		this.idAf = idAf;
	}	

	public Friend() {
		
	}

	public Friend(int idFriend, String firstnameFriend, String lastnameFriend, String mailFriend, String passFriend,
			 List<Bucket> buckets, int idAf) {
		super();
		this.idFriend = idFriend;
		this.firstnameFriend = firstnameFriend;
		this.lastnameFriend = lastnameFriend;
		this.mailFriend = mailFriend;
		this.passFriend = passFriend;
		this.buckets = buckets;
		this.idAf = idAf;
	}

	@Override
	public String toString() {
		return "Friend [idFriend=" + idFriend + ", firstnameFriend=" + firstnameFriend + ", lastnameFriend="
				+ lastnameFriend + ", mailFriend=" + mailFriend + ", passFriend=" + passFriend  
				+ ", buckets=" + buckets + ", idAf=" + idAf +"]";
	}

}