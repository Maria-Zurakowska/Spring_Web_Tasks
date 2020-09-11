package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AdminConfig {
    @Value("${admin.mail}")
    private String adminMail;

    @Value("Kodilla User")
    private String adminName;

    @Value("ABC Sp. z o.o., ul. Marszałkowska 123, 01-000 Warszawa")
    private String companyDetails;

}
