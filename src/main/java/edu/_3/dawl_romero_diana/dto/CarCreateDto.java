package edu._3.dawl_romero_diana.dto;

public record CarCreateDto(
        Integer carId,
         String make,
         String model,
         int year,
         String vin,
         String licensePlate,
         String ownerName,
         String ownerContact,
         int mileage,
         String engineType,
         String color,
         String insuranceCompany
) {
}
