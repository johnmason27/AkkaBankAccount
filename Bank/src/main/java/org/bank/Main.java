package org.bank;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("test-system");
        ActorRef actorARef = system.actorOf(Props.create(ActorA.class));

        actorARef.tell(new MessageA("Hello!"), actorARef);

        system.terminate();
    }
}
