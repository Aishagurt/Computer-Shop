package kz.shop.db;

import kz.shop.entities.Items;
import kz.shop.entities.Users;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;

public class DBManager {

    private static Connection connection;

    static{

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(

                    "jdbc:mysql://localhost:3306/bitlab_test?useUnicode=true&serverTimezone=UTC","root", ""

            );

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static void addItem(Items item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO items (id, name, description, price) " +

                    "VALUES (NULL, ?, ?, ?)"

            );

            statement.setString(1, item.getName());

            statement.setString(2, item.getDescription());

            statement.setDouble(3, item.getPrice());

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    public static ArrayList<Items> getAllItems(){

        ArrayList<Items> itemsList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                String name = resultSet.getString("name");

                String description = resultSet.getString("description");

                double price = resultSet.getDouble("price");

                itemsList.add(new Items(id, name, description, price));

            }

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        return itemsList;

    }
    public static Items getItem(Long id){

        Items item = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String name = resultSet.getString("name");

                String description = resultSet.getString("description");

                double price = resultSet.getDouble("price");

                item = new Items(id, name, description, price);

            }

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        return item;

    }

    public static void updateItem(Items item){

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "UPDATE items SET name = ?, description = ?, price = ? " +

                    "WHERE id = ?");

            statement.setString(1, item.getName());

            statement.setString(2, item.getDescription());

            statement.setDouble(3, item.getPrice());

            statement.setLong(4, item.getId());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    public static void deleteItem(Long id){

        try{

            PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE id = ?");

            statement.setLong(1, id);

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    public static void addUser(Users user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "INSERT INTO users (id, email, password, fullname) " +

                    "VALUES (NULL, ?, ?, ?)"

            );

            statement.setString(1, user.getEmail());

            statement.setString(2, user.getPassword());

            statement.setString(3, user.getFullName());

            int rows = statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }

    public static ArrayList<Users> getAllUsers(){

        ArrayList<Users> usersList = new ArrayList<>();

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){

                Long id = resultSet.getLong("id");

                String email = resultSet.getString("email");

                String password = resultSet.getString("password");

                String fullname = resultSet.getString("fullname");

                usersList.add(new Users(id, email, password, fullname));

            }

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        return usersList;

    }
    public static Users getUser(Long id){

        Users user = null;

        try{

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                String email = resultSet.getString("email");

                String password = resultSet.getString("password");

                String fullname = resultSet.getString("fullname");

                user = new Users(id, email, password, fullname);

            }

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

        return user;

    }
    public static Users getUser(String email){



        Users user = null;



        try{



            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ? LIMIT 1");

            statement.setString(1, email);



            ResultSet resultSet = statement.executeQuery();

            if(resultSet.next()){

                user = new Users();

                user.setEmail(resultSet.getString("email"));

                user.setId(resultSet.getLong("id"));

                user.setPassword(resultSet.getString("password"));

                user.setFullName(resultSet.getString("full_name"));

            }
            statement.close();



        }catch (Exception e){

            e.printStackTrace();

        }

        return user;

    }

    public static void updateUser(Users user){

        try{

            PreparedStatement statement = connection.prepareStatement("" +

                    "UPDATE users SET email = ?, password = ?, fullname = ? " +

                    "WHERE id = ?");

            statement.setString(1, user.getEmail());

            statement.setString(2, user.getPassword());

            statement.setString(3, user.getFullName());

            statement.setLong(4, user.getId());

            statement.executeUpdate();

            statement.close();

        }catch (Exception e){

            e.printStackTrace();

        }

    }



}
