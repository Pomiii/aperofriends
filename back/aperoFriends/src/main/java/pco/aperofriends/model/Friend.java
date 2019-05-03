package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
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

	private String passFriend;
	
	@Size(max = 50)
	private String phonefriend;
	
	@OneToMany(mappedBy="buyer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnoreProperties("buyer")
	private List<Bucket> buckets;
	
	private int idAF;

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

	public String getPhonefriend() {
		return phonefriend;
	}

	public void setPhonefriend(String phonefriend) {
		this.phonefriend = phonefriend;
	}
	
	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public Friend() {
		
	}

	public Friend(int idFriend, String firstnameFriend, String lastnameFriend, String mailFriend, String passFriend,
			String phonefriend, List<Bucket> buckets, int idAF) {
		super();
		this.idFriend = idFriend;
		this.firstnameFriend = firstnameFriend;
		this.lastnameFriend = lastnameFriend;
		this.mailFriend = mailFriend;
		this.passFriend = passFriend;
		this.phonefriend = phonefriend;
		this.buckets = buckets;
		this.idAF = idAF;
	}

	@Override
	public String toString() {
		return "Friend [idFriend=" + idFriend + ", firstnameFriend=" + firstnameFriend + ", lastnameFriend="
				+ lastnameFriend + ", mailFriend=" + mailFriend + ", passFriend=" + passFriend + ", phonefriend="
				+ phonefriend + ", buckets=" + buckets + ", idAF=" + idAF +"]";
	}

	public int getIdAF() {
		return idAF;
	}

	public void setIdAF(int idAF) {
		this.idAF = idAF;
	}	
}