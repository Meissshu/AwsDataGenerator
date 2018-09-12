package model;

public class Room {

    private int id;
    private String type;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", type='" + type + '\'' +
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
     * Returns type.
     *
     * @return value of type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets type value.
     *
     * @param type - value to set
     */
    public void setType(String type) {
        this.type = type;
    }
}
