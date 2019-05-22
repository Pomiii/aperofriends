package pco.aperofriends.dto;

import pco.aperofriends.model.Role;

public class FriendDto {
	
    private String mailFriend;

    private Role role;

    private FriendDto() {

    }

    public FriendDto(String mailFriend) {
        this.mailFriend = mailFriend;
    }

    public FriendDto(String mailFriend, Role role) {
        this.mailFriend = mailFriend;
        this.role = role;
    }

}
