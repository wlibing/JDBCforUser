package myUserManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ttc on 18-1-23.
 */
public class textporperies {
    public static void main(String[] args)  {
        InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");

        //新建一个Property对象
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String strDriver = properties.getProperty("driver");
        System.out.println(strDriver);
        String url = properties.getProperty("url");
        System.out.println(url);

    }

}
