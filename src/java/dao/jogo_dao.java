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
import model.jogo;
import util.conectadb;
/**
 *
 * @author alunocmc
 */
public class jogo_dao {
    public boolean inserir (jogo p_jogo) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
            //String sql = "Insert into cliente (codigo, nome, renda, nasc) values(987654, 'José da Silva', 9500, '1981/03/22')";
            String sql = "Insert into jogo ( nome, descricao, data_lancamento, genero, id_desenvolvedora) values('" + 
                                                                                     p_jogo.getNome_jogo() + "', '" + 
                                                                                    p_jogo.getDescricao() + "', '"+ new SimpleDateFormat("yyyy/MM/dd").format(p_jogo.getDt_lancamento())+"', '"+ p_jogo.getGenero()+ "', "+ p_jogo.getId_desenvolvedora()+")";
                                                                                            // SimpleDateFormat("dd/MM/yyyy").format(func.getNasc())
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    
    //Consultas
    public List consultar_lista_simples() throws ClassNotFoundException, ParseException{
        List lista = new ArrayList();
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT jogo.pk_jogo, jogo.nome, jogo.descricao, jogo.data_lancamento, jogo.genero, desenvolvedora.nome AS nome_desenvolvedora FROM jogo JOIN desenvolvedora ON jogo.id_desenvolvedora = desenvolvedora.pk_dev;";
            String sql = "SELECT jogo.pk_jogo, jogo.nome, jogo.descricao, jogo.data_lancamento, jogo.genero, desenvolvedora.nome AS nome_desenvolvedora "
                    + "FROM jogo JOIN desenvolvedora ON jogo.id_desenvolvedora = desenvolvedora.pk_dev";
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               jogo game = new jogo();
               game.setPkjogo(Integer.parseInt(rs.getString("pk_jogo")));
               game.setNome_jogo(rs.getString("nome"));
               game.setDescricao(rs.getString("descricao") );
               game.setDt_lancamento(rs.getDate("data_lancamento"));
               game.setGenero(rs.getString("genero"));
               game.setNome_desenvolvedora(rs.getString("nome_desenvolvedora"));
               lista.add(game);
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

    
    public jogo consultar_id(jogo p_jogo) throws ClassNotFoundException, ParseException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente WHERE pk_id = 7";
            String sql = "SELECT jogo.pk_jogo, jogo.nome, jogo.descricao, jogo.data_lancamento, jogo.genero, desenvolvedora.nome AS nome_desenvolvedora FROM jogo JOIN desenvolvedora ON jogo.id_desenvolvedora = desenvolvedora.pk_dev;";
            
            ResultSet rs = stmt.executeQuery(sql); // Select

            int n_reg = 0;
            while (rs.next()){
               p_jogo.setPkjogo( Integer.parseInt( rs.getString("codigo") ));
               p_jogo.setNome_jogo(rs.getString("nome") );
               p_jogo.setDescricao(rs.getString("descricao") );
               p_jogo.setDt_lancamento( rs.getDate("lancamento"));
               p_jogo.setGenero(rs.getString("genero"));
               p_jogo.setNome_desenvolvedora(rs.getString("nome_desenvolvedora"));
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
    
    //excluir_id
    public boolean excluir_id(jogo p_jogo) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();            
            String sql = "DELETE from jogo WHERE pk_jogo = " + p_jogo.getPkjogo();          
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    
    //alterar
    public boolean alterar(jogo p_jogo) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
          //String sql = "UPDATE cliente SET nome='Amanda de Souza', renda= 7500, nasc='2020/04/20' WHERE codigo = 700";
            String sql = "UPDATE jogo SET nome='" + p_jogo.getNome_jogo() + "', descricao= " +p_jogo.getDescricao()+ ", dt_lancamento='" + new SimpleDateFormat("yyyy/MM/dd").format(p_jogo.getDt_lancamento())+ "genero="+ p_jogo.getGenero()+ 
                                                                          "' WHERE codigo = " + p_jogo.getPkjogo();                                                                                                                       
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }

}
