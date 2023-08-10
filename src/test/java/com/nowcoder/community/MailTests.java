package com.nowcoder.community;

import com.nowcoder.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
@ContextConfiguration(classes = SpringProjectApplication.class)
public class MailTests {
    @Autowired
    public MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testHtmlMail(){
        Context context = new Context();
        context.setVariable("username","sunday");

        String process = templateEngine.process("/mail/demo", context);
        mailClient.sendMail("894107162@qq.com","TEST","verify code: 123456");
        System.out.println(process);
    }
    @Test
    public void testMailClient(){
        mailClient.sendMail("hugodufour@sina.com","TEST","verify code: 123456");
    }


}
