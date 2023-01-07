package com.dsoumaila.sendmail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ResourceLoader;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);
    private final JavaMailSender emailSender;
    private final TemplateEngine templateEngine;

    private final ResourceLoader resourceLoader;

    public EmailServiceImpl(JavaMailSender emailSender, TemplateEngine templateEngine, ResourceLoader resourceLoader) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
        this.resourceLoader = resourceLoader;
    }

    /**
     * Send a simple mail
     *
     * @param to          destination
     * @param subject     subject
     * @param messages    the content of mail
     */
    @Override
    public void sendMessage(String to, String subject, Map<String, String> messages) {
        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            messageHelper.setFrom("diakitesoumaila182@gmail.com");
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);

            // Adding image to mail content ;
            messageHelper.addInline("image_1", resourceLoader.getResource("classpath:templates/images/image-1.png").getFile());
            messageHelper.addInline("image_2", resourceLoader.getResource("classpath:templates/images/image-2.png").getFile());
            messageHelper.addInline("image_3", resourceLoader.getResource("classpath:templates/images/image-3.png").getFile());
            messageHelper.addInline("image_4", resourceLoader.getResource("classpath:templates/images/image-4.png").getFile());
            messageHelper.addInline("image_5", resourceLoader.getResource("classpath:templates/images/image-5.png").getFile());
            messageHelper.addInline("image_6", resourceLoader.getResource("classpath:templates/images/image-6.png").getFile());

            Context context = new Context();
            context.setVariable("mailContent", messages.get("mailContent"));
            context.setVariable("userName", messages.get("userName"));
            String content = templateEngine.process("userSubscribe", context);
            messageHelper.setText(content, true);
        };

        try {
            emailSender.send(messagePreparator);
        } catch (MailException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
