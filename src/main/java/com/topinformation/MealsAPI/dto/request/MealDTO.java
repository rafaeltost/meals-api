package com.topinformation.MealsAPI.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MealDTO {
    //used for http request validation at controller layer with Bean Validation library

    private Long id;

    @NotEmpty
    private String image;

    @NotEmpty
    private String name;

    @NotEmpty
    private String category;

    @NotEmpty
    private String area;

    @NotEmpty
    private String instructions;
}
