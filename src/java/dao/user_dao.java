/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import util.conectadb;
import model.usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;

/**
 *
 * @author sofia
 */
public class user_dao {
    public boolean inserir (usuario p_user) throws ClassNotFoundException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement();
            //String sql = "Insert into cliente (codigo, nome, renda, nasc) values(987654, 'José da Silva', 9500, '1981/03/22')";
            String sql = "Insert into usuario ( nome_usuario, senha, email,  dt_nasc) values('" +  
                                                                                     p_user.getNome() + "', '" + 
                                                                                     p_user.getSenha()+ "', '"+
                                                                                    p_user.getEmail() + "', '"+ new SimpleDateFormat("yyyy/MM/dd").format(p_user.getDt_nasc())+"')";
                                                                                            // SimpleDateFormat("dd/MM/yyyy").format(func.getNasc())
            stmt.executeUpdate(sql); // Insert - Update - Delete
            return true;
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);
            return false;
        }               
    }
    public usuario consultar_id(usuario p_user) throws ClassNotFoundException, ParseException{
        //Conectar
        Connection conexao = null;
        try{
            conexao = conectadb.conectar(); //Abre a conexão
            Statement stmt = conexao.createStatement(); //Cria uma instrução
            //String sql = "SELECT * FROM cliente WHERE pk_id = 7";
            String sql = "SELECT * FROM usuario WHERE codigo = " + p_user.getCodigo();
            ResultSet rs = stmt.executeQuery(sql); // Select
            
            int n_reg = 0;
            while (rs.next()){
               p_user.setCodigo( Integer.parseInt( rs.getString("codigo") ));
               p_user.setNome(rs.getString("nome") );
               p_user.setEmail(rs.getString("renda") );
               p_user.setSenha(rs.getString("senha"));
               p_user.setDt_nasc( rs.getDate("nasc"));
               n_reg++;
            }
                
            if (n_reg == 0){
                return null;
            }else{
                return p_user;
            }            
        }
        catch(SQLException ex){
            System.out.println("Erro SQL: " + ex);    
            return null;
        }               
    }
   public usuario logar(usuario p_user) throws ClassNotFoundException, ParseException {
       System.out.println("Consultando no banco com email: '" + p_user.getEmail() + "' e senha: '" + p_user.getSenha() + "'");

    Connection conexao = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    try {
        conexao = conectadb.conectar(); // Abre a conexão
        String sql = "SELECT * FROM usuario WHERE TRIM(LOWER(email)) = LOWER(?) AND senha = ?";
        stmt = conexao.prepareStatement(sql);
        stmt.setString(1, p_user.getEmail());
        stmt.setString(2, p_user.getSenha());
        System.out.println("🔍 DAO recebeu: email='" + p_user.getEmail() + "', senha='" + p_user.getSenha() + "'");

        rs = stmt.executeQuery(); // <<< aqui, sem passar sql de novo
        if (rs.next()) {
            p_user.setCodigo(rs.getInt("codigo"));
            p_user.setNome(rs.getString("nome_usuario"));
            p_user.setEmail(rs.getString("email"));
            p_user.setSenha(rs.getString("senha"));
            p_user.setDt_nasc(rs.getDate("dt_nasc"));
            return p_user;
        } else {
            return null;
        }
    } catch (SQLException ex) {
        System.out.println("Erro SQL: " + ex);
        return null;
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conexao != null) conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

}
