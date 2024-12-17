package edu._3.dawl_romero_diana.dto;

import java.util.Date;

public record CarDetailDto(
        Integer carId,
        String make,
        String model,
        int year,
        String licensePlate,
        String ownerName,
        Date purchaseDate,
        String engineType,
        String color,
        String insuranceCompany,
        String insurancePolicyNumber,
        Date serviceDueDate
) {
}
