package com.mycompany.LoginandSignUp;



import java.util.Scanner;
class User {
    private final String username;
    private final String password;
    private final String phoneNumber;
    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
}
class UserRepository {
    private final User[] users;
    private int userCount;
    public UserRepository(int capacity) {
        users = new User[capacity];
        userCount = 0;
    }
    public void registerUser(String username, String password, String phoneNumber) {
        if (userCount < users.length) {
            if (isValidPhoneNumber(phoneNumber)
                    && validateUsername(username).equals("Username successfully captured")
                    && validatePassword(password).equals("Password successfully captured")) {
                users[userCount] = new User(username, password, phoneNumber);
                userCount++;
                System.out.println("User registered successfully!");
            } else {
                System.out.println(validateUsername(username));
                System.out.println(validatePassword(password));
            }
        } else {
            System.out.println("User repository is full!");
        }
    }
    public boolean loginUser(String username, String password) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUsername().equals(username) && users[i].getPassword().equals(password)) {
                System.out.println("Login successful!");
                return true;
            }
        }
        System.out.println("Invalid username or password!");
        return false;
    }
    private boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.startsWith("0")) {
            if (phoneNumber.startsWith("06") || phoneNumber.startsWith("07")
                    || phoneNumber.startsWith("08") || phoneNumber.startsWith("09")) {
                return true;
            }
        }
        if (phoneNumber.length() == 13 && phoneNumber.startsWith("+27")) {
            if (phoneNumber.startsWith("+276") || phoneNumber.startsWith("+277")
                    || phoneNumber.startsWith("+278") || phoneNumber.startsWith("+279")) {
                return true;
            }
        }
        return false;
    }
    public static String validateUsername(String username) {
        if (username.contains("_") && username.length() <= 5) {
            return "Username successfully captured";
        } else {
            return "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length";
        }
    }
    public static String validatePassword(String password) {
        if (password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^A-Za-z0-9].*")) {
            return "Password successfully captured";
        } else {
            return "Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number and a special character";
        }
    }
}
public class LoginandSignUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserRepository userRepository = new UserRepository(10);
        while (true) {
            System.out.println("\n--- Welcome to MyChatApp ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.print("Enter username: ");
                        String username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        String password = scanner.nextLine();
                        System.out.print("Enter South African cell phone number (e.g. 0712345678 or +27712345678): ");
                        String phoneNumber = scanner.nextLine();
                        userRepository.registerUser(username, password, phoneNumber);
                        break;
                    case 2:
                        System.out.print("Enter username: ");
                        username = scanner.nextLine();
                        System.out.print("Enter password: ");
                        password = scanner.nextLine();
                        userRepository.loginUser(username, password);
                        break;
                    case 3:
                        System.out.println("Exiting program...");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("An error occurred: " + e.getMessage());
                scanner.close();
                System.exit(1);
            }
        }
    }
}
