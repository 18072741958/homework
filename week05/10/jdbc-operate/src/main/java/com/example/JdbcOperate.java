package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcOperate {

    public static void main(String[] args) throws SQLException {
//        jdbcOperate();//jdbc普通操作
//        jdbcBatchOperate();//jdbc,事务，批处理
        new JdbcOperate().hikari();//连接池操作

    }

    public static void jdbcOperate () throws SQLException {
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7017/test","test","test");
            stat = connection.createStatement();
            boolean insert = stat.execute("insert into test values (1,'wy')");
            System.out.println("insert:" + insert);
            rs = stat.executeQuery("select * from test");
            while (rs.next()){
                System.out.println("rs:" + rs.getInt("id") + "," + rs.getString("name"));
            }
            stat.execute("delete from test where id =1");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            stat.close();
            rs.close();
        }
    }

    public static void jdbcBatchOperate() throws SQLException {
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        int[] ids = new int[]{1,2,3};
        String[] names = {"wy","ze","zs"};
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:7017/test","test","test");
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into test values (?,?)");
            for (int i=0;i<3;i++){
                ps.setInt(1,ids[i]);
                ps.setString(2,names[i]);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
            stat = connection.createStatement();
            rs = stat.executeQuery("select * from test");
            while (rs.next()){
                System.out.println("rs:" + rs.getInt("id") + "," + rs.getString("name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
            stat.close();
            rs.close();
        }
    }

    public void hikari(){
        try(InputStream in = JdbcOperate.class.getClassLoader().getResourceAsStream("hikari.properties");){
            Properties properties = new Properties();
            properties.load(in);
            HikariConfig hikariConfig = new HikariConfig(properties);
            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into test values (?,?)");
            int[] ids = new int[]{4,5,6};
            String[] names = {"wy","ze","zs"};
            for (int i=0;i<3;i++){
                ps.setInt(1,ids[i]);
                ps.setString(2,names[i]);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
