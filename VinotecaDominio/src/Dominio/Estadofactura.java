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
import javax.persistence.Id;
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
@Table(name = "ESTADOFACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estadofactura.findAll", query = "SELECT e FROM Estadofactura e"),
    @NamedQuery(name = "Estadofactura.findByClave", query = "SELECT e FROM Estadofactura e WHERE e.clave = :clave"),
    @NamedQuery(name = "Estadofactura.findByNombre", query = "SELECT e FROM Estadofactura e WHERE e.nombre = :nombre")})
public class Estadofactura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CLAVE")
    private String clave;
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "estado")
    private Collection<Factura> facturaCollection;

    public Estadofactura() {
    }

    public Estadofactura(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estadofactura)) {
            return false;
        }
        Estadofactura other = (Estadofactura) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Estadofactura[ clave=" + clave + " ]";
    }
    
}
