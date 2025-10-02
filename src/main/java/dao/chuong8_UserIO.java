package dao;

import model.chuong8_User;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class chuong8_UserIO {

    public static void addRecord(chuong8_User user, String filename) throws IOException {
        File file = new File(filename);
        PrintWriter out = new PrintWriter(
                new FileWriter(file, true));
        out.println(user.getEmail() + "|"
                + user.getFirstName() + "|"
                + user.getLastName());
        out.close();
    }

    public static chuong8_User getUser(String emailAddress, String filename) throws IOException {
        File file = new File(filename);
        BufferedReader in = new BufferedReader(
                new FileReader(file));
        chuong8_User user = new chuong8_User();
        String line = in.readLine();
        while (line != null) {
            StringTokenizer t = new StringTokenizer(line, "|");
            String email = t.nextToken();
            if (email.equalsIgnoreCase(emailAddress)) {
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                user.setEmail(emailAddress);
                user.setFirstName(firstName);
                user.setLastName(lastName);
            }
            line = in.readLine();
        }
        in.close();
        return user;
    }

    public static ArrayList<chuong8_User> getUsers(String filename) throws IOException {
        ArrayList<chuong8_User> users = new ArrayList<chuong8_User>();
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String line = in.readLine();
        while (line != null) {
            try {
                StringTokenizer t = new StringTokenizer(line, "|");
                String emailAddress = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                chuong8_User user = new chuong8_User(firstName, lastName, emailAddress);
                users.add(user);
                line = in.readLine();
            } catch (NoSuchElementException e) {
                line = in.readLine();
            }
        }
        in.close();
        return users;
    }

    public static HashMap<String, chuong8_User> getUsersMap(String filename) throws IOException {
        HashMap<String, chuong8_User> users = new HashMap<String, chuong8_User>();
        BufferedReader in = new BufferedReader(
                new FileReader(filename));
        String line = in.readLine();
        while (line != null) {
            try {
                StringTokenizer t = new StringTokenizer(line, "|");
                String emailAddress = t.nextToken();
                String firstName = t.nextToken();
                String lastName = t.nextToken();
                chuong8_User user = new chuong8_User(firstName, lastName, emailAddress);
                users.put(emailAddress, user);
                line = in.readLine();
            } catch (NoSuchElementException e) {
                line = in.readLine();
            }
        }
        in.close();
        return users;
    }
}
