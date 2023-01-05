package org.bank;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import org.bank.messages.DepositMessage;
import org.bank.messages.WithdrawMessage;

public class BankAccount extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private int balance;

    public BankAccount() {
        this.balance = 100;
        System.out.println("Bank account initialised with £100");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(DepositMessage.class, this::onDeposit)
                .match(WithdrawMessage.class, this::onWithdraw)
                .build();
    }

    public void onDeposit(DepositMessage msg) {
        log.info("Handling deposit message: " + msg.iteration);
        System.out.printf("Depositing: £%d%n", msg.amount);
        this.balance += msg.amount;
        System.out.printf("New balance: £%d%n", this.balance);
    }

    public void onWithdraw(WithdrawMessage msg) {
        log.info("Handling withdraw message: " + msg.iteration);
        System.out.printf("Withdrawing: £%d%n", msg.amount);
        this.balance += msg.amount;
        System.out.printf("New balance: £%d%n", this.balance);
    }
}
