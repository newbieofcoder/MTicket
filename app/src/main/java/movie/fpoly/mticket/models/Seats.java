package movie.fpoly.mticket.models;

import java.io.Serializable;

public class Seats implements Serializable {
    private int seat_id;
    private int seat_type;
    private int room_id;
    private String row_seat;
    private int number;

    public Seats(int seat_id, int seat_type, int room_id, String row_seat, int number) {
        this.seat_id = seat_id;
        this.seat_type = seat_type;
        this.room_id = room_id;
        this.row_seat = row_seat;
        this.number = number;
    }

    public Seats() {
    }

    public int getSeat_id() {
        return seat_id;
    }

    public void setSeat_id(int seat_id) {
        this.seat_id = seat_id;
    }

    public int getSeat_type() {
        return seat_type;
    }

    public void setSeat_type(int seat_type) {
        this.seat_type = seat_type;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getRow_seat() {
        return row_seat;
    }

    public void setRow_seat(String row_seat) {
        this.row_seat = row_seat;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
