package com.company;



import com.company.PersonInof;
import myUserManager.JDBCUtils;

import java.sql.*;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ttc on 18-1-23.
 */
public class TextManager {

    public static List<PersonInof> getAllpersoninof() throws SQLException, ParseException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person ");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<PersonInof> personinofList = new ArrayList<>();


        while (resultSet.next() == true) {
            int id = resultSet.getInt("pid");
            String name = resultSet.getString("name");
            String pkey = resultSet.getString("pkey");
            String bir = resultSet.getString("birthday");
            String email = resultSet.getString("email");
            String pkind = resultSet.getString("pkind");

            PersonInof personInof = new PersonInof();

            personInof.setPid(id);
            personInof.setName(name);
            personInof.setPkey(pkey);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(bir);
            long timetypes = date.getTime();
            java.sql.Date sqltime = new java.sql.Date(timetypes);
            personInof.setBirthday(sqltime);

            personInof.setEmail(email);
            personInof.setPower(pkind);
            personinofList.add(personInof);
        }


        JDBCUtils.close(resultSet, preparedStatement, connection);
        return personinofList;
    }


    public static PersonInof getppersoninofByNameKey(String pnmae, String pkey) throws SQLException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person where name=?and pkey=?");
        preparedStatement.setString(1, pnmae);
        preparedStatement.setString(2, pkey);
        ResultSet resultSet = preparedStatement.executeQuery();
        PersonInof idpersonInof = null;

        if (resultSet.next() == true) {
            int i = resultSet.getInt("pid");
            String name = resultSet.getString("name");
            String pkeyl = resultSet.getString("pkey");
            String ema = resultSet.getString("email");
            String pow = resultSet.getString("pkind");
            Date date = resultSet.getDate("birthday");
            idpersonInof = new PersonInof();
            idpersonInof.setPid(i);
            idpersonInof.setName(name);
            idpersonInof.setEmail(ema);
            idpersonInof.setPkey(pkeyl);
            idpersonInof.setPower(pow);
            idpersonInof.setBirthday(date);

        }
        JDBCUtils.close(resultSet, preparedStatement, connection);
        return idpersonInof;
    }


    public static PersonInof getpersoninofById(int id) throws SQLException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person where pid=?");
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        PersonInof personInof = null;
        if (resultSet.next() == true) {
            int i = resultSet.getInt("pid");
            String name = resultSet.getString("name");
            String pkeyl = resultSet.getString("pkey");
            String ema = resultSet.getString("email");
            String pow = resultSet.getString("pkind");
            Date date = resultSet.getDate("birthday");
            personInof = new PersonInof();
            personInof.setPid(i);
            personInof.setName(name);
            personInof.setPkey(pkeyl);
            personInof.setEmail(ema);
            personInof.setPower(pow);
            personInof.setBirthday(date);

        }
        JDBCUtils.close(resultSet, preparedStatement, connection);
        return personInof;
    }
