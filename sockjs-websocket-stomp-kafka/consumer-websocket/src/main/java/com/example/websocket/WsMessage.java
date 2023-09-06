package com.example.websocket;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class WsMessage {
    private String sender;
    private String message;
}
