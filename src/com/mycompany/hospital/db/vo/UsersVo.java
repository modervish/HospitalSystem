
package com.mycompany.hospital.db.vo;

import com.mycompany.hospital.db.type.UsersType;

public class UsersVo {
    private int id;
    private String userName ;
    private String password;
    private UsersType usersType;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the usersType
     */
    public UsersType getUsersType() {
        return usersType;
    }

    /**
     * @param usersType the usersType to set
     */
    public void setUsersType(UsersType usersType) {
        this.usersType = usersType;
    }
}
