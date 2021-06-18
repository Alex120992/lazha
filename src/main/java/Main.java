import ru.zateev.javaee_jdbc.Entity.Person;
import ru.zateev.javaee_jdbc.connection.Connect;
import ru.zateev.javaee_jdbc.users.UserImpl1;
import ru.zateev.javaee_jdbc.users.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Users users = new UserImpl1();
        Person person = new Person();

        try (Connection connection = new Connect().newInstance()) {

            try (PreparedStatement ps = connection.prepareStatement(users.getSELECT_BY_ID() + 15)) {
                ResultSet resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    person.setId(resultSet.getInt("id"));
                    System.out.println(person.getId()+"sdasdads");
                    person.setName(resultSet.getString("name"));
                    person.setSurname(resultSet.getString("surname"));
                    person.setAge(resultSet.getInt("age"));
                    person.setMail(resultSet.getString("mail"));
                }

            } catch (NullPointerException e) {
                System.err.println("Проблемы с prepare");
                connection.rollback();
                connection.setAutoCommit(true);
                throw new SQLException();
            }
            connection.setAutoCommit(true);

        } catch (SQLException e) {
            System.err.println(e.getErrorCode());
        }
        System.out.println(person);
    }
}
