package pco.aperofriends.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@NamedQuery(name="Friend.findAll", query="SELECT f FROM Friend f")
public class Friend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idFriend;

	private String firstnameFriend;

	private String lastnameFriend;

	private String mailFriend;

	private String passFriend;

	//bi-directional many-to-one association to Bucket
	@JsonManagedReference
	@OneToMany(mappedBy="friend")
	private List<Bucket> buckets;
	
	//bi-directional many-to-one association to TypeItem
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="id_role")
	private Role role;
	
	//bi-directional many-to-many association to AccountFriend
	@ManyToMany
	@JoinTable(
		name="FriendList"
		, joinColumns={
			@JoinColumn(name="id_friend")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idaf")
			}
		)
	private List<AccountFriend> accountFriends;
	
	public Friend() {
		
	}
	
	public Friend(String mailFriend) {
        this.mailFriend = mailFriend;
	}

	public Friend(String mailFriend, String passFriend) {
        this.mailFriend = mailFriend;
        this.passFriend = passFriend;
    }

    public Friend(String mailFriend, String passFriend, Role role) {
        this.mailFriend = mailFriend;
        this.passFriend = passFriend;
    }
    
    public Friend(String firstnameFriend, String lastnameFriend, String mailFriend, String passFriend) {
		this.firstnameFriend = firstnameFriend;
		this.lastnameFriend = lastnameFriend;
		this.mailFriend = mailFriend;
		this.passFriend = passFriend;
	}

	public Friend(String firstnameFriend, String lastnameFriend, String mailFriend, String passFriend, Role role) {
		this.firstnameFriend = firstnameFriend;
		this.lastnameFriend = lastnameFriend;
		this.mailFriend = mailFriend;
		this.passFriend = passFriend;
		this.role = role;
	}

	public int getIdFriend() {
		return this.idFriend;
	}

	public void setIdFriend(int idFriend) {
		this.idFriend = idFriend;
	}

	public String getFirstnameFriend() {
		return this.firstnameFriend;
	}

	public void setFirstnameFriend(String firstnameFriend) {
		this.firstnameFriend = firstnameFriend;
	}

	public String getLastnameFriend() {
		return this.lastnameFriend;
	}

	public void setLastnameFriend(String lastnameFriend) {
		this.lastnameFriend = lastnameFriend;
	}

	public String getMailFriend() {
		return this.mailFriend;
	}

	public void setMailFriend(String mailFriend) {
		this.mailFriend = mailFriend;
	}

	public String getPassFriend() {
		return this.passFriend;
	}

	public void setPassFriend(String passFriend) {
		this.passFriend = passFriend;
	}

	public List<AccountFriend> getAccountFriends() {
		return this.accountFriends;
	}

	public void setAccountFriends(List<AccountFriend> accountFriends) {
		this.accountFriends = accountFriends;
	}
	
	public List<Bucket> getBuckets() {
		return this.buckets;
	}

	public void setBuckets(List<Bucket> buckets) {
		this.buckets = buckets;
	}

	public Bucket addBucket(Bucket bucket) {
		getBuckets().add(bucket);
		bucket.setFriend(this);

		return bucket;
	}

	public Bucket removeBucket(Bucket bucket) {
		getBuckets().remove(bucket);
		bucket.setFriend(null);

		return bucket;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	

}