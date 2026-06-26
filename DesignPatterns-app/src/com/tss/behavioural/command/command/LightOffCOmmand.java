package com.tss.behavioural.command.command;

import com.tss.behavioural.command.model.ICOmmand;
import com.tss.behavioural.command.model.Light;

public class LightOffCOmmand implements ICOmmand{

    private Light light;

    public LightOffCOmmand(Light light) {
        this.light = light;
    }

    @Override
    public void execute()
    {
        light.turnOff();

    }
}
