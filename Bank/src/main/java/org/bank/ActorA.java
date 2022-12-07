package org.bank;

import akka.actor.AbstractActor;

public class ActorA extends AbstractActor {
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(MessageA.class, this::onMessageA)
                .build();
    }

    private void onMessageA(MessageA msg) {
        System.out.printf("Actor A received Message A: %s, from %s%n", msg.text, getSender());
    }
}
