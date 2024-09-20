package com.runningback.mapper;

import com.runningback.dto.ActivityDto;
import com.runningback.dto.ShoesDto;
import com.runningback.dto.UserDto;
import com.runningback.entity.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setBirthDate(user.getBirthDate());
        dto.setWeight(user.getWeight());
        dto.setHeight(user.getHeight());

        if (user.getCountry() != null) {
            dto.setCountry(CountryMapper.toCountryDto(user.getCountry()));
        }

        List<ActivityDto> activities = user.getActivities().stream()
                .map(ActivityMapper::toActivityDto)
                .collect(Collectors.toList());
        dto.setActivities(activities);

        List<ShoesDto> shoes = user.getShoes().stream()
                .map(ShoesMapper::toShoesDto)
                .collect(Collectors.toList());
        dto.setShoes(shoes);

        return dto;
    }

    public static User toUserEntity(UserDto dto) {
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setBirthDate(dto.getBirthDate());
        user.setWeight(dto.getWeight());
        user.setHeight(dto.getHeight());

        if (dto.getCountry() != null) {
            user.setCountry(CountryMapper.toCountryEntity(dto.getCountry()));
        }

        return user;
    }

}
