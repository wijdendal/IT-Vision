package com.Velo.IService;

//import com.Velo.Entite.Personne;

import java.sql.SQLException;
import java.util.List;

public interface IService<T> {

        void ajouter(T t) throws SQLException;
        void ajouter1(T t) throws SQLException;
        void delete(int idd) throws SQLException;
        List<T> readAll() throws SQLException;
        void updateDB(String n, String p ,int a,int id)throws SQLException;







}