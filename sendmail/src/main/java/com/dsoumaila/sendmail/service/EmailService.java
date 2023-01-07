package com.dsoumaila.sendmail.service;

import java.util.Map;

public interface EmailService {
    /**
     * Send a mail
     * @param to destination
     * @param subject subject
     * @param messages the content of mail
     */
    void sendMessage(String to, String subject, Map<String, String> messages);
}
