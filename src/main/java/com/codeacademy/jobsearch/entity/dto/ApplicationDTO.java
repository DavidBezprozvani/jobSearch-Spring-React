package com.codeacademy.jobsearch.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {

    @Size(min = 2, max = 6)
    private String title;

    @Size(min = 1, max = 255)
    private String body;
}
