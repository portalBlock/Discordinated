package net.portalblock.discordinated.websocket;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by portalBlock on 7/18/2016.
 */
@NoArgsConstructor
public class PayloadWrapper {

    @Getter private int op;

    @Getter private Object d;

    @Getter Integer s;

    @Getter private String t;

    public PayloadWrapper(HeartbeatPayload heartbeat) {
        this.op = heartbeat.getOp();
        this.d = heartbeat.getSequence();
        this.s = heartbeat.getSequence();
    }

    public PayloadWrapper(int op, WSPayload wsPayload, int sequenceNumber, String eventName) {
        this.op = op;
        this.d = wsPayload;
        this.s = sequenceNumber;
        this.t = eventName;
    }

    public PayloadWrapper(int op, WSPayload wsPayload) {
        this.op = op;
        this.d = wsPayload;
    }

    public PayloadWrapper(int op, WSPayload wsPayload, String eventName) {
        this.op = op;
        this.d = wsPayload;
        this.t = eventName;
    }

    @AllArgsConstructor
    public static class HeartbeatPayload {

        @Getter private int op;

        @Getter private Integer sequence;

    }

}
