package com.topinformation.MealsAPI.service;

import com.topinformation.MealsAPI.dto.request.MealDTO;
import com.topinformation.MealsAPI.dto.response.MessageResponseDTO;
import com.topinformation.MealsAPI.entity.Meal;
import com.topinformation.MealsAPI.exception.MealNotFoundException;
import com.topinformation.MealsAPI.exception.MealsListNotFoundException;
import com.topinformation.MealsAPI.repository.MealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    private MealsRepository mealsRepository;

    @Autowired
    public MealService(MealsRepository mealsRepository) {

        this.mealsRepository = mealsRepository;
    }


    public MessageResponseDTO createdMeal(MealDTO mealDTO){
        Meal meal = dtoToMeal(mealDTO);
        Meal savedMeal = mealsRepository.save(meal);
        return createMessageResponse(savedMeal.getId(), "Created meal with Id ");
    }

    public List<Meal> listAll() throws MealsListNotFoundException {

        List<Meal> meals =  mealsRepository.findAll();

        if (meals.isEmpty()){
            throw new MealsListNotFoundException();
        }

        return meals;
    }

    public MealDTO findById(Long id) throws MealNotFoundException {
        Meal meal = VerifyIfExists(id);
        return mealToDto(meal);
    }

    public MessageResponseDTO updateById(Long id, MealDTO mealDTO) throws MealNotFoundException {
        VerifyIfExists(id);
        Meal convertedMeal = dtoToMeal(mealDTO);
        Meal updatedMeal = mealsRepository.save(convertedMeal);

        return createMessageResponse(updatedMeal.getId(), "Updated meal with Id");
    }

    public void deleteById(Long id) throws MealNotFoundException {
        VerifyIfExists(id);
        mealsRepository.deleteById(id);
    }

    //Converts an object of type mealDTO to Meal
    private Meal dtoToMeal(MealDTO mealDTO){
        Meal meal = Meal.builder()
                .image(mealDTO.getImage())
                .name(mealDTO.getName())
                .category(mealDTO.getCategory())
                .area(mealDTO.getArea())
                .instructions(mealDTO.getInstructions())
                .build();

        return meal;
    }

    //Converts an object of type Meal to MealDTO
    private MealDTO mealToDto(Meal meal){
        MealDTO mealDTO = MealDTO.builder()
                .image(meal.getImage())
                .name(meal.getName())
                .category(meal.getCategory())
                .area(meal.getArea())
                .instructions(meal.getInstructions())
                .build();
        return mealDTO;
    }

    //Response to requests
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO.builder()
                .message(message + id)
                .build();
    }

    //checks if there is an element with the id received,
    //or throws an exception
    private Meal VerifyIfExists(Long id) throws MealNotFoundException {
        return mealsRepository.findById(id)
                .orElseThrow(() -> new MealNotFoundException(id));
    }

}
