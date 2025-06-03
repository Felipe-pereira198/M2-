/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.desenvolvedora;
import model.jogo;
import util.conectadb;
/**
 *
 * @author USER
 */
public class desenvolvedora_dao {
    public boolean inserir (desenvolvedora p_dev) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
            //String sql = "Insert into cliente (codigo, nome, renda, nasc) values(987654, 'José da Silva', 9500, '1981/03/22')";
            String sql = "Insert into desenvolvedora ( nome, pais) values('" + 
                                                                                     p_dev.getNomedev() + "', '" + 
                                                                                    p_dev.getPais() + "')";
                                                                                          
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    public List lista_simples() throws ClassNotFoundException, ParseException{
        List lista = new ArrayList();
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente";
            String sql = "SELECT * FROM desenvolvedora";
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               desenvolvedora dev = new desenvolvedora();
               dev.setPkdev(Integer.parseInt( rs.getString("pk_dev")));
               dev.setNomedev(rs.getString("nome"));
               dev.setPais(rs.getString("pais") );
               lista.add(dev);
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

}
