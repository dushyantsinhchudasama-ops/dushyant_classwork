package com.tss.behavioural.command.command;

import com.tss.behavioural.command.model.Fan;
import com.tss.behavioural.command.model.ICOmmand;

public class FanOnCommand implements ICOmmand {

    private Fan fan;

    public FanOnCommand(Fan fan)
    {
        this.fan = fan;
    }

    @Override
    public void execute()
    {
        fan.turnOn();
    }
}
