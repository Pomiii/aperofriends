package pco.aperofriends.dto;


import javax.validation.constraints.NotNull;

import pco.aperofriends.model.Role;

import java.util.List;

/**
 * Specific App User DTO to be able to send user data without password through REST responses.
 */
public class FriendDto {

    private String mailFriend;

    private String passFriend;

    private List<Role> roleList;

    private FriendDto() {

    }

    public FriendDto(@NotNull String mailFriend) {
        this.mailFriend = mailFriend;
    }

    public FriendDto(@NotNull String mailFriend, List<Role> roleList) {
        this.mailFriend = mailFriend;
        this.roleList = roleList;
    }
}