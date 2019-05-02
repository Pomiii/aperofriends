package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	private int idAF;
	
	private String nameAccount;
	
	private String addressAccount;
	
	private String phoneAccount;

	@JsonIgnore
	@ManyToMany
	private List<Bucket> buckets;

	public int getIdAF() {
		return idAF;
	}

	public void setIdAF(int idAF) {
		this.idAF = idAF;
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

	public AccountFriend() {
	}

	public AccountFriend(int idAF, String nameAccount, String addressAccount, String phoneAccount,List<Bucket> buckets) {
		super();
		this.idAF = idAF;
		this.nameAccount = nameAccount;
		this.addressAccount = addressAccount;
		this.phoneAccount = phoneAccount;
		this.buckets = buckets;
		
	}

	@Override
	public String toString() {
		return "AccountFriend [idAF=" + idAF + ", nameAccount=" + nameAccount + ", addressAccount=" + addressAccount
				+ ", phoneAccount=" + phoneAccount + ", buckets=" + buckets + "]";
	}

	public String getPhoneAccount() {
		return phoneAccount;
	}

	public void setPhoneAccount(String phoneAccount) {
		this.phoneAccount = phoneAccount;
	}
	
}