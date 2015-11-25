/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "REFERENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Referencia.findAll", query = "SELECT r FROM Referencia r"),
    @NamedQuery(name = "Referencia.findByCodigo", query = "SELECT r FROM Referencia r WHERE r.codigo = :codigo"),
    @NamedQuery(name = "Referencia.findByEsporcajas", query = "SELECT r FROM Referencia r WHERE r.esporcajas = :esporcajas"),
    @NamedQuery(name = "Referencia.findByContenidoencl", query = "SELECT r FROM Referencia r WHERE r.contenidoencl = :contenidoencl"),
    @NamedQuery(name = "Referencia.findByPrecio", query = "SELECT r FROM Referencia r WHERE r.precio = :precio"),
    @NamedQuery(name = "Referencia.findByDisponible", query = "SELECT r FROM Referencia r WHERE r.disponible = :disponible")})
public class Referencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CODIGO")
    private Integer codigo;
    @Column(name = "ESPORCAJAS")
    private Character esporcajas;
    @Column(name = "CONTENIDOENCL")
    private Short contenidoencl;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private Float precio;
    @Column(name = "DISPONIBLE")
    private Character disponible;
    @JoinColumn(name = "VINOID", referencedColumnName = "ID")
    @ManyToOne
    private Vino vinoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoreferencia")
    private Collection<Lineapedido> lineapedidoCollection;

    public Referencia() {
    }

    public Referencia(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Character getEsporcajas() {
        return esporcajas;
    }

    public void setEsporcajas(Character esporcajas) {
        this.esporcajas = esporcajas;
    }

    public Short getContenidoencl() {
        return contenidoencl;
    }

    public void setContenidoencl(Short contenidoencl) {
        this.contenidoencl = contenidoencl;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Character getDisponible() {
        return disponible;
    }

    public void setDisponible(Character disponible) {
        this.disponible = disponible;
    }

    public Vino getVinoid() {
        return vinoid;
    }

    public void setVinoid(Vino vinoid) {
        this.vinoid = vinoid;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Referencia)) {
            return false;
        }
        Referencia other = (Referencia) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Referencia[ codigo=" + codigo + " ]";
    }
    
}
