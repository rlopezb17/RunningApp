package com.runningback.controller;

import com.runningback.dto.ApiResponse;
import com.runningback.dto.ShoesDto;
import com.runningback.entity.Shoes;
import com.runningback.mapper.ShoesMapper;
import com.runningback.service.IShoesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoes")
public class ShoesController {

    private final IShoesService shoesService;

    public ShoesController(IShoesService shoesService) {
        this.shoesService = shoesService;
    }

    @PostMapping("/addShoes")
    ResponseEntity<ApiResponse> addShoes(@RequestBody ShoesDto shoesDto) {
        Shoes newShoes = ShoesMapper.toShoesEntity(shoesDto);
        shoesService.addShoes(newShoes);
        return ResponseEntity.ok(new ApiResponse(true, "Shoes registered successfully", null));
    }

    @GetMapping("/shoes")
    ResponseEntity<List<ShoesDto>> getShoes() {
        List<Shoes> shoes = shoesService.getShoes();
        List<ShoesDto> shoesDto = shoes.stream()
                .map(ShoesMapper::toShoesDto)
                .toList();
        return ResponseEntity.ok(shoesDto);
    }
}
