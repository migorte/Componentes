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
@Table(name = "VINO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vino.findAll", query = "SELECT v FROM Vino v"),
    @NamedQuery(name = "Vino.findById", query = "SELECT v FROM Vino v WHERE v.id = :id"),
    @NamedQuery(name = "Vino.findByNombrecomercial", query = "SELECT v FROM Vino v WHERE v.nombrecomercial = :nombrecomercial"),
    @NamedQuery(name = "Vino.findByAnyo", query = "SELECT v FROM Vino v WHERE v.anyo = :anyo"),
    @NamedQuery(name = "Vino.findByComentario", query = "SELECT v FROM Vino v WHERE v.comentario = :comentario"),
    @NamedQuery(name = "Vino.findByDenominacion", query = "SELECT v FROM Vino v WHERE v.denominacion = :denominacion"),
    @NamedQuery(name = "Vino.findByCategoria", query = "SELECT v FROM Vino v WHERE v.categoria = :categoria"),
    @NamedQuery(name = "Vino.findByCategoriaAndDenominacion", query = "SELECT v FROM Vino v WHERE v.categoria = :categoria AND v.denominacion = :denominacion")})
public class Vino implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "NOMBRECOMERCIAL")
    private String nombrecomercial;
    @Column(name = "ANYO")
    private Short anyo;
    @Column(name = "COMENTARIO")
    private String comentario;
    @Column(name = "DENOMINACION")
    private String denominacion;
    @Column(name = "CATEGORIA")
    private String categoria;
    @OneToMany(mappedBy = "vinoid")
    private Collection<Referencia> referenciaCollection;
    @JoinColumn(name = "IDBODEGA", referencedColumnName = "ID")
    @ManyToOne
    private Bodega idbodega;

    public Vino() {
    }

    public Vino(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombrecomercial() {
        return nombrecomercial;
    }

    public void setNombrecomercial(String nombrecomercial) {
        this.nombrecomercial = nombrecomercial;
    }

    public Short getAnyo() {
        return anyo;
    }

    public void setAnyo(Short anyo) {
        this.anyo = anyo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

    @XmlTransient
    public Collection<Referencia> getReferenciaCollection() {
        return referenciaCollection;
    }

    public void setReferenciaCollection(Collection<Referencia> referenciaCollection) {
        this.referenciaCollection = referenciaCollection;
    }

    public Bodega getIdbodega() {
        return idbodega;
    }

    public void setIdbodega(Bodega idbodega) {
        this.idbodega = idbodega;
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
        if (!(object instanceof Vino)) {
            return false;
        }
        Vino other = (Vino) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Dominio.Vino[ id=" + id + " ]";
    }

}
