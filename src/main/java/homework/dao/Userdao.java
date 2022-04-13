package homework.dao;

import homework.modle.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Userdao implements com.dabing.dao.IUserDao {
    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql="insert into usertable values(?,?,?,?,?,?)";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,user.getId());
        qs.setString(2,user.getUsername());
        qs.setString(3,user.getPassword());
        qs.setString(4,user.getEmail());
        qs.setString(5,user.getGender());
        qs.setString(6,user.getBirthDate());
        return true;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql="delete from usertable where od=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,user.getId());
        int number=qs.executeUpdate();
        return number;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql="update usertable set username=?,password=?,email=?,gender=?,birthdate=?where id=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,user.getUsername());
        qs.setString(2,user.getPassword());
        qs.setString(3,user.getEmail());
        qs.setString(4,user.getGender());
        qs.setString(5,user.getBirthDate());
        int number=qs.executeUpdate();
        return number;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql="select * from usertable where id=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1, String.valueOf(id));
        ResultSet rs=qs.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql="Select * from usertable where username = ? and password = ?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
        }
        return user;

    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql="select * from usertable where username=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,username);
        ResultSet rs=qs.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        //select where
        String sql="select * from usertable where password=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,password);
        ResultSet rs=qs.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql="select * from usertable where email=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,email);
        ResultSet rs=qs.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql="select * from usertable where gender=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1,gender);
        ResultSet rs=qs.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql="select * from usertable where birthdate=?";
        PreparedStatement qs=con.prepareStatement(sql);
        qs.setString(1, String.valueOf(birthDate));
        ResultSet rs=qs.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql="Select * from usertable where username = ? and password = ?";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        List<User> list=new ArrayList<User>();
        User user=null;
        if (rs.next()){
            user=new User();
            user.setId(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthDate(rs.getString("birthdate"));
            list.add(user);
        }
        return list;

    }
}
