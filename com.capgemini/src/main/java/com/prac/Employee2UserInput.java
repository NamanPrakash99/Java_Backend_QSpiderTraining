package com.prac;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Employee2UserInput {

    static String url = "jdbc:postgresql://localhost:5432/College";
    static String username = "postgres";
    static String pwd = "2580";

    static Connection connect;

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        try {
        	
            connect = DriverManager.getConnection(url, username, pwd);
            System.out.println("1.Add  2.Delete  3.Update  4.Find");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    addEmployee(sc);
                    break;

                case 2:
                    deleteById(sc);
                    break;

                case 3:
                    updateById(sc);
                    break;

                case 4:
                    findById(sc);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
            
            connect.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void addEmployee(Scanner sc) throws Exception {

        String sql = "INSERT INTO employee VALUES(?,?,?)";
        PreparedStatement pstm = connect.prepareStatement(sql);

        System.out.println("Enter ID:");
        int id=sc.nextInt();
        pstm.setInt(1, id);

        System.out.println("Enter Name:");
        String name=sc.next();
        pstm.setString(2, name);

        System.out.println("Enter Salary:");
        double salary=sc.nextDouble();
        pstm.setDouble(3, salary);

        pstm.execute();
        System.out.println("Employee Inserted!");
    }

    static void deleteById(Scanner sc) throws Exception {

        String sql = "delete from employee WHERE eid=?";
        PreparedStatement pstm = connect.prepareStatement(sql);

        System.out.println("Enter ID to delete:");
        int id=sc.nextInt();
        pstm.setInt(1, id);

        pstm.execute();
        System.out.println("Employee Deleted!");
    }

    static void updateById(Scanner sc) throws Exception {

        String sql = "UPDATE employee SET ename=? WHERE eid=?";
        PreparedStatement pstm = connect.prepareStatement(sql);

        System.out.println("Enter name to update:");
        String name=sc.next();
        pstm.setString(1, name);


        System.out.println("Enter ID:");
        int id=sc.nextInt();
        pstm.setInt(2, id);

        pstm.execute();
        System.out.println("Employee Updated!");
    }


    static void findById(Scanner sc) throws Exception {

        String sql = "Select * FROM employee WHERE eid=?";
        PreparedStatement pstm = connect.prepareStatement(sql);

        System.out.println("Enter ID to find:");
        int id=sc.nextInt();
        pstm.setInt(1, id);

        ResultSet rs = pstm.executeQuery();

        if(rs.next()){
            System.out.println("ID: "+rs.getInt("eid"));
            System.out.println("Name: "+rs.getString("ename"));
            System.out.println("Salary: "+rs.getDouble("salary"));
        } else {
            System.out.println("Not found!");
        }
    }
}
