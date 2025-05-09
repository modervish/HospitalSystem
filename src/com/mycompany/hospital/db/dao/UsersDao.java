
package com.mycompany.hospital.db.dao;

import java.sql.ResultSet;

import com.mycompany.hospital.db.type.UsersType;
import com.mycompany.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class UsersDao extends Dao implements DaoList<UsersVo>{
    private static UsersDao usersDao;
    private UsersDao(){
        
    }
    public static UsersDao getInstance  () {
        if (usersDao==null) {
            usersDao=new UsersDao();
        }
        return usersDao;
    }

    @Override
    public List<UsersVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(UsersVo uv) throws Exception {
        Connection con =null;
        int count =0;
        try {
            con= getConnection();
            String sql ="INSERT INTO users(USER_NAME,PASSWORD,USER_TYPE,ID)VALUES(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(sql);
                
            ps.setString(1, uv.getUserName());
            ps.setString(2, uv.getPassword());
            ps.setInt(3, uv.getUsersType().getId());
            ps.setInt(4, uv.getId());

            count=  ps.executeUpdate();
            ps.close();
            
        } catch (Exception ex) {
        } finally {
            closeConnection(con);
        }
        return count;
    }

    @Override
    public int update(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UsersVo getDate(UsersVo uv) throws Exception {
        Connection con =null;
        UsersVo usersVo = null;
        ResultSet rs=null;
        
        try { 
            con=getConnection();
            String sql="SELECT * FROM users WHERE USER_NAME='"+uv.getUserName()+"'AND PASSWORD='"+uv.getPassword()+"'";
            PreparedStatement ps=con.prepareCall(sql);
            ps.executeQuery();
            rs=ps.executeQuery();
            while (rs.next()) {
                usersVo=new UsersVo();
                usersVo.setId(rs.getInt("id"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType  usersType=UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);
                
                
            }
            rs.close();
            ps.close();
        } catch (Exception ex) {
            
        }finally{
          
            closeConnection(con);
        }
        
      
            return usersVo;

    }
    
 
}