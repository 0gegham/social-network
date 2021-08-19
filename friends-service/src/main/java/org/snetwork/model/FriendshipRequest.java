package org.snetwork.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendshipRequest {

    @JsonProperty(value = "user_id")
    private UUID userId;

    @JsonProperty(value = "friend_id")
    private UUID friendId;
}
