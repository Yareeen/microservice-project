package com.example.kafkaproduce.Config;

import com.example.kafkaproduce.Model.Location;

import java.util.Random;

import java.util.Random;

public class LocationGenerator {
    private static final double MIN_LATITUDE = 36.0;
    private static final double MAX_LATITUDE = 42.0;
    private static final double MIN_LONGITUDE = 26.0;
    private static final double MAX_LONGITUDE = 44.0;
    private static final Random random = new Random();

    public static Location generateRandomLocation() {
        double lat = MIN_LATITUDE + (MAX_LATITUDE - MIN_LATITUDE) * random.nextDouble();
        double lng = MIN_LONGITUDE + (MAX_LONGITUDE - MIN_LONGITUDE) * random.nextDouble();

        // Ensure that the generated longitude stays within the range [-180, 180]
        lng = ((lng + 180) % 360 + 360) % 360 - 180;

        return new Location(lat, lng);
    }
}
