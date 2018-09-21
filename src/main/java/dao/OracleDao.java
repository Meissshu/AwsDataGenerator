package dao;

import model.Booking;
import model.Room;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class OracleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void batchUser(List<User> users, int batchSize) {
        final String INSERT_QUERY = "INSERT INTO ADMIN.USERS (ID, USERNAME, PHONE) VALUES (?, ?, ?)";

        for (int i = 0; i < users.size(); i += batchSize) {
            final List<User> batchSubList = users.subList(i, i + batchSize > users.size() ? users.size() : i + batchSize);

            jdbcTemplate.batchUpdate(INSERT_QUERY,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            User user = batchSubList.get(i);
                            ps.setInt(1, user.getId());
                            ps.setString(2, user.getName());
                            ps.setString(3, user.getPhone());
                        }

                        @Override
                        public int getBatchSize() {
                            return batchSubList.size();
                        }
                    });
            if (i % 10_000 == 0) {
                System.out.println("User progress: " + i + "/500000");
            }
        }
    }

    public void batchRooms(List<Room> rooms, int batchSize) {
        final String INSERT_QUERY = "INSERT INTO ADMIN.HOTEL_ROOMS (ROOM_ID, ROOM_TYPE) VALUES (?, ?)";

        for (int i = 0; i < rooms.size(); i += batchSize) {
            final List<Room> batchSubList = rooms.subList(i, i + batchSize > rooms.size() ? rooms.size() : i + batchSize);

            jdbcTemplate.batchUpdate(INSERT_QUERY,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            Room room = batchSubList.get(i);
                            ps.setInt(1, room.getId());
                            ps.setString(2, room.getType());
                        }

                        @Override
                        public int getBatchSize() {
                            return batchSubList.size();
                        }
                    });

            if (i % 5000 == 0) {
                System.out.println("Rooms progress: " + i + "/250000");
            }
        }
    }

    public void batchBookings(List<Booking> bookings, int batchSize) {
        final String INSERT_QUERY = "INSERT INTO ADMIN.BOOKINGS (BOOKING_ID, USER_ID, ROOM_ID, \"from\", \"to\") VALUES (?, ?, ?, ?, ?)";

        for (int i = 0; i < bookings.size(); i += batchSize) {
            final List<Booking> batchSubList = bookings.subList(i, i + batchSize > bookings.size() ? bookings.size() : i + batchSize);

            jdbcTemplate.batchUpdate(INSERT_QUERY,
                    new BatchPreparedStatementSetter() {
                        @Override
                        public void setValues(PreparedStatement ps, int i) throws SQLException {
                            Booking booking = batchSubList.get(i);
                            ps.setInt(1, booking.getId());
                            ps.setInt(2, booking.getUser_id());
                            ps.setInt(3, booking.getRoom_id());
                            ps.setDate(4, booking.getFrom());
                            ps.setDate(5, booking.getTo());
                        }

                        @Override
                        public int getBatchSize() {
                            return batchSubList.size();
                        }
                    });

            if (i % 20_000 == 0) {
                System.out.println("Booking progress: " + i + "/1000000");
            }

        }
    }

}