public static int  getGuessReall(String name) throws SQLException {
        Connection connection=JDBCUtils.gerConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("select * from person where name=?");
        preparedStatement.setString(1,name);
        ResultSet resultSet=preparedStatement.executeQuery();
        int n=1;
        if (resultSet.next()==true){
            n=0;
        }
        return n;
}

    public static List<PersonInof> getpersoninofByName(String name) throws SQLException, ParseException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from person where name like ?");
        preparedStatement.setString(1, "%" + name + "%");

        ResultSet resultSet = preparedStatement.executeQuery();
        List<PersonInof> personinofList = new ArrayList<>();

        PersonInof personInof = null;
        while (resultSet.next() == true) {
            int id = resultSet.getInt("pid");
            String name1 = resultSet.getString("name");
            String pkey = resultSet.getString("pkey");
            String bir = resultSet.getString("birthday");
            String email = resultSet.getString("email");
            String pkind = resultSet.getString("pkind");

            personInof = new PersonInof();

            personInof.setPid(id);
            personInof.setName(name1);
            personInof.setPkey(pkey);

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse(bir);
            long timetypes = date.getTime();
            java.sql.Date sqltime = new java.sql.Date(timetypes);
            personInof.setBirthday(sqltime);

            personInof.setEmail(email);
            personInof.setPower(pkind);
            personinofList.add(personInof);
        }


        JDBCUtils.close(resultSet, preparedStatement, connection);
        return personinofList;
    }

    public static int updatePersoninof(PersonInof personInof) throws SQLException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update person set name = ?, pkey= ?, birthday= ?, email= ? where pid = ?");
        preparedStatement.setString(1, personInof.getName());
        preparedStatement.setString(2, personInof.getPkey());

        Date date = personInof.getBirthday();
        long timetypes = date.getTime();
        java.sql.Date sqltime = new java.sql.Date(timetypes);
        preparedStatement.setDate(3, sqltime);

        preparedStatement.setString(4, personInof.getEmail());
        preparedStatement.setInt(5, personInof.getPid());
        int row = preparedStatement.executeUpdate();

        JDBCUtils.close(preparedStatement, connection);
        return row;
    }


    public static int AllupdatePersoninof(PersonInof personInof) throws SQLException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("update person set name = ?, pkey= ?, birthday= ?, email= ?,pkind=? where pid = ?");
        preparedStatement.setString(1, personInof.getName());
        preparedStatement.setString(2, personInof.getPkey());

        Date date = personInof.getBirthday();
        long timetypes = date.getTime();
        java.sql.Date sqltime = new java.sql.Date(timetypes);
        preparedStatement.setDate(3, sqltime);

        preparedStatement.setString(4, personInof.getEmail());
        preparedStatement.setString(5, personInof.getPower());
        preparedStatement.setInt(6, personInof.getPid());
        int row = preparedStatement.executeUpdate();

        JDBCUtils.close(preparedStatement, connection);
        return row;
    }

    public static int AddPersoninof(PersonInof personInof) throws SQLException {
        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into person (name,pkey,birthday,email,pkind) values(?,?,?,?,?)");
        preparedStatement.setString(1, personInof.getName());
        preparedStatement.setString(2, personInof.getPkey());
        Date date = personInof.getBirthday();
        long timetypes = date.getTime();
        java.sql.Date sqltime = new java.sql.Date(timetypes);
        preparedStatement.setDate(3, sqltime);
        preparedStatement.setString(4, personInof.getEmail());
        preparedStatement.setString(5, personInof.getPower());
        int row = preparedStatement.executeUpdate();

        JDBCUtils.close(preparedStatement, connection);
        return row;
    }

    public static int getDeletepersoninofById(int id) throws SQLException {

        Connection connection = JDBCUtils.gerConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM  person WHERE pid=?");
        preparedStatement.setInt(1, id);
        int row = preparedStatement.executeUpdate();

        JDBCUtils.close(preparedStatement, connection);
        return row;
    }

    public static void main(String[] args) throws SQLException, ParseException {
        Scanner scanner = new Scanner(System.in);

        boolean w = true;
        while (w == true) {

            System.out.println("欢迎使用neusoft的用户管理系统");
            System.out.println("=============================");
            System.out.println("用户登录--------------------1");
            System.out.println("用户注册--------------------2");
            System.out.println("退出程序--------------------3");


            int num = scanner.nextInt();
            if (num == 1) {
                System.out.println("用户登录界面");
                System.out.println("=============================");
                System.out.println("请输入您的用户名");
                String name = scanner.next();
                System.out.println("请输入您的密码");
                String key = scanner.next();
                PersonInof personInof = getppersoninofByNameKey(name, key);

                if (personInof != null) {
                    System.out.println("登录成功。。。");
                    System.out.println("=============================");
                    System.out.println("欢迎登陆主窗体");
                    System.out.println(personInof.getName() + "您好：" + "\t您的权限是：" + personInof.getPower());
                    if (personInof.getPower().equals("管理员")) {
                        w = false;
                    }
                    while (w == true) {

                        System.out.println("=============================");
                        System.out.println("修改自己的信息--------------------1");
                        System.out.println("查询自己的信息--------------------2");
                        System.out.println("退出程序--------------------3");
                        int a = scanner.nextInt();
                        if (a == 1) {
                            System.out.println("您现在的信息是：");
                            System.out.println(personInof.getPid() + "\t" + personInof.getName() + "\t" + personInof.getPkey() + "\t" + personInof.getBirthday() + "\t" + personInof.getEmail() + "\t" + personInof.getPower());
                            System.out.println("=============================");
                            System.out.println("请输入要修改的姓名");
                            String names = scanner.next();
                            System.out.println("请输入要修改的密码");
                            String pkey = scanner.next();
                            System.out.println("请输入要修改的生日");
                            String bir = scanner.next();
                            System.out.println("请输入要修改的邮箱");
                            String email = scanner.next();
                            PersonInof personInof1 = new PersonInof();
                            personInof1.setName(names);
                            personInof1.setPkey(pkey);
                            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = simpleDateFormat.parse(bir);
                            personInof1.setBirthday(date);
                            personInof1.setEmail(email);
                            personInof1.setPid(personInof.getPid());
                            updatePersoninof(personInof1);
                            System.out.println("修改成功");
                        } else if (a == 2) {
                            PersonInof personInof2 = getpersoninofById(personInof.getPid());
                            System.out.println(personInof2);
                        } else if (a == 3) {
                            break;
                        } else {
                            System.out.println("输入有误，请重新输入");
                        }
                    }
                } else {
                    System.out.println("请输入正确的用户名和密码");
                }
            } else if (num == 2) {
                System.out.println("用户注册界面");
                System.out.println("=============================");
                while (true) {
                System.out.println("请输入您的用户名");
                String name = scanner.next();

                if (getGuessReall(name)==0)
                {
                    System.out.println("用户名已存在，请重新输入");
                   // num=2;
                    continue;
                }

                System.out.println("请输入您的密码");
                String pkey = scanner.next();
                System.out.println("请输入您的生日");
                String bir = scanner.next();
                System.out.println("请输入您的邮箱");
                String email = scanner.next();
                System.out.println("请输入您的角色");
                String pkind = scanner.next();

                PersonInof personInof = new PersonInof();

                personInof.setName(name);
                personInof.setPkey(pkey);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(bir);
                personInof.setBirthday(date);
                personInof.setEmail(email);
                personInof.setPower(pkind);
                AddPersoninof(personInof);
                System.out.println("用户注册成功");
                break;
            }
             }//注册时用户名重复的情况
            else if (num == 3) {
                System.out.println("退出程序");
                break;
            } else {
                System.out.println("输入有误，请重新输入");
                w = true;
            }
        }

        //以上为用户
        while (w == false) {
            System.out.println("=============================");
            System.out.println("添加用户--------------------1");
            System.out.println("删除用户--------------------2");
            System.out.println("修改用户--------------------3");
            System.out.println("查询用户--------------------4");
            System.out.println("退出程序--------------------5");
            int num = scanner.nextInt();

            if (num == 1) {
                System.out.println("请输入用户名");
                String name = scanner.next();
                System.out.println("请输入密码");
                String pkey = scanner.next();
                System.out.println("请输入生日");
                String bir = scanner.next();
                System.out.println("请输入邮箱");
                String email = scanner.next();

                PersonInof personInof = new PersonInof();
                personInof.setName(name);
                personInof.setPkey(pkey);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(bir);
                personInof.setBirthday(date);
                personInof.setEmail(email);

                AddPersoninof(personInof);
                System.out.println("添加用户成功");
            }//添加
            else if (num == 2) {
                System.out.println("请输入您要删除用户的ID");
                int i = scanner.nextInt();
                getDeletepersoninofById(i);
                System.out.println("删除成功");
            }//删除
            else if (num == 3) {
                System.out.println("请的输入要修改的用户的ID");
                int i = scanner.nextInt();
                System.out.println("请的输入要修改的用户的姓名");
                String names = scanner.next();
                System.out.println("请的输入要修改的用户的密码");
                String pkey = scanner.next();
                System.out.println("请的输入要修改的用户的生日");
                String bir = scanner.next();
                System.out.println("请的输入要修改的用户的邮箱");
                String email = scanner.next();
                System.out.println("请的输入要修改的用户的角色（普通用户/管理员）");
                String power = scanner.next();

                PersonInof personInof1 = new PersonInof();

                personInof1.setPid(i);
                personInof1.setName(names);
                personInof1.setPkey(pkey);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date date = simpleDateFormat.parse(bir);
                personInof1.setBirthday(date);
                personInof1.setEmail(email);
                personInof1.setPower(power);
                AllupdatePersoninof(personInof1);
                System.out.println("修改成功");
            }//修改
            else if (num == 4) {
                System.out.println("查询全部用户--------------------1");
                System.out.println("根据ID查询用户--------------------2");
                System.out.println("根据姓名查询用户--------------------3");
                System.out.println("请输入您的操作");
                int n = scanner.nextInt();
                if (n == 1) {
                    List<PersonInof> personInofs = getAllpersoninof();
                    for (PersonInof personInof : personInofs) {
                        System.out.println(personInof);
                    }
                } else if (n == 2) {
                    System.out.println("请输入要查询的ID");
                    int i = scanner.nextInt();
                    PersonInof personInof = getpersoninofById(i);
                    if (personInof != null) {
                        System.out.println(personInof);
                    } else {
                        System.out.println("没查着");
                    }
                } else if (n == 3) {
                    System.out.println("请输入要查询的用户名（支持模糊查询）");
                    String name = scanner.next();
                    List<PersonInof> personInofList = getpersoninofByName(name);
                    if (personInofList.size() != 0) {
                        for (PersonInof personInof : personInofList) {
                            System.out.println(personInof);
                        }
                    } else {
                        System.out.println("没有找到您要查询的人");
                    }
                } else {
                    System.out.println("输入有误，请重新输入");
                    num = 4;
                }
            }//查询


            else if (num == 5) {
                break;
            }//退出
            else {
                System.out.println("输入有误，请重新输入");
                w = false;
            }
        }
        System.out.println("感谢您的使用,再见!");
    }
}