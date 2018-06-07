package persona.jdbc;

import java.sql.*;

public class Conexion {
    
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/personas?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Driver driver = null;
    
    public static synchronized Connection getConnection() throws SQLException {
        if(driver == null){
            try{
                Class jdbcDriverClass = Class.forName(JDBC_DRIVER);
                driver = (Driver) jdbcDriverClass.newInstance();
                DriverManager.registerDriver(driver);
            } catch (Exception e){
                e.printStackTrace(System.out);
            }
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    
    public static void close(ResultSet rs){
        try{
            if(rs != null){
                rs.close();
            }
        } catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement stmt){
        try{
            if(stmt != null){
                stmt.close();
            }
        } catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conn){
        try{
            if(conn != null){
                conn.close();
            }
        } catch(SQLException e){
            e.printStackTrace(System.out);
        }
    }
}
