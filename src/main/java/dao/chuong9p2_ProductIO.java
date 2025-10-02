// package dao;

// import model.chuong9p2_Cart;
// import model.chuong9p2_Product;
// import model.chuong9p2_LineItem;

// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.StringTokenizer;

// public class chuong9p2_ProductIO {

//     public static chuong9p2_Product getProduct(String code, String filepath) {
//         try {
//             File file = new File(filepath);
//             BufferedReader in
//                     = new BufferedReader(
//                             new FileReader(file));

//             String line = in.readLine();
//             while (line != null) {
//                 StringTokenizer t = new StringTokenizer(line, "|");
//                 String productCode = t.nextToken();
//                 if (code.equalsIgnoreCase(productCode)) {
//                     String description = t.nextToken();
//                     double price = Double.parseDouble(t.nextToken());
//                     chuong9p2_Product p = new chuong9p2_Product();
//                     p.setCode(code);
//                     p.setDescription(description);
//                     p.setPrice(price);
//                     in.close();
//                     return p;
//                 }
//                 line = in.readLine();
//             }
//             in.close();
//             return null;
//         } catch (IOException e) {
//             System.err.println(e);
//             return null;
//         }
//     }

//     public static ArrayList<chuong9p2_Product> getProducts(String filepath) {
//         ArrayList<chuong9p2_Product> products = new ArrayList<chuong9p2_Product>();
//         File file = new File(filepath);
//         try {
//             BufferedReader in
//                     = new BufferedReader(
//                             new FileReader(file));

//             String line = in.readLine();
//             while (line != null) {
//                 StringTokenizer t = new StringTokenizer(line, "|");
//                 String code = t.nextToken();
//                 String description = t.nextToken();
//                 String priceAsString = t.nextToken();
//                 double price = Double.parseDouble(priceAsString);
//                 chuong9p2_Product p = new chuong9p2_Product();
//                 p.setCode(code);
//                 p.setDescription(description);
//                 p.setPrice(price);
//                 products.add(p);
//                 line = in.readLine();
//             }
//             in.close();
//             return products;
//         } catch (IOException e) {
//             System.err.println(e);
//             return null;
//         }
//     }
// }