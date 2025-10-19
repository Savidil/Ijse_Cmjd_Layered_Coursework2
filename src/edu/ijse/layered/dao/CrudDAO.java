/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.ijse.layered.dao;

/**
 *
 * @author ASUS
 */

import java.util.ArrayList;

public interface CrudDAO<T, ID> {
    boolean save(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(ID id) throws Exception;
    T find(ID id) throws Exception;
    ArrayList<T> getAll() throws Exception;
}
