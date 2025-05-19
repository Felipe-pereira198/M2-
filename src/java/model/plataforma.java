/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sofia
 */
public class plataforma {
    private int pk_plataforma;
    private String nome_plataforma;
    private String dono;

    public plataforma() {
    }

    public plataforma(int pk_plataforma, String nome_plataforma, String dono) {
        this.pk_plataforma = pk_plataforma;
        this.nome_plataforma = nome_plataforma;
        this.dono = dono;
    }

    public int getPk_plataforma() {
        return pk_plataforma;
    }

    public String getNome_plataforma() {
        return nome_plataforma;
    }

    public String getDono() {
        return dono;
    }

    public void setPk_plataforma(int pk_plataforma) {
        this.pk_plataforma = pk_plataforma;
    }

    public void setNome_plataforma(String nome_plataforma) {
        this.nome_plataforma = nome_plataforma;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }
    
}
