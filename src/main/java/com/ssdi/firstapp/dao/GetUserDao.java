package com.ssdi.firstapp.dao;

import com.ssdi.firstapp.model.User;
import com.ssdi.firstapp.util.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetUserDao {

    public User getUser(int userID){
        User user = null;
        try (Connection connection = DBConnector.getConnection()) {
            Statement statement = null;
            String returnString = "";

            try {

                System.out.println("Creating statement...");
                statement = connection.createStatement();
                String sql;
                sql = "SELECT * FROM USER WHERE userID = "+userID;
                ResultSet rs = statement.executeQuery(sql);

                //STEP 5: Extract data from result set
                while (rs.next()) {
                    //Retrieve by column name
                    String name = rs.getString("firstname");
                    int bookCount = rs.getInt("bookcount");
                    String mobile = rs.getString("firstname");
                    String firstname = rs.getString("firstname");
                    String lastname = rs.getString("lastname");
                    String email = rs.getString("email");
                    String address = rs.getString("address");



                    //Display values

                    returnString = returnString + "Name : "+name + " | Book Count : "+ bookCount +"\n";
                    user = new User(userID,name,firstname,lastname,address,mobile,email,bookCount);
                }
                //STEP 6: Clean-up environment
//                rs.close();
//                statement.close();
//                connection.close();
            } catch (SQLException se) {
                //Handle errors for JDBC
                se.printStackTrace();
            } catch (Exception e) {
                //Handle errors for Class.forName
                e.printStackTrace();
//            } finally {
//                //finally block used to close resources
//                try {
//                    if (statement != null)
//                        System.out.println("Expected to close the connection");
////                        statement.close();
//                } catch (Exception se2) {
//                    System.out.println("Expected to close the connection");
//                }// nothing we can do
//                try {
//                    if (connection != null)
////                        connection.close();
//                        System.out.println("Expected to close the connection");
//                } catch (Exception se) {
//                    se.printStackTrace();
//                }//end finally try
            }//end try



            return user;


        }catch (SQLException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
        return null;
    }
}
