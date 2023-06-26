import java.sql.*;

public class DataBase {
    static Connection connection;
    static Statement statement;
    static ResultSet resultSet;
    DataBase(){
        try{
            String url = "jdbc:mysql://localhost:3306/highscore";
            connection = DriverManager.getConnection(url, "root", "1382");
            statement = connection.createStatement();
        }catch(Exception e){
            System.out.println(e);
        }

    }
    public static void selectHighScore(){
        try {
            resultSet = statement.executeQuery("select * from highscore");
            while (resultSet.next()) {
                Main.highscore = resultSet.getInt(1);
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public static void AddHighScore(int score){
        try {
            if (Main.highscore < score ) {
                PreparedStatement ps = connection.prepareStatement("update highscore set highScore = ?");
                ps.setInt(1, score);
                ps.executeUpdate();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
