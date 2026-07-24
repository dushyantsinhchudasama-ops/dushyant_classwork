package com.tss.ioc.controller;

import com.tss.ioc.entity.Computer;
import com.tss.ioc.entity.Harddisk;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class ComputerController {

    private Computer computer;
    private Harddisk harddisk;

    public ComputerController(Computer computer, Harddisk harddisk) {
        this.computer = computer;
        this.harddisk = harddisk;
    }

    @GetMapping("/computers")
    public Computer getComputer()
    {
        return computer;
    }

    @GetMapping("/harddisks")
    public Harddisk harddisk()
    {
        return harddisk;
    }
}
