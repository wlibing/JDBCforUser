package experience;

import java.sql.*;

/**
 * Created by ttc on 18-3-14.
 */
public class Change {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载mysql数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接对象
        String url = "jdbc:mysql://localhost:3306/mybase?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);//
       // Connection connection=JDBCUtils.gerConnection();//此语句是引用一个已经写好（java连接数据库）的方法.即等同于上面写的五句。

        //3.创建数据库连接对象，相当于navicat的查询窗口

        // PreparedStatement p = connection.prepareStatement("update sort set sname = ?,sprice = ?, sdesc=? where sid = ?");
        PreparedStatement p = conn.prepareStatement("update sort set sname = ?,sprice = ?, sdesc=? where sid = ?");

        //4.执行查询语句（插入一条记录）
        p.setString(1, "华为x");
        p.setInt(2, 6500);
        p.setString(3, "性价比高");
        p.setInt(4, 4);
        int row = p.executeUpdate();
        System.out.println(row);


        //5.关闭数据库连接
//        JDBCUtils.close(p,connection);
       p.close();
        conn.close();

    }
}
