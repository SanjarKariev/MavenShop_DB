

import java.sql.*;
import java.sql.SQLException;
public class StoreInfo {
    private static Connection connection;
    private static Statement stmt;

    public static void main(String[] args) throws SQLException, NullPointerException, ClassNotFoundException {

        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Sanjar/IdeaProjects/sqlite/shop.db");
        stmt = connection.createStatement();


        newProduct(10, "iPhone", "black", 2, 20000);
        updateProducts(10, "iPhone", "black", 2, 20000);

    }

    public static void newProduct(int id, String name, String color, int amount, int cost) throws NullPointerException, SQLException {
            Statement stmt = connection.createStatement();
            String preparedStatement1 = "INSERT INTO Products(IdOfProducts, NameOfProducts, ColorOfProducts, AmountOfProducts, costOfProducts) VALUES (1, 'Iphone', 'Pink', 1, 10000)";
            stmt.executeUpdate(preparedStatement1);
    }

    public static void updateProducts(int id, String name, String color, int amount, int cost) throws SQLException {

        Statement stmt = connection.createStatement();
        stmt.execute("UPDATE Products SET IdOfProducts=" + id +
                ", NameOfProducts='" + name + "', ColorOfProducts='" + color + "', AmountOfProducts=" + amount + ",costOfProducts=" + cost + "  where IdOfProducts = 1");

        ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
        System.out.println(rs.getString("ColorOfProducts"));
    }

    public static void deleteProducts() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("DELETE FROM Products WHERE Products.IdOfProducts >= 1");
    }


    public static void alterProducts() throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.execute("Alter table Products RENAME COLUMN id to IdOfProducts");
        stmt.execute("Alter table Products RENAME COLUMN name to NameOfProducts");
        stmt.execute(" Alter table Products RENAME COLUMN color to ColorOfProducts");
        stmt.execute(" Alter table Products RENAME COLUMN amount to AmountOfProducts");
        stmt.execute("Alter table Products RENAME COLUMN cost to costOfProducts");
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }
}