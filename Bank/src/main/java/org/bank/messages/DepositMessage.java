package org.bank.messages;

public class DepositMessage {
    public final int iteration;
    public final int amount;

    public DepositMessage(int iteration, int amount) {
        this.iteration = iteration;
        this.amount = amount;
    }
}
