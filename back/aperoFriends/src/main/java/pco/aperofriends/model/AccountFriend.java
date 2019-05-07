package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the ACCOUNTFRIENDS database table.
 * 
 */
@Entity
//@Table(name="ACCOUNTFRIENDS")
//@NamedQuery(name="Accountfriend.findAll", query="SELECT a FROM Accountfriend a")
public class AccountFriend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAf;
	
	private String nameAccount;
	
	private String addressAccount;
	
	private String phoneAccount;

	@JsonIgnore
	@ManyToMany(mappedBy = "bucket", cascade = CascadeType.REMOVE)
	@JoinTable(name = "bucket", joinColumns = {
            @JoinColumn(name = "idBucket") }, inverseJoinColumns = { @JoinColumn(name = "idAF") })
	private List<Bucket> buckets;	
	
	/*@OneToMany(mappedBy="friend")
	* @JsonIgnoreProperties("friend")
	* private List<Friend> friends;
	*/
	public int getIdAf() {
		return idAf;
	}

	public void setIdAF(int idAf) {
		this.idAf = idAf;
	}

	public String getNameAccount() {
		return nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public String getAddressAccount() {
		return addressAccount;
	}

	public void setAddressAccount(String addressAccount) {
		this.addressAccount = addressAccount;
	}

	public List<Bucket> getBuckets() {
		return buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}
	
	public String getPhoneAccount() {
		return phoneAccount;
	}

	public void setPhoneAccount(String phoneAccount) {
		this.phoneAccount = phoneAccount;
	}

	public AccountFriend() {
	}

	public AccountFriend(int idAf, String nameAccount, String addressAccount, String phoneAccount,List<Bucket> buckets) {
		super();
		this.idAf = idAf;
		this.nameAccount = nameAccount;
		this.addressAccount = addressAccount;
		this.phoneAccount = phoneAccount;
		this.buckets = buckets;
	}

	@Override
	public String toString() {
		return "AccountFriend [idAf=" + idAf + ", nameAccount=" + nameAccount + ", addressAccount=" + addressAccount
				+ ", phoneAccount=" + phoneAccount + ", buckets=" + buckets + "]";
	}

	//public List<Friend> getFriends() {
	//	return friends;
	//}

	//public void setFriends(List<Friend> friends) {
	//	this.friends = friends;
	//}
	
}