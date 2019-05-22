package pco.aperofriends.dto;

import pco.aperofriends.model.Role;

public class FriendDto {
	
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

}
