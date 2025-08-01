import java.sql.*;

public class DBlogic {

    private String DB = "jdbc:mysql://localhost:3306/java_oop_mysql";
    private String USER = "root";
    private String PASS = "";

    // connection method
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection(DB, USER, PASS);
    }

    //create - insert
    public void create(String email, String password) throws SQLException {

        String sql = "INSERT INTO users (email, password) VALUES (?, ?)";

        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ) {
            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.executeUpdate();

            System.out.println("User created!");

        }

    }

    // read - select
    public void readAll() throws SQLException{

        String sql = "SELECT * FROM  users";

        try (Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql);
        ) {
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User E-mail:" +resultSet.getString("email"));
                System.out.println("User Password:" + resultSet.getString("password"));
                System.out.println("-------------");
            }
        }

    }

    // read - select
    public void readById(int id) throws SQLException{
        String sql  = "SELECT * FROM users WHERE ID = ?";

        try (Connection conn = getConnection();
            PreparedStatement pstmt = getConnection().prepareStatement(sql);
        ) {

            pstmt.setInt(1,id);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("User ID: " + resultSet.getInt("id"));
                    System.out.println("User E-mail:" +resultSet.getString("email"));
                    System.out.println("User Password:" + resultSet.getString("password"));
                    System.out.println("-------------");

                } else {
                    System.out.println("Users with ID: "+ id + "dont exists");
                }


            }
        }
    }

    // read -select
    public void readByEmail(String email) throws SQLException{
        String sql  = "SELECT * FROM users WHERE ID = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = getConnection().prepareStatement(sql);
        ) {

            pstmt.setString(1,email);

            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    System.out.println("User ID: " + resultSet.getInt("id"));
                    System.out.println("User E-mail:" +resultSet.getString("email"));
                    System.out.println("User Password:" + resultSet.getString("password"));
                    System.out.println("-------------");

                } else {
                    System.out.println("Users with email: "+ email + "dont exists");
                }


            }
        }
    }

    //update - update
    public void updateEmail(int id, String newEmail) throws SQLException {

        String sql = "UPDATE users SET email = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, newEmail);
            pstmt.setInt(2,id);

            int rowsEffected = pstmt.executeUpdate();

            if (rowsEffected >0) {
                System.out.println("E-mail updated successfully!");
            } else {
                System.out.println("User with ID:" + id + "not user");
            }

        }
    }

    //update - update
    public void updatePassword(int id, String newPassword) throws SQLException {

        String sql = "UPDATE users SET password = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            pstmt.setString(1, newPassword);
            pstmt.setInt(2,id);

            int rowsEffected = pstmt.executeUpdate();

            if (rowsEffected >0) {
                System.out.println("Password updated successfully!");
            } else {
                System.out.println("User with ID:" + id + "not user");
            }

        }
    }



}
