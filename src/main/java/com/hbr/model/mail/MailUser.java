package com.hbr.model.mail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@PropertySource("classpath:application.properties")
@Component
public class MailUser {
    private String[] toUser;
    private String subject;
    private String content;
    @Value("${spring.mail.username}")
    private String fromAdmin;
    private String personal;

}
