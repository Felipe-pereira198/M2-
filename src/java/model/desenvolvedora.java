/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sofia
 */
public class desenvolvedora {
    private int pkdev;
    private String nomedev;
    private String pais;

    public desenvolvedora() {
    }

    public desenvolvedora(int pkdev, String nomedev, String pais) {
        this.pkdev = pkdev;
        this.nomedev = nomedev;
        this.pais = pais;
    }

    public int getPkdev() {
        return pkdev;
    }

    public String getNomedev() {
        return nomedev;
    }

    public String getPais() {
        return pais;
    }

    public void setPkdev(int pkdev) {
        this.pkdev = pkdev;
    }

    public void setNomedev(String nomedev) {
        this.nomedev = nomedev;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
