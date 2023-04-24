package com.example.demo.api;

import com.example.demo.api.dto.HeroRequestDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface HeroControllerSwagger {

    @ApiOperation(value="Get a list of heroes",
                  httpMethod = "GET")
    public Set<HeroRequestDTO> getHeroes();

    @ApiOperation(value="Add a hero",
                  notes="Validate the attributes \n" +
                        "Check if the hero exists",
                  httpMethod = "POST")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "Ok"),
            @ApiResponse(code=102,message = "Enter a name"),
            @ApiResponse(code=102,message = "The name cannot have numbers"),
            @ApiResponse(code=102, message = "Enter a universe"),
            @ApiResponse(code=500, message = "System internal error")

    })
    ResponseEntity<HeroRequestDTO> addHero(HeroRequestDTO hero);

    @ApiOperation(value="Delete a hero",
            notes="Validate the attributes \n" +
                    "Check if the hero exists",
            httpMethod = "DELETE")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "Ok"),
            @ApiResponse(code=500, message = "The hero does not exist")
    })
    void deleteHero(Long id);

    @ApiOperation(value="Update a hero",
            notes="Validate the attributes \n" +
                    "Check if the hero exists",
            httpMethod = "PUT")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "Ok"),
            @ApiResponse(code=102,message = "Enter a name"),
            @ApiResponse(code=102,message = "The name cannot have numbers"),
            @ApiResponse(code=102, message = "Enter a universe"),
            @ApiResponse(code=500, message = "The hero does not exist")
    })
    ResponseEntity<HeroRequestDTO> updateHero(Long id, HeroRequestDTO hero);
}
