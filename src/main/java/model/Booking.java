package model;

import java.util.Date;

public class Booking {

    private int id;
    private int user_id;
    private int room_id;
    private Date date;
    private int durationInDays;

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", date=" + date +
                ", durationInDays=" + durationInDays +
                '}';
    }

    /**
     * Returns id.
     *
     * @return value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id value.
     *
     * @param id - value to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns user_id.
     *
     * @return value of user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * Sets user_id value.
     *
     * @param user_id - value to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Returns room_id.
     *
     * @return value of room_id
     */
    public int getRoom_id() {
        return room_id;
    }

    /**
     * Sets room_id value.
     *
     * @param room_id - value to set
     */
    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    /**
     * Returns date.
     *
     * @return value of date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date value.
     *
     * @param date - value to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Returns durationInDays.
     *
     * @return value of durationInDays
     */
    public int getDurationInDays() {
        return durationInDays;
    }

    /**
     * Sets durationInDays value.
     *
     * @param durationInDays - value to set
     */
    public void setDurationInDays(int durationInDays) {
        this.durationInDays = durationInDays;
    }
}
