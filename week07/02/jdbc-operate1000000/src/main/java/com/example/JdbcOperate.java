package com.example;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcOperate {

    public static void main(String[] args) throws SQLException {
//        jdbcOperate();//jdbc普通操作    //1002436ms  1002s
//        jdbcBatchOperate();//jdbc,事务，批处理  //80751ms 80s
        new JdbcOperate().hikari();//连接池操作 //81504ms 81s

    }

    public static void jdbcOperate () throws SQLException {
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=utf-8","root","root");
            stat = connection.createStatement();
            long millis = System.currentTimeMillis();
            for(int i = 0 ; i<1000000 ; i++){
                stat.execute("insert into test values (" + i + ",'wy')");
            }
            long useTime = System.currentTimeMillis() - millis; //1002436ms
            System.out.println("useTime:" + useTime);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            connection.close();
            stat.close();
        }
    }

    public static void jdbcBatchOperate() throws SQLException {
        Connection connection = null;
        Statement stat = null;
        ResultSet rs = null;
        try{
            long millis = System.currentTimeMillis();
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/test?useUnicode=true&characterEncoding=utf-8","root","root");connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into test1 values (?,?)");
            for (int i=0;i<1000000;i++){
                ps.setInt(1,i);
                ps.setString(2,"zs");
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
            long useTime = System.currentTimeMillis() - millis; //80751 ms
            System.out.println("useTime:" + useTime);

        } catch (Exception e) {
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }
    }

    public void hikari(){
        long millis = System.currentTimeMillis();
        try(InputStream in = JdbcOperate.class.getClassLoader().getResourceAsStream("hikari.properties");){
            Properties properties = new Properties();
            properties.load(in);
            HikariConfig hikariConfig = new HikariConfig(properties);
            HikariDataSource dataSource = new HikariDataSource(hikariConfig);
            Connection connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement ps = connection.prepareStatement("insert into test2 values (?,?)");
            for (int i=0;i<1000000;i++){
                ps.setInt(1,i);
                ps.setString(2,"ww");
                ps.addBatch();
            }
            ps.executeBatch();
            connection.commit();
            long useTime = System.currentTimeMillis() - millis; //80751 ms
            System.out.println("useTime:" + useTime);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
