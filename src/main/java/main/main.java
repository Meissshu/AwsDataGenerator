package main;

import dao.OracleDao;
import model.Booking;
import model.Room;
import model.User;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.ajbrown.namemachine.NameGeneratorOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan(basePackages = {"dao"})
public class main implements CommandLineRunner {

    private static final int USERS_SIZE = 500_000;
    private static final int ROOMS_SIZE = 250_000;
    private static final int BOOKINGS_SIZE = 1_000_000;
    private static final long THREE_DAYS = TimeUnit.DAYS.toMillis(3);
    private static final Random random = new Random();
    private static final String[] types = {"One room", "Two rooms", "Three rooms", "Lux"};

    @Autowired
    OracleDao dao;

    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }

    private static List<Booking> generateBookings(List<User> users, List<Room> rooms) {
        List<Booking> result = new ArrayList<>(BOOKINGS_SIZE);

        for (int i = 0; i < BOOKINGS_SIZE; ++i) {
            Booking booking = new Booking();
            booking.setId(i + 1);
            booking.setUser_id(users.get(random.nextInt(USERS_SIZE)).getId());
            booking.setRoom_id(rooms.get(random.nextInt(ROOMS_SIZE)).getId());
            booking.setFrom(new Date(System.currentTimeMillis() - (long) (Math.random() * THREE_DAYS)));
            booking.setTo(new Date(System.currentTimeMillis() + (long) (Math.random() * THREE_DAYS)));
            result.add(booking);
        }

        return result;
    }

    private static List<User> generateUsers() {
        List<User> result = new ArrayList<>(USERS_SIZE);

        NameGeneratorOptions options = new NameGeneratorOptions();
        options.setGenderWeight(50);
        NameGenerator generator = new NameGenerator(options);
        List<Name> names = generator.generateNames(USERS_SIZE);

        for (int i = 0; i < USERS_SIZE; ++i) {
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
        List<Room> result = new ArrayList<>(ROOMS_SIZE);

        for (int i = 0; i < ROOMS_SIZE; ++i) {
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

    @Override
    public void run(String... args) throws Exception {
        List<Room> rooms = generateRooms();
        List<User> users = generateUsers();
        List<Booking> bookings = generateBookings(users, rooms);

        Thread thread = new Thread(() -> dao.batchRooms(rooms, 2500));
        thread.start();
        Thread thread1 = new Thread(() -> dao.batchUser(users, 5000));
        thread1.start();
        Thread thread2 = new Thread(() -> dao.batchBookings(bookings, 10000));
        thread2.start();
        thread.join();
        thread1.join();
        thread2.join();

        System.out.println("DONE");
    }
}
