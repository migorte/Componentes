/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "PEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
    @NamedQuery(name = "Pedido.findByNumero", query = "SELECT p FROM Pedido p WHERE p.numero = :numero"),
    @NamedQuery(name = "Pedido.findByFecharealizacion", query = "SELECT p FROM Pedido p WHERE p.fecharealizacion = :fecharealizacion"),
    @NamedQuery(name = "Pedido.findByNotaentrega", query = "SELECT p FROM Pedido p WHERE p.notaentrega = :notaentrega"),
    @NamedQuery(name = "Pedido.findByImporte", query = "SELECT p FROM Pedido p WHERE p.importe = :importe"),
    @NamedQuery(name = "Pedido.findByFecharecepcion", query = "SELECT p FROM Pedido p WHERE p.fecharecepcion = :fecharecepcion"),
    @NamedQuery(name = "Pedido.findByFechaentrega", query = "SELECT p FROM Pedido p WHERE p.fechaentrega = :fechaentrega")})
public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUMERO")
    private Integer numero;
    @Column(name = "FECHAREALIZACION")
    @Temporal(TemporalType.DATE)
    private Date fecharealizacion;
    @Column(name = "NOTAENTREGA")
    private String notaentrega;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "IMPORTE")
    private Float importe;
    @Column(name = "FECHARECEPCION")
    @Temporal(TemporalType.DATE)
    private Date fecharecepcion;
    @Column(name = "FECHAENTREGA")
    @Temporal(TemporalType.DATE)
    private Date fechaentrega;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numeropedido")
    private Collection<Lineapedido> lineapedidoCollection;
    @JoinColumn(name = "NUMEROABONADO", referencedColumnName = "NUMEROABONADO")
    @ManyToOne
    private Abonado numeroabonado;
    @JoinColumn(name = "ESTADO", referencedColumnName = "CLAVE")
    @ManyToOne(optional = false)
    private Estadopedido estado;
    @JoinColumn(name = "NUMEROFACTURA", referencedColumnName = "NUMEROFACTURA")
    @ManyToOne
    private Factura numerofactura;

    public Pedido() {
    }

    public Pedido(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getFecharealizacion() {
        return fecharealizacion;
    }

    public void setFecharealizacion(Date fecharealizacion) {
        this.fecharealizacion = fecharealizacion;
    }

    public String getNotaentrega() {
        return notaentrega;
    }

    public void setNotaentrega(String notaentrega) {
        this.notaentrega = notaentrega;
    }

    public Float getImporte() {
        return importe;
    }

    public void setImporte(Float importe) {
        this.importe = importe;
    }

    public Date getFecharecepcion() {
        return fecharecepcion;
    }

    public void setFecharecepcion(Date fecharecepcion) {
        this.fecharecepcion = fecharecepcion;
    }

    public Date getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(Date fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    @XmlTransient
    public Collection<Lineapedido> getLineapedidoCollection() {
        return lineapedidoCollection;
    }

    public void setLineapedidoCollection(Collection<Lineapedido> lineapedidoCollection) {
        this.lineapedidoCollection = lineapedidoCollection;
    }

    public Abonado getNumeroabonado() {
        return numeroabonado;
    }

    public void setNumeroabonado(Abonado numeroabonado) {
        this.numeroabonado = numeroabonado;
    }

    public Estadopedido getEstado() {
        return estado;
    }

    public void setEstado(Estadopedido estado) {
        this.estado = estado;
    }

    public Factura getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(Factura numerofactura) {
        this.numerofactura = numerofactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numero != null ? numero.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.numero == null && other.numero != null) || (this.numero != null && !this.numero.equals(other.numero))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Pedido[ numero=" + numero + " ]";
    }
    
}
