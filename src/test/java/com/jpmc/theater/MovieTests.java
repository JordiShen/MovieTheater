package com.jpmc.theater;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MovieTests {
    @Test
    void specialMovieWith20PercentDiscount() {                                                                       //UPDATES - change name to "20percent"; add aseertEquals function
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10, spiderMan.calculateTicketPrice(showing));                                      
    }

    @Test
    void specialMovieWith25PercentDiscount() {                                                                       //UPDATES - test 25percent test
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),16, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 15)));
        assertEquals(12, spiderMan.calculateTicketPrice(showing));                                      
    }


    @Test
    void seqenceMovieWith3DollarDiscount() {                                                                       //UPDATES - test &3 discount test
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(9.5, spiderMan.calculateTicketPrice(showing));                                      
    }
    

    @Test
    void seqenceMovieWith2DollarDiscount() {                                                                       //UPDATES - test $2 discount
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(10.5, spiderMan.calculateTicketPrice(showing));                                      
    }

    @Test
    void seqenceMovieWith1DollarsDiscount() {                                                                       //UPDATES - test $1 discount
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 7, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        assertEquals(11.5, spiderMan.calculateTicketPrice(showing));                                      
    }

    @Test
    void findMaxDiscount() {                                                                       //UPDATES - test max discount
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90),16, 1);
        Showing showing = new Showing(spiderMan, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 15)));
        assertEquals(12, spiderMan.calculateTicketPrice(showing));                                      
    }
}
