package experience;

import java.sql.*;

/**
 * Created by ttc on 18-3-14.
 */
public class Select {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载mysql数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //2.获得数据库连接对象
        String url = "jdbc:mysql://localhost:3306/mybase?useUnicode=true&characterEncoding=UTF-8";
        String username = "root";
        String password = "root";
        Connection conn = DriverManager.getConnection(url, username, password);//
        // Connection connection=JDBCUtils.gerConnection();//此语句是引用一个已经写好（java连接数据库）的方法.即等同于上面写的五句。

        //3.创建数据库连接对象，相当于navicat的查询窗口 //4.执行查询语句（插入一条记录）
        // PreparedStatement p=connection.prepareStatement("SELECT * FROM sort WHERE sid=3");
        PreparedStatement p = conn.prepareStatement("SELECT * FROM sort WHERE sid=3");
        ResultSet r = p.executeQuery();
        if (r.next() == true) {
            System.out.println(r.getString("sname"));
        }

        //5.关闭数据库连接
//        JDBCUtils.close(p,connection);
        p.close();
        conn.close();

    }
}
