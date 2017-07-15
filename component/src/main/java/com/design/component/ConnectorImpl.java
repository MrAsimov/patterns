package com.design.component;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectorImpl implements Connector {

    private Queue<byte[]> messageQueue;

    public ConnectorImpl() {
        messageQueue = new LinkedList<>();
    }

    @Override
    public void sendMessage(byte[] message) {
        messageQueue.add(message);
    }
}