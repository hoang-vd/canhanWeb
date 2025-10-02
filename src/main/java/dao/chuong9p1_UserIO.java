// package dao;

// import model.chuong9p1_User;

// import java.io.*;
// import java.util.ArrayList;
// import java.util.StringTokenizer;

// public class chuong9p1_UserIO {

//     public static boolean add(chuong9p1_User user, String filepath) {
//         try {
//             File file = new File(filepath);
//             PrintWriter out = new PrintWriter(
//                     new FileWriter(file, true));
//             out.println(user.getEmail() + "|"
//                     + user.getFirstName() + "|"
//                     + user.getLastName());

//             out.close();
//             return true;
//         } catch (IOException e) {
//             e.printStackTrace();
//             return false;
//         }
//     }

//     public static chuong9p1_User getUser(String email, String filepath) {
//         try {
//             File file = new File(filepath);
//             BufferedReader in = new BufferedReader(
//                     new FileReader(file));
//             chuong9p1_User user = new chuong9p1_User();
//             String line = in.readLine();
//             while (line != null) {
//                 StringTokenizer t = new StringTokenizer(line, "|");
//                 if (t.countTokens() < 3) {
//                     return new chuong9p1_User("", "", "");
//                 }
//                 String token = t.nextToken();
//                 if (token.equalsIgnoreCase(email)) {
//                     String firstName = t.nextToken();
//                     String lastName = t.nextToken();
//                     user.setEmail(email);
//                     user.setFirstName(firstName);
//                     user.setLastName(lastName);
//                 }
//                 line = in.readLine();
//             }
//             in.close();
//             return user;
//         } catch (IOException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }

//     public static ArrayList<chuong9p1_User> getUsers(String filepath) {
//         try {
//             ArrayList<chuong9p1_User> users = new ArrayList<chuong9p1_User>();
//             BufferedReader in = new BufferedReader(
//                     new FileReader(filepath));
//             String line = in.readLine();
//             while (line != null) {
//                 StringTokenizer t = new StringTokenizer(line, "|");
//                 String email = t.nextToken();
//                 String firstName = t.nextToken();
//                 String lastName = t.nextToken();
//                 chuong9p1_User user = new chuong9p1_User(firstName, lastName, email);
//                 users.add(user);
//                 line = in.readLine();
//             }
//             in.close();
//             return users;
//         } catch (IOException e) {
//             e.printStackTrace();
//             return null;
//         }
//     }
// }