
package com.mycompany.hospital.db.type;


public enum UsersType {
   ADMIN(1,"admin"),DOCTOR(2,"doctor"),NURSE(3,"nurse");          
    private int id ;
    private String type;
    private UsersType(int id ,String type){
    this.type=type;
    this.id=id;
    
    } 
    public static UsersType getUsersTypeById(int id){
         for (UsersType usersType:UsersType.values()) {
           if (usersType.getId()==id) {
            return usersType;
             } 
        }
         return null;
    }
  
      public static UsersType getUsersTypeByType(String type){
         for (UsersType usersType:UsersType.values()) {
           if (usersType.getType() ==type) {
            return usersType;
             } 
        }
         return null;
       }
     public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
    