package pco.aperofriends.dto;

import pco.aperofriends.model.Role;

public class FriendDto {
	
	private int idFriend;
	
	private String firstnameFriend;

	private String lastnameFriend;
	
    private String mailFriend;

    private Role role;

    public FriendDto() {

    }

    public FriendDto(String mailFriend) {
        this.mailFriend = mailFriend;
    }

    public FriendDto(String mailFriend, Role role) {
        this.mailFriend = mailFriend;
        this.role = role;
    }
    
    public FriendDto(int idFriend, String firstnameFriend, String lastnameFriend, String mailFriend, Role role) {
        this.idFriend = idFriend;
        this.firstnameFriend = firstnameFriend;
        this.lastnameFriend = lastnameFriend;
        this.mailFriend = mailFriend;
        this.role = role;
    }

	public String getMailFriend() {
		return mailFriend;
	}

	public void setMailFriend(String mailFriend) {
		this.mailFriend = mailFriend;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

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

}
