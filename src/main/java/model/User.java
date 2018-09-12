package model;

public class User {

    private int id;
    private String name;
    private String phone;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
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
     * Returns name.
     *
     * @return value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name value.
     *
     * @param name - value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns phone.
     *
     * @return value of phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets phone value.
     *
     * @param phone - value to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
