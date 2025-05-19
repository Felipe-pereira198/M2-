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
public class listajogo {
    private int pk_lista;
    private String status;
    private String progresso;
    private int nota;
    private Date dtinicio;
    private Date dtfim;

    public listajogo() {
    }

    public listajogo(int pk_lista, String status, String progresso, int nota, Date dtinicio, Date dtfim) {
        this.pk_lista = pk_lista;
        this.status = status;
        this.progresso = progresso;
        this.nota = nota;
        this.dtinicio = dtinicio;
        this.dtfim = dtfim;
    }

    public int getPk_lista() {
        return pk_lista;
    }

    public String getStatus() {
        return status;
    }

    public String getProgresso() {
        return progresso;
    }

    public int getNota() {
        return nota;
    }

    public Date getDtinicio() {
        return dtinicio;
    }

    public Date getDtfim() {
        return dtfim;
    }

    public void setPk_lista(int pk_lista) {
        this.pk_lista = pk_lista;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setProgresso(String progresso) {
        this.progresso = progresso;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public void setDtinicio(Date dtinicio) {
        this.dtinicio = dtinicio;
    }

    public void setDtfim(Date dtfim) {
        this.dtfim = dtfim;
    }
    
}
