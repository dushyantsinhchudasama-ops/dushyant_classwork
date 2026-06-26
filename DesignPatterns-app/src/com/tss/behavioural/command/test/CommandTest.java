package com.tss.behavioural.command.test;

import com.tss.behavioural.command.command.FanOffCommand;
import com.tss.behavioural.command.command.FanOnCommand;
import com.tss.behavioural.command.command.LightOffCOmmand;
import com.tss.behavioural.command.command.LightOnCommand;
import com.tss.behavioural.command.invoker.RemoteControl;
import com.tss.behavioural.command.model.Fan;
import com.tss.behavioural.command.model.ICOmmand;
import com.tss.behavioural.command.model.Light;

public class CommandTest {
    public static void main(String[] args) {

        Light light = new Light();
        Fan fan = new Fan();

        ICOmmand lightOn = new LightOnCommand(light);

        ICOmmand lightOff = new LightOffCOmmand(light);

        ICOmmand fanOn = new FanOnCommand(fan);

        ICOmmand fanOff = new FanOffCommand(fan);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();

        remote.setCommand(fanOn);
        remote.pressButton();

        remote.setCommand(fanOff);
        remote.pressButton();
    }
}
