package com.tss.behavioural.command.invoker;

import com.tss.behavioural.command.model.ICOmmand;

public class RemoteControl {

    private ICOmmand command;

    public void setCommand(ICOmmand command) {
        this.command = command;
    }

    public void pressButton()
    {
        command.execute();
    }
}
