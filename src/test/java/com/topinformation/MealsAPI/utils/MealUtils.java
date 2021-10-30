package com.topinformation.MealsAPI.utils;

import com.topinformation.MealsAPI.dto.request.MealDTO;
import com.topinformation.MealsAPI.entity.Meal;

public class MealUtils {
    private static final Long ID = Long.valueOf(1);
    private static final String IMAGE = "http://image.com";
    private static final String NAME = "Meal";
    private static final String CATEGORY = "Category";
    private static final String AREA = "Area";
    private static final String INSTRUCTIONS = "Instructions";

    public static Meal createFakeEntity() {
        return  Meal.builder()
                .id(ID)
                .image(IMAGE)
                .name(NAME)
                .category(CATEGORY)
                .area(AREA)
                .instructions(INSTRUCTIONS)
                .build();

    }

    public static MealDTO createFakeDTO() {
        return  MealDTO.builder()
                .id(ID)
                .image(IMAGE)
                .name(NAME)
                .category(CATEGORY)
                .area(AREA)
                .instructions(INSTRUCTIONS)
                .build();

    }


}
