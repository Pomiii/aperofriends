package pco.aperofriends.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the AccountFriends database table.
 * 
 */
@Entity
@Table(name="AccountFriends")
@NamedQuery(name="AccountFriend.findAll", query="SELECT a FROM AccountFriend a")
public class AccountFriend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAF;

	private String addressAccount;

	private String nameAccount;

	private String phoneAccount;

	//bi-directional many-to-one association to Bucket
	@OneToMany(mappedBy="accountFriend")
	private List<Bucket> buckets;

	//bi-directional many-to-many association to Friend
	@ManyToMany(mappedBy="accountFriends")
	private List<Friend> friends;

	public AccountFriend() {
	}

	public AccountFriend(String addressAccount, String nameAccount, String phoneAccount) {
		this.addressAccount = addressAccount;
		this.nameAccount = nameAccount;
		this.phoneAccount = phoneAccount;
	}

	public int getIdAF() {
		return this.idAF;
	}

	public void setIdAF(int idAF) {
		this.idAF = idAF;
	}

	public String getAddressAccount() {
		return this.addressAccount;
	}

	public void setAddressAccount(String addressAccount) {
		this.addressAccount = addressAccount;
	}

	public String getNameAccount() {
		return this.nameAccount;
	}

	public void setNameAccount(String nameAccount) {
		this.nameAccount = nameAccount;
	}

	public String getPhoneAccount() {
		return this.phoneAccount;
	}

	public void setPhoneAccount(String phoneAccount) {
		this.phoneAccount = phoneAccount;
	}

	public List<Bucket> getBuckets() {
		return this.buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public Bucket addBucket(Bucket bucket) {
		getBuckets().add(bucket);
		bucket.setAccountFriend(this);

		return bucket;
	}

	public Bucket removeBucket(Bucket bucket) {
		getBuckets().remove(bucket);
		bucket.setAccountFriend(null);

		return bucket;
	}

	public List<Friend> getFriends() {
		return this.friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}

}