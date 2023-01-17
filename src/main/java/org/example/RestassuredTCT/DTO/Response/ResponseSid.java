package org.example.RestassuredTCT.DTO.Response;

import lombok.*;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseSid {
    private String value;
}