package org.example.RestassuredTCT.DTO.Response;

import lombok.*;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ResponseSidTCT {
    private String value;
}