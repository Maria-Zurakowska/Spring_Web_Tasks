package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message){
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending tasks to Trello");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getCompanyDetails());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("application_functionality", functionality);
        context.setVariable("goodbye_message", "Hope to see you again!");
        context.setVariable("preview_message", "Welcome!");
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String buildDailyEmail(String message){
        List<String> dailyTasksList = new ArrayList<>();
        dailyTasksList.add("To do tasks");
        dailyTasksList.add("In progress tasks");
        dailyTasksList.add("Done tasks");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("company_details", adminConfig.getCompanyDetails());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("daily_TasksList", dailyTasksList);
        context.setVariable("goodbye_message", "Hope to see you again!");
        context.setVariable("preview_message", "Welcome!");
        return templateEngine.process("mail/created-trello-card-mail2", context);
    }
}
