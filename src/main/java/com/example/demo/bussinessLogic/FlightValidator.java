package com.example.demo.bussinessLogic;
import java.util.List;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class FlightValidator {
    private static final List<String> ALLOWED_FLIGHTS = Arrays.asList("bucuresti", "cluj", "timisoara",
            "arad",
            "sibiu",
            "oradea",
            "debretin",
            "budapesta",
            "viena",
            "salzburg",
            "linz",
            "berlin",
            "munich",
            "graz",
            "milano",
            "roma",
            "torino",
            "palermo",
            "bergamo",
            "paris",
            "lion",
            "madrid",
            "copenhaga",
            "lisabona",
            "valencia");

    /** check the correctness of the input data for creating a flight  */
    public boolean validateFligh(String ziua,String from,String to)
    {
        Pattern pattern = Pattern.compile("\\d{2}-\\d{2}-\\d{2}");
        if(!pattern.matcher(ziua).matches())
           return false;
        if(Objects.equals(from, to))
            return false;
        return ALLOWED_FLIGHTS.contains(from) && ALLOWED_FLIGHTS.contains(to);
    }

}
