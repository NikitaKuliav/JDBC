package source;

import java.sql.*;


public class Application {
    public static void main(String[] args) throws SQLException {
        final String user = "postgres";
        final String pass = "root";
        final String url = "jdbc:postgresql://localhost:5432/skypro";

        try (final Connection connection = DriverManager.getConnection(url, user, pass);
             PreparedStatement statement = connection.prepareStatement("" +
                     "SELECT  * FROM employee WHERE id = (?)")) {
            statement.setInt(1, 2);
            final ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = "Name: " + resultSet.getString("first_name");
                String surname = "Surname: " + resultSet.getString("last_name");
                String gender = "Gender: " + resultSet.getString(4);
                String city = "City id: " + resultSet.getInt(6);

                System.out.println(name);
                System.out.println(surname);
                System.out.println(gender);
                System.out.println(city);
            }
        }
    }
}
