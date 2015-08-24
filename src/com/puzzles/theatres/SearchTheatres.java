
package com.puzzles.theatres;

import java.util.List;

public interface SearchTheatres {

    List<Theatre> findTheatresByMovieAndLocation(String movieName, int pincode);
    
    List<Theatre> findTheatresByPincode(int pincode);

    List<Theatre> findTheatresByGeo(long lattitude, long longitude);

}
