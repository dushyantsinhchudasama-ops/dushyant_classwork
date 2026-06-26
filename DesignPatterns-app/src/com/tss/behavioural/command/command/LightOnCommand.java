package com.tss.behavioural.command.command;

import com.tss.behavioural.command.model.ICOmmand;
import com.tss.behavioural.command.model.Light;

public class LightOnCommand implements ICOmmand {

    private Light light;

    public LightOnCommand(Light light)
    {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}
