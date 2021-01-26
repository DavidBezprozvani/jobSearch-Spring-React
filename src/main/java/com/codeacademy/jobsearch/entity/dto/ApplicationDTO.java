package com.codeacademy.jobsearch.entity.dto;

import javax.validation.constraints.Size;

public class ApplicationDTO {

    @Size(min = 2, max = 6)
    private String title;

    @Size(min = 1, max = 255)
    private String body;
}
