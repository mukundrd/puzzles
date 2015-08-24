
package com.puzzles.theatres;

import java.io.Serializable;
import java.util.Map;

public class Theatre implements Serializable {

    private static final long serialVersionUID = 4162109703358170821L;

    private long id;

    private String theatreName;

    private int pin;

    private String address;

    private long lattitude;

    private long longitude;

    private Map<String, int[]> timings;

    public Theatre(long id, String theatreName, int pin, String address, long lattitude, long longitude, Map<String, int[]> timings) {
        this.id = id;
        this.theatreName = theatreName;
        this.pin = pin;
        this.address = address;
        this.lattitude = lattitude;
        this.longitude = longitude;
        this.timings = timings;
    }

    public long getId() {
        return id;
    }

    public String getTheatreName() {
        return theatreName;
    }

    public int getPin() {
        return pin;
    }

    public String getAddress() {
        return address;
    }

    public long getLattitude() {
        return lattitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public int[] getTimings(String movieName) {
        return timings.get(movieName);
    }

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Theatre)) {
            return false;
        }

        return ((Theatre)another).id == this.id;
    }
}
