package org.example.RestassuredTCT.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class RequestGetSidTCT {

    private RequestInfo user;

    @Data
    @AllArgsConstructor
    public static class RequestInfo {

        private String auth;
        private String login;
        private String password;
    }
}