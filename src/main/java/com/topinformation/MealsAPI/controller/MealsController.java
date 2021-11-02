package com.topinformation.MealsAPI.controller;

import com.topinformation.MealsAPI.dto.request.MealDTO;
import com.topinformation.MealsAPI.dto.response.MessageResponseDTO;
import com.topinformation.MealsAPI.entity.Meal;
import com.topinformation.MealsAPI.exception.MealNotFoundException;
import com.topinformation.MealsAPI.exception.MealsListNotFoundException;
import com.topinformation.MealsAPI.service.MealService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/meals")
@Api(value = "Meals API")
@CrossOrigin("*")
public class MealsController {
    private MealService mealService;

    @Autowired
    public MealsController(MealService mealsService) {
        this.mealService = mealsService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create a new meal")
    public MessageResponseDTO createdMeal(@RequestBody @Valid MealDTO mealDTO){
        return mealService.createdMeal(mealDTO);
    }

    @GetMapping
    @ApiOperation(value = "Get a list of registered meals")
    public List<Meal> listAll() throws MealsListNotFoundException {
        return mealService.listAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get a single meal with id")
    public MealDTO findById(@PathVariable Long id) throws MealNotFoundException {
        return mealService.findById(id);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Change a meal's data")
    public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid MealDTO  mealDTO) throws MealNotFoundException {
        return mealService.updateById(id, mealDTO);
    }

    @DeleteMapping ("/{id}")
    @ApiOperation(value = "Delete a meal")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws MealNotFoundException {
        mealService.deleteById(id);
    }
}
