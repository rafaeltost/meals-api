package com.topinformation.MealsAPI.service;

import com.topinformation.MealsAPI.dto.request.MealDTO;
import com.topinformation.MealsAPI.dto.response.MessageResponseDTO;
import com.topinformation.MealsAPI.entity.Meal;
import com.topinformation.MealsAPI.repository.MealsRepository;
import com.topinformation.MealsAPI.utils.MealUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MealServiceTest {

    @Mock
    private MealsRepository mealsRepository;

    @InjectMocks
    private MealService mealService;

    @Test
    void testGivenMealDtoReturnSaveMessage(){
        MealDTO mealDTO = MealUtils.createFakeDTO();
        Meal expectedSavedMeal = MealUtils.createFakeEntity();

        Mockito.when(mealsRepository.save(any(Meal.class))).thenReturn(expectedSavedMeal);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedMeal.getId());

        MessageResponseDTO message = mealService.createdMeal(mealDTO);

        Assertions.assertEquals(expectedSuccessMessage, message);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created meal with Id " + id)
                .build();
    }

}
