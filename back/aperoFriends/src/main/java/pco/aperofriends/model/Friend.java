package pco.aperofriends.model;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;


/**
 * The persistent class for the Friend database table.
 * 
 */
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

	
	//bi-directional many-to-many association to AccountFriend
	@ManyToMany
	@JoinTable(
		name="FriendList"
		, joinColumns={
			@JoinColumn(name="idFriend")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idAF")
			}
		)
	private List<AccountFriend> accountFriends;

	@ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> roleList;

	public Friend() {
	}

	public Friend(String firstnameFriend, String lastnameFriend, String mailFriend, String passFriend, List<Role> rolelist) {
		this.firstnameFriend = firstnameFriend;
		this.lastnameFriend = lastnameFriend;
		this.mailFriend = mailFriend;
		this.passFriend = passFriend;
		this.roleList = rolelist;
	}
	
	public Friend(@NotNull String mailFriend, @NotNull String passFriend) {
        this.mailFriend = mailFriend;
        this.passFriend = passFriend;
    }
	
	public Friend(@NotNull String mailFriend,  @NotNull String passFriend, List<Role> roleList) {
        this.mailFriend = mailFriend;
        this.passFriend = passFriend;
        this.roleList = roleList;
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

	public List<Role> getRoleList() {
		return this.roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

}