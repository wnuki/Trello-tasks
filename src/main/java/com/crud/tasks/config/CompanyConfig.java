package com.crud.tasks.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class CompanyConfig {

    @Value("${info.app.owner.name}")
    private String ownerName;

    @Value("${info.app.owner.surname}")
    private String ownerSurname;

    @Value("${info.company.name}")
    private String company_name;

    @Value("${info.company.goal}")
    private String company_goal;

    @Value("${info.company.email}")
    private String company_email;

    @Value("${info.company.phone}")
    private String company_phone;
}
