package kata5;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class kata5 {

    public static void main(String[] args) throws SQLException {
        FlightStore store = new SqliteFlightStore(new File("flights.db"));
        Map<Integer,Integer> histogram = new HashMap<>();
        for (Flight flight : store.flights()) {
            int arrivalDelay = (flight.getArrivalDelay() / 5) * 5;
            histogram.put(arrivalDelay, histogram.getOrDefault(arrivalDelay,0)+1);            
        }
        for (int delay : histogram.keySet())
            System.out.println(delay + ": " + histogram.get(delay));
    }
    
}
