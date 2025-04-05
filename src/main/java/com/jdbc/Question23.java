package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//23. Write a JDBC application to insert, update and delete record from company
//share holder’s Table. Given the structure: SHAREHOLDER : Holderid, H
//name, Address, No.of shares, sharesr From (Share serial from Number),
//ShareSrTo (Share Serial upto Number), Facevalue, cost
public class Question23 {
    public static Connection connection = DBConn.getConnection();

    public static void insert() {
        Scanner sc = new Scanner(System.in);
        String query = "insert into shareholder (HName,Address,NoOfShares,ShareSrFrom,ShareSrTo,FaceValue,Cost) values (?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            System.out.println("Enter Name : ");
            ps.setString(1, sc.next());

            System.out.println("Enter Address : ");
            ps.setString(2, sc.next());
            System.out.println("Enter NoOfShares : ");
            ps.setInt(3, sc.nextInt());
            System.out.println("Enter ShareSrFrom : ");
            ps.setInt(4, sc.nextInt());
            System.out.println("Enter ShareSrTo : ");
            ps.setInt(5, sc.nextInt());
            System.out.println("Enter FaceValue : ");
            ps.setDouble(6, sc.nextDouble());
            System.out.println("Enter Cost : ");
            ps.setDouble(7, sc.nextDouble());
            if (!ps.execute()) {
                System.out.println("Insert Successful");
            } else {
                System.out.println("Insert Failed");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void update() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Holder Id:");
        int id = sc.nextInt();
        System.out.println("Enter Address to upodate");
        sc.nextLine();
        String address = sc.nextLine();
        String sqlUpdate = "update shareholder set Address=? where HolderID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlUpdate);
            ps.setString(1, address);
            ps.setInt(2, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("Update Successful");
            } else {
                System.out.println("Update Failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Holder Id:");
        int id = sc.nextInt();
        String sqlDelete = "delete from shareholder where HolderID=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sqlDelete);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {

                System.out.println("Delete Successful");
            } else {
                System.out.println("Delete Failed");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {


//        insert();
//        update();
        delete();
    }
}
