
package com.mycompany.hospital.db.dao;

import java.util.List;

public interface DaoList<T> {
    public List<T>LoadAll()throws Exception;
    public int insert(T t)throws Exception;
    public int update(T t)throws Exception;
    public int delete(T t)throws Exception;
    public T getDate(T t)throws Exception;
    
    
    
    
}
