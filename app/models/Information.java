package models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import play.db.DB;

public class Information {

    private int id;
    private String name;
    private int age;
    private String gender;
    private String email;

    public Information(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Information(int id, String name, int age, String gender, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public boolean saveGuest() throws SQLException {
        Connection connection = DB.getConnection();
        String query = "INSERT INTO guest(Guest_Name, Age, Gender, E_mail) VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1,name);
        statement.setInt(2, age);
        statement.setString(3,gender);
        statement.setString(4,email);

        boolean res = statement.execute();
        connection.close();
        return res;
    }


}
