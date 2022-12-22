package lesson8;

import java.sql.*;

public class SqliteExamples {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName("org.sqlite.JDBC"); // прописали драйвер через который подключаться к БД
            connection = DriverManager.getConnection("jdbc:sqlite:geekbrains.db");
            statement = connection.createStatement();
            int count = statement.executeUpdate("update faculties set name = 'Gryffindor_1' where id = 1");
            System.out.println("Изменено строк: " + count);

            ResultSet resultSet = statement.executeQuery("select * from faculties");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.println(resultSet.getString("name"));
            }
//            Long time = System.currentTimeMillis();
//            for (int i = 0; i < 1000; i++) {
//                statement.executeUpdate(String.format("insert into students (name, score, fac_id) values ('%s', %d, %d)",
//                        "student" + i, i, i));
//            }
//            System.out.println("Время выполнения с автокоммитом: " + (System.currentTimeMillis() - time));
//
//            time = System.currentTimeMillis();
//            connection.setAutoCommit(false);
//            for (int i = 0; i < 10000; i++) {
//                statement.executeUpdate(String.format("insert into students (name, score, fac_id) values ('%s', %d, %d)",
//                        "student" + i, i, i));
//            }
//            connection.commit();
//            System.out.println("Время выполнения без автокоммита: " + (System.currentTimeMillis() - time));

            statement.executeUpdate("delete from students where name like 'student%'");
            // statement.executeUpdate("delete from students");  // удалит всех предыдущих и добавит только тех, что ниже
            connection.setAutoCommit(true);
            preparedStatement = connection.prepareStatement("insert into students (name, score, fac_id) values (?, ?, ?)");
            preparedStatement.setString(1,"Garry");
            preparedStatement.setInt(2, 19);
            preparedStatement.setInt(3,11);
            preparedStatement.addBatch();
            preparedStatement.setString(1,"Ron");
            preparedStatement.setInt(2, 7);
            preparedStatement.setInt(3,12);
            preparedStatement.addBatch();
            preparedStatement.executeBatch();

            resultSet = statement.executeQuery("select * from students");
            while (resultSet.next()) {
                System.out.print(resultSet.getInt("id"));
                System.out.print(" ");
                System.out.print(resultSet.getString("name"));
                System.out.println(resultSet.getString("score"));
            }



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables .printStackTrace();
        } finally {
            connection.close();
        }
    }
}
