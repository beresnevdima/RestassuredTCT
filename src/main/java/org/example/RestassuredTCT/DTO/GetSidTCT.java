package org.example.RestassuredTCT.DTO;

import lombok.*;

@Data
@Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetSidTCT {
    private String value;
}