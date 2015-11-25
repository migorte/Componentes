/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "EMPLEADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empleado.findAll", query = "SELECT e FROM Empleado e"),
    @NamedQuery(name = "Empleado.findByLogin", query = "SELECT e FROM Empleado e WHERE e.login = :login"),
    @NamedQuery(name = "Empleado.findByPassword", query = "SELECT e FROM Empleado e WHERE e.password = :password"),
    @NamedQuery(name = "Empleado.findByFechainicio", query = "SELECT e FROM Empleado e WHERE e.fechainicio = :fechainicio"),
    @NamedQuery(name = "Empleado.findByPagada", query = "SELECT e FROM Empleado e WHERE e.pagada = :pagada")})
public class Empleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Column(name = "PAGADA")
    private Character pagada;
    @JoinColumn(name = "NIF", referencedColumnName = "NIF")
    @ManyToOne(optional = false)
    private Persona nif;

    public Empleado() {
    }

    public Empleado(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Character getPagada() {
        return pagada;
    }

    public void setPagada(Character pagada) {
        this.pagada = pagada;
    }

    public Persona getNif() {
        return nif;
    }

    public void setNif(Persona nif) {
        this.nif = nif;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (login != null ? login.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empleado)) {
            return false;
        }
        Empleado other = (Empleado) object;
        if ((this.login == null && other.login != null) || (this.login != null && !this.login.equals(other.login))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Empleado[ login=" + login + " ]";
    }
    
}
