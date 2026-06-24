package com.tss.model;

import java.util.UUID;

public class ConfirmationGenerator {

    public String generateConfirmationNumber() {

        return "ENR-"
                + UUID.randomUUID()
                .toString()
                .substring(0, 8);
    }
}