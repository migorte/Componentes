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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "FACTURA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f"),
    @NamedQuery(name = "Factura.findByNumerofactura", query = "SELECT f FROM Factura f WHERE f.numerofactura = :numerofactura"),
    @NamedQuery(name = "Factura.findByFechaemision", query = "SELECT f FROM Factura f WHERE f.fechaemision = :fechaemision"),
    @NamedQuery(name = "Factura.findByImporte", query = "SELECT f FROM Factura f WHERE f.importe = :importe"),
    @NamedQuery(name = "Factura.findByFechapago", query = "SELECT f FROM Factura f WHERE f.fechapago = :fechapago"),
    @NamedQuery(name = "Factura.findByIdextractobancario", query = "SELECT f FROM Factura f WHERE f.idextractobancario = :idextractobancario")})
public class Factura implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMEROFACTURA")
    private Integer numerofactura;
    @Column(name = "FECHAEMISION")
    @Temporal(TemporalType.DATE)
    private Date fechaemision;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMPORTE")
    private Float importe;
    @Column(name = "FECHAPAGO")
    @Temporal(TemporalType.DATE)
    private Date fechapago;
    @Column(name = "IDEXTRACTOBANCARIO")
    private String idextractobancario;
    @JoinColumn(name = "ESTADO", referencedColumnName = "CLAVE")
    @ManyToOne
    private Estadofactura estado;

    public Factura() {
    }

    public Factura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public Integer getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public Date getFechaemision() {
        return fechaemision;
    }

    public void setFechaemision(Date fechaemision) {
        this.fechaemision = fechaemision;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Date getFechapago() {
        return fechapago;
    }

    public void setFechapago(Date fechapago) {
        this.fechapago = fechapago;
    }

    public String getIdextractobancario() {
        return idextractobancario;
    }

    public void setIdextractobancario(String idextractobancario) {
        this.idextractobancario = idextractobancario;
    }

    public Estadofactura getEstado() {
        return estado;
    }

    public void setEstado(Estadofactura estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numerofactura != null ? numerofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.numerofactura == null && other.numerofactura != null) || (this.numerofactura != null && !this.numerofactura.equals(other.numerofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Factura[ numerofactura=" + numerofactura + " ]";
    }
    
}
