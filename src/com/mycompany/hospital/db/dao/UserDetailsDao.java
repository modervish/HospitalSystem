
package com.mycompany.hospital.db.dao;

import com.mycompany.hospital.db.vo.UserDetailsVo;
import java.sql.Connection;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author LORD
 */
public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo>{
   private static UserDetailsDao     userDetailsDao;
   private UserDetailsDao(){
   
   
   }
    public static UserDetailsDao getInstance() {
        if (userDetailsDao==null) {
            userDetailsDao=new UserDetailsDao();
        }
        return userDetailsDao;
    }
    
    
    
    
    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception {
         Connection con=null;
         PreparedStatement ps=null;
         int count=0;
         
         try {
            con=getConnection();
            con.setAutoCommit(false);
            String userSql ="INSERT INTO users(USER_NAME,PASSWORD,USER_TYPE,ID)VALUES(?,?,?,?)";
            ps=con.prepareStatement(userSql);
                
            ps.setString(1, udv.getUserVo().getUserName());
            ps.setString(2, udv.getUserVo().getPassword());
            ps.setInt(3, udv.getUserVo().getUsersType().getId());
            ps.setInt(4, udv.getUserVo().getId());
            ps.executeUpdate();
            
            String userDetailsSql="INSERT INTO users_details(USER_ID ,FIRST_NAME,FATHER_NAME,MOBILE) VALUES(?,?,?,?)";
            ps =con.prepareStatement(userDetailsSql);
            ps.setInt(1, udv.getUserVo().getId());
            ps.setString(2,udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4 ,udv.getMobile());
            ps.executeUpdate();  
            con.commit();
            count=1;
        } catch (Exception ex) {
            con.rollback();
        } finally {
             closeConnection(con);
                ps.close();
        }
         return count;
    }

    @Override
    public int update(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(UserDetailsVo udv) throws Exception {
         Connection con=null;
         PreparedStatement ps=null;
         int count=0;
         
         try {
            con=getConnection();
            con.setAutoCommit(false);
            String UserDetailsSql="DELETE FROM users_details WHERE USER_ID =?";
            ps =con.prepareStatement(UserDetailsSql);
            ps.setInt(1, udv.getUserVo().getId());
            ps.executeUpdate();  
            
            String userSql ="DELETE FROM USERS WHERE ID =?";
            ps=con.prepareStatement(userSql);
            ps.setInt(1, udv.getUserVo().getId());
            ps.executeUpdate();
          
            con.commit();
            count=1;
        } catch (Exception ex) {
            con.rollback();
        } finally { 
             ps.close( );
             closeConnection(con);
              
        }
         return count;




    }

    @Override
    public UserDetailsVo getDate(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
