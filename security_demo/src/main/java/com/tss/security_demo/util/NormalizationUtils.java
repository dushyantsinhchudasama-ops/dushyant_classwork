package com.tss.security_demo.util;

import java.util.Locale;

/**
 * Utility for central case-insensitive normalization of string identifiers
 * such as email addresses and tenant codes.
 */
public final class NormalizationUtils {

    private NormalizationUtils() {
        // Utility class
    }

    /**
     * Trims leading/trailing whitespace and converts to lowercase using Locale.ROOT.
     * Returns null if input is null.
     */
    public static String normalizeEmail(String email) {
        if (email == null) {
            return null;
        }
        return email.trim().toLowerCase(Locale.ROOT);
    }

}
