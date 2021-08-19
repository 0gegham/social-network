package org.snetwork.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {
    private UUID id;

    @JsonProperty(value = "user_id")
    private UUID userId;

    @JsonProperty(value = "conversation_id")
    private UUID conversationId;
}
