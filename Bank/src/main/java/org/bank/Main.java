package org.bank;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.bank.messages.DepositMessage;
import org.bank.messages.WithdrawMessage;

import java.util.OptionalInt;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("bank-system");
        final LoggingAdapter log = Logging.getLogger(system,system);

        ActorRef bankAccount = system.actorOf(Props.create(BankAccount.class));

        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            log.info("Generating random message: " + (i + 1));
            int num;
            OptionalInt randomVal = rnd.ints(-1000, 1000).findFirst();
            if (randomVal.isPresent()) {
                num = randomVal.getAsInt();
            } else {
                num = i;
            }

            if (num > 0) {
                bankAccount.tell(new DepositMessage(i + 1, num), bankAccount);
            } else {
                bankAccount.tell(new WithdrawMessage(i + 1, num), bankAccount);
            }
        }

        system.terminate();
    }
}
