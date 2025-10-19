package edu.ijse.layered.service;

import java.util.ArrayList;

public interface SuperService<T> {
    boolean save(T dto) throws Exception;
    boolean update(T dto) throws Exception;
    boolean delete(String id) throws Exception;
    T find(String id) throws Exception;
    ArrayList<T> getAll() throws Exception;
}