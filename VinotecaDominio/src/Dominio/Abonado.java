/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "ABONADO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Abonado.findAll", query = "SELECT a FROM Abonado a"),
    @NamedQuery(name = "Abonado.findByNumeroabonado", query = "SELECT a FROM Abonado a WHERE a.numeroabonado = :numeroabonado"),
    @NamedQuery(name = "Abonado.findByOpenidref", query = "SELECT a FROM Abonado a WHERE a.openidref = :openidref"),
    @NamedQuery(name = "Abonado.findByLogin", query = "SELECT a FROM Abonado a WHERE a.login = :login"),
    @NamedQuery(name = "Abonado.findByPassword", query = "SELECT a FROM Abonado a WHERE a.password = :password")})
public class Abonado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMEROABONADO")
    private Integer numeroabonado;
    @Basic(optional = false)
    @Column(name = "OPENIDREF")
    private String openidref;
    @Column(name = "LOGIN")
    private String login;
    @Column(name = "PASSWORD")
    private String password;
    @OneToMany(mappedBy = "numeroabonado")
    private Collection<Preferencia> preferenciaCollection;
    @OneToMany(mappedBy = "numeroabonado")
    private Collection<Pedido> pedidoCollection;
    @JoinColumn(name = "NIF", referencedColumnName = "NIF")
    @ManyToOne(optional = false)
    private Persona nif;

    public Abonado() {
    }

    public Abonado(Integer numeroabonado) {
        this.numeroabonado = numeroabonado;
    }

    public Abonado(Integer numeroabonado, String openidref) {
        this.numeroabonado = numeroabonado;
        this.openidref = openidref;
    }

    public Integer getNumeroabonado() {
        return numeroabonado;
    }

    public void setNumeroabonado(Integer numeroabonado) {
        this.numeroabonado = numeroabonado;
    }

    public String getOpenidref() {
        return openidref;
    }

    public void setOpenidref(String openidref) {
        this.openidref = openidref;
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

    @XmlTransient
    public Collection<Preferencia> getPreferenciaCollection() {
        return preferenciaCollection;
    }

    public void setPreferenciaCollection(Collection<Preferencia> preferenciaCollection) {
        this.preferenciaCollection = preferenciaCollection;
    }

    @XmlTransient
    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
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
        hash += (numeroabonado != null ? numeroabonado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Abonado)) {
            return false;
        }
        Abonado other = (Abonado) object;
        if ((this.numeroabonado == null && other.numeroabonado != null) || (this.numeroabonado != null && !this.numeroabonado.equals(other.numeroabonado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Abonado[ numeroabonado=" + numeroabonado + " ]";
    }
    
}
