/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "PREFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Preferencia.findAll", query = "SELECT p FROM Preferencia p"),
    @NamedQuery(name = "Preferencia.findByIdpreferencia", query = "SELECT p FROM Preferencia p WHERE p.idpreferencia = :idpreferencia"),
    @NamedQuery(name = "Preferencia.findByDenominacion", query = "SELECT p FROM Preferencia p WHERE p.denominacion = :denominacion"),
    @NamedQuery(name = "Preferencia.findByCategoria", query = "SELECT p FROM Preferencia p WHERE p.categoria = :categoria")})
public class Preferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPREFERENCIA")
    private Integer idpreferencia;
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Column(name = "CATEGORIA")
    private String categoria;
    @JoinColumn(name = "NUMEROABONADO", referencedColumnName = "NUMEROABONADO")
    @ManyToOne
    private Abonado numeroabonado;

    public Preferencia() {
    }

    public Preferencia(Integer idpreferencia) {
        this.idpreferencia = idpreferencia;
    }

    public Integer getIdpreferencia() {
        return idpreferencia;
    }

    public void setIdpreferencia(Integer idpreferencia) {
        this.idpreferencia = idpreferencia;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Abonado getNumeroabonado() {
        return numeroabonado;
    }

    public void setNumeroabonado(Abonado numeroabonado) {
        this.numeroabonado = numeroabonado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpreferencia != null ? idpreferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Preferencia)) {
            return false;
        }
        Preferencia other = (Preferencia) object;
        if ((this.idpreferencia == null && other.idpreferencia != null) || (this.idpreferencia != null && !this.idpreferencia.equals(other.idpreferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Preferencia[ idpreferencia=" + idpreferencia + " ]";
    }
    
}
