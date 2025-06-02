/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.listajogo;
import util.conectadb;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;
import model.listajogo;
import model.jogo;
/**
 *
 * @author alunocmc
 */
public class lista_jogo_dao {
    // Zero Atrib.
    
    // Métodos - CRUD
    public boolean inserir (listajogo p_jogo) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
            //String sql = "Insert into cliente (codigo, nome, renda, nasc) values(987654, 'José da Silva', 9500, '1981/03/22')";
            String sql = "Insert into lista_usuario (pk_lista, status, progresso, nota, data_inicio, data_fim) values(" + p_jogo.getPk_lista() + ", '" + 
                                                                                     p_jogo.getStatus()+ "', " + 
                                                                                     p_jogo.getProgresso()+ ", '" + 
                                                                                     p_jogo.getNota()+ "', '" + 
                                                                                     new SimpleDateFormat("dd/MM/yyyy").format(p_jogo.getDtinicio())+", '"+ new SimpleDateFormat("dd/MM/yyyy").format(p_jogo.getDtfim())+"' )";
                                                                                            // SimpleDateFormat("dd/MM/yyyy").format(func.getDtInicio())
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    //Consultas
    public List consultar_lista_jogo() throws ClassNotFoundException, ParseException{
        List lista = new ArrayList();
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente";
            String sql = "SELECT * FROM cliente";
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               listajogo list = new listajogo();
               jogo nomejogo = new jogo();
               list.setPk_lista(Integer.parseInt( rs.getString("pk_lista")));
               nomejogo.setNome_jogo(rs.getString("nome"));
               list.setStatus(rs.getString("status"));
               list.setProgresso(rs.getString("progresso") );
               list.setNota(Integer.parseInt(rs.getString("nota")));
               list.setDtinicio(rs.getDate("dtinicio"));
               list.setDtfim(rs.getDate("dtfim"));
               lista.add(list);
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
    
    public listajogo consultar_id(listajogo p_jogo) throws ClassNotFoundException, ParseException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente WHERE pk_id = 7";
            String sql = "SELECT * FROM listajogo WHERE id_jogo = " + p_jogo.getPk_lista()+"ORDER BY nome";
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               p_jogo.setPk_lista(Integer.parseInt( rs.getString("pk_lista") ));
               //nomejogo.setNome_jogo(rs.getString("nome"));
               //p_jogo.setId_jogo(Integer.parseInt( rs.getString("id_jogo") ));
               //p_jogo.setNome(rs.getString("nome") );
               //p_jogo.setRenda(Double.valueOf(rs.getString("renda") ));
               //p_jogo.setNasc( rs.getDate("nasc"));
               n_reg++;
            }
                
            if (n_reg == 0){
                return null;
            }else{
                return p_jogo;
            }            
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);    
            return null;
        }               
    }
    public boolean alterar (listajogo p_list) throws ClassNotFoundException, ParseException{
       //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
          //String sql = "UPDATE cliente SET nome='Amanda de Souza', renda= 7500, nasc='2020/04/20' WHERE codigo = 700";
            String sql = "UPDATE listajogo SET status='" + p_list.getStatus() + "', progresso= " +p_list.getProgresso()+", nota='"+ p_list.getNota()+ ", dtinicio='" + new SimpleDateFormat("yyyy/MM/dd").format(p_list.getDtinicio())+ "', dtfim='" + new SimpleDateFormat("yyyy/MM/dd").format(p_list.getDtfim())+
                                                                          "' WHERE codigo = " + p_list.getPk_lista();                                                                                                                       
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;  
    }
    }
}
    

