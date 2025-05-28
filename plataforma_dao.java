
package dao;

import model.plataforma;
import util.conectadb;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;

public class plataforma_dao {
    // Métodos - CRUD;
    
    public List consultar_jogos () throws ClassNotFoundException, ParseException{
        List lista = new ArrayList();
        
        Connection conexao = null;
        // Conectar;
        try{
            conexao = conectadb.conectar();
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM plataforma";
            String sql = "SELECT * FROM plataforma";
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               plataforma plataforma = new plataforma();
               plataforma.setNome_plataforma(rs.getString("nome"));
               plataforma.setDono(rs.getString("dono"));
               n_reg++;
               
            }
            
            if (n_reg == 0){
                return null;
            }else{
                return lista;
            }
            
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);    
            return null;
        } 
    }
    
    public plataforma consultar_id(plataforma p_plat) throws ClassNotFoundException, ParseException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente WHERE pk_id = 7";
            String sql = "SELECT * FROM plataforma WHERE pk_plataforma = " + p_plat.getPk_plataforma();
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               p_plat.setNome_plataforma(rs.getString("nome"));
               p_plat.setDono(rs.getString("dono") );
               p_plat.setPk_plataforma(Integer.parseInt(rs.getString("pk_plataforma")));
               n_reg++;
            }
                
            if (n_reg == 0){
                return null;
            }else{
                return p_plat;
            }            
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);    
            return null;
        }
    }
}
