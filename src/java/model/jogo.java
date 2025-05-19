/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.Date;
/**
 *
 * @author sofia
 */
public class jogo {
    private int pkjogo;
    private String nome_jogo;
    private String descricao;
    private Date dt_lancamento;
    private String genero;

    public jogo(int pkjogo, String nome, String descricao, Date dt_lancamento, String genero) {
        this.pkjogo = pkjogo;
        this.nome_jogo = nome;
        this.descricao = descricao;
        this.dt_lancamento = dt_lancamento;
        this.genero = genero;
    }

    public jogo() {
    }

    public int getPkjogo() {
        return pkjogo;
    }

    public String getNome_jogo() {
        return nome_jogo;
    }

    public String getDescricao() {
        return descricao;
    }

    public Date getDt_lancamento() {
        return dt_lancamento;
    }

    public String getGenero() {
        return genero;
    }

    public void setPkjogo(int pkjogo) {
        this.pkjogo = pkjogo;
    }

    public void setNome_jogo(String nome) {
        this.nome_jogo = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDt_lancamento(Date dt_lancamento) {
        this.dt_lancamento = dt_lancamento;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
