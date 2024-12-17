package edu._3.dawl_romero_diana.response;


import edu._3.dawl_romero_diana.dto.CarDetailDto;

public record findCarDetailResponse(
        String code,
        String error,
        CarDetailDto car
) {
}
