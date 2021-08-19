package org.snetwork.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDtoWithFriendsDto extends UserDto {
    private Set<UserDto> friends;

    public UserDtoWithFriendsDto(UUID id, UUID avatarId, String username, String email, String firstname, String lastname,
                                 String password, LocalDateTime lastVisit, Set<UserDto> friends) {
        super(id, avatarId, username, email, firstname, lastname, password, lastVisit);
        this.friends = friends;
    }
}
