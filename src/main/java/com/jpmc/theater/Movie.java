package com.jpmc.theater;

import java.time.Duration;
import java.util.Objects;

public class Movie {
    private static final int MOVIE_CODE_SPECIAL = 1;                //UPDATES - add "final" the spcial movie shouldn't be changed.

    private String title;
    private String description;
    private Duration runningTime;
    private double ticketPrice;
    private int specialCode;

    public Movie(String title, Duration runningTime, double ticketPrice, int specialCode) {
        this.title = title;
        this.runningTime = runningTime;
        this.ticketPrice = ticketPrice;
        this.specialCode = specialCode;
    }
    
    public String getTitle() {
        return title;
    }

    public Duration getRunningTime() {
        return runningTime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public double calculateTicketPrice(Showing showing) {
        return this.ticketPrice - getDiscount(showing.getSequenceOfTheDay(), showing.getStartTime().getHour(),  showing.getStartTime().getHour() + (int)runningTime.toHours());     // UPDATES -  add running time discount
    }

    private double getDiscount(int showSequence, int startTime, int endTime) {
        double specialDiscount = 0;                          
        if (MOVIE_CODE_SPECIAL == this.specialCode) {                                  
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie       
        }

        double runningTimeDiscount = 0;
        if(startTime >= 11 && endTime <= 16){
            runningTimeDiscount = ticketPrice * 0.25;              // UPDATES -  add running time discount
        }

        double sequenceDiscount = 0;
        if (showSequence == 1) {
            sequenceDiscount = 3; // $3 discount for 1st show
        } else if (showSequence == 2) {
            sequenceDiscount = 2; // $2 discount for 2nd show   
        } else if (showSequence == 7){                             // UPDATES -  add "7th day" discount
            sequenceDiscount = 1;
        }
//        else {
//            throw new IllegalArgumentException("failed exception");
//        }
        
        // biggest discount wins
        double discount = specialDiscount > sequenceDiscount ? specialDiscount : sequenceDiscount;  // UPDATES - return the max discount
        return discount > runningTimeDiscount ? discount : runningTimeDiscount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false; 
        if (this.getClass() != o.getClass()) return false;        
        Movie movie = (Movie) o;
        return Objects.equals(movie.ticketPrice, ticketPrice)     //UPDATES - update "double.compare" to "Objects.equals" for better reading 
                && Objects.equals(title, movie.title)
                && Objects.equals(description, movie.description)
                && Objects.equals(runningTime, movie.runningTime)
                && Objects.equals(specialCode, movie.specialCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, runningTime, ticketPrice, specialCode);
    }
}