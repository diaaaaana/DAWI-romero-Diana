package edu._3.dawl_romero_diana.response;


import edu._3.dawl_romero_diana.dto.CarDto;

import java.util.List;

public record findAllCarResponse(
        String code,
        String error,
        List<CarDto> cars
) {
}
