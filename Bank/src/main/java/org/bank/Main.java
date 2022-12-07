package org.bank;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import java.util.OptionalInt;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("bank-system");
        ActorRef bankAccount = system.actorOf(Props.create(BankAccount.class));

        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            int num;
            OptionalInt randomVal = rnd.ints(-1000, 1000).findFirst();
            if (randomVal.isPresent()) {
                num = randomVal.getAsInt();
            } else {
                num = i;
            }

            // Something not sending correctly
            if (num > 0) {
                bankAccount.tell(new DepositMessage(num), bankAccount);
            } else {
                bankAccount.tell(new WithdrawMessage(num), bankAccount);
            }
        }

        system.terminate();
    }
}
