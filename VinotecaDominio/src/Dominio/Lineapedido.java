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
@Table(name = "LINEAPEDIDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lineapedido.findAll", query = "SELECT l FROM Lineapedido l"),
    @NamedQuery(name = "Lineapedido.findById", query = "SELECT l FROM Lineapedido l WHERE l.id = :id"),
    @NamedQuery(name = "Lineapedido.findByUnidades", query = "SELECT l FROM Lineapedido l WHERE l.unidades = :unidades"),
    @NamedQuery(name = "Lineapedido.findByCompletada", query = "SELECT l FROM Lineapedido l WHERE l.completada = :completada")})
public class Lineapedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "UNIDADES")
    private Integer unidades;
    @Column(name = "COMPLETADA")
    private Character completada;
    @JoinColumn(name = "IDLINEACOMPRA", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Lineacompra idlineacompra;
    @JoinColumn(name = "NUMEROPEDIDO", referencedColumnName = "NUMERO")
    @ManyToOne(optional = false)
    private Pedido numeropedido;
    @JoinColumn(name = "CODIGOREFERENCIA", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false)
    private Referencia codigoreferencia;

    public Lineapedido() {
    }

    public Lineapedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnidades() {
        return unidades;
    }

    public void setUnidades(Integer unidades) {
        this.unidades = unidades;
    }

    public Character getCompletada() {
        return completada;
    }

    public void setCompletada(Character completada) {
        this.completada = completada;
    }

    public Lineacompra getIdlineacompra() {
        return idlineacompra;
    }

    public void setIdlineacompra(Lineacompra idlineacompra) {
        this.idlineacompra = idlineacompra;
    }

    public Pedido getNumeropedido() {
        return numeropedido;
    }

    public void setNumeropedido(Pedido numeropedido) {
        this.numeropedido = numeropedido;
    }

    public Referencia getCodigoreferencia() {
        return codigoreferencia;
    }

    public void setCodigoreferencia(Referencia codigoreferencia) {
        this.codigoreferencia = codigoreferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lineapedido)) {
            return false;
        }
        Lineapedido other = (Lineapedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Lineapedido[ id=" + id + " ]";
    }
    
}
