package model;


import java.sql.Date;

public class Booking {

    private int id;
    private int user_id;
    private int room_id;
    private Date from;
    private Date to;


    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", room_id=" + room_id +
                ", from=" + from +
                ", to=" + to +
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
     * Returns from.
     *
     * @return value of from
     */
    public Date getFrom() {
        return from;
    }

    /**
     * Sets from value.
     *
     * @param from - value to set
     */
    public void setFrom(Date from) {
        this.from = from;
    }

    /**
     * Returns to.
     *
     * @return value of to
     */
    public Date getTo() {
        return to;
    }

    /**
     * Sets to value.
     *
     * @param to - value to set
     */
    public void setTo(Date to) {
        this.to = to;
    }
}
