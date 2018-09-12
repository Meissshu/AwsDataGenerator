import model.Booking;
import model.Room;
import model.User;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.ajbrown.namemachine.NameGeneratorOptions;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class main {

    private static final int SIZE = 10_000;
    private static final Random random = new Random();
    private static final String[] types = {"One room", "Two rooms", "Three rooms", "Lux"};

    public static void main(String[] args) {
        List<Room> rooms = generateRooms();
        List<User> users = generateUsers();
        List<Booking> bookings = generateBookings(users, rooms);
    }

    private static List<Booking> generateBookings(List<User> users, List<Room> rooms) {
        List<Booking> result = new ArrayList<>();

        for (int i = 0; i < SIZE; ++i) {
            Booking booking = new Booking();
            booking.setId(i + 1);
            booking.setUser_id(users.get(random.nextInt(SIZE)).getId());
            booking.setRoom_id(rooms.get(random.nextInt(SIZE)).getId());
            booking.setDate(new Date(System.currentTimeMillis() - random.nextInt(10000000)));
            booking.setDurationInDays(random.nextInt(7) + 1);
            result.add(booking);
        }

        return result;
    }

    private static List<User> generateUsers() {
        List<User> result = new ArrayList<>(SIZE);

        NameGeneratorOptions options = new NameGeneratorOptions();
        options.setGenderWeight(50);
        NameGenerator generator = new NameGenerator(options);
        List<Name> names = generator.generateNames(SIZE);

        for (int i = 0; i < SIZE; ++i) {
           User user = new User();
           user.setId(i + 1);
           user.setName(names.get(i).toString());
           user.setPhone(generateRandomPhoneNumber());
           result.add(user);
        }

        return result;
    }

    private static String generateRandomPhoneNumber() {
        int prefix = random.nextInt(7) + 1;
        int num1 = random.nextInt(900) + 100;
        int num2 = random.nextInt(900) + 100;
        int num3 = random.nextInt(8999) + 1000;

        return "+" + prefix + "(" + num1 + ")" + "-" + num2 + "-" + num3;
    }

    private static List<Room> generateRooms() {
        List<Room> result = new ArrayList<>(SIZE);

        for (int i = 0; i < SIZE; ++i) {
            Room room = new Room();
            room.setId(i + 1);
            room.setType(generateRoomType());
            result.add(room);
        }

        return result;
    }

    private static String generateRoomType() {
        return types[random.nextInt(types.length)];
    }
}
