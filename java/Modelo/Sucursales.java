/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author FRANCO
 */
@Entity
@Table(name = "sucursales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sucursales.findAll", query = "SELECT s FROM Sucursales s")
    , @NamedQuery(name = "Sucursales.findById", query = "SELECT s FROM Sucursales s WHERE s.id = :id")
    , @NamedQuery(name = "Sucursales.findByNombre", query = "SELECT s FROM Sucursales s WHERE s.nombre = :nombre")
    , @NamedQuery(name = "Sucursales.findByUbicacion", query = "SELECT s FROM Sucursales s WHERE s.ubicacion = :ubicacion")
    , @NamedQuery(name = "Sucursales.findByDireccion", query = "SELECT s FROM Sucursales s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Sucursales.findByEncargado", query = "SELECT s FROM Sucursales s WHERE s.encargado = :encargado")
    , @NamedQuery(name = "Sucursales.findByDimension", query = "SELECT s FROM Sucursales s WHERE s.dimension = :dimension")
    , @NamedQuery(name = "Sucursales.findByCiudad", query = "SELECT s FROM Sucursales s WHERE s.ciudad = :ciudad")})
public class Sucursales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 45)
    @Column(name = "encargado")
    private String encargado;
    @Size(max = 45)
    @Column(name = "dimension")
    private String dimension;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;

    public Sucursales() {
    }

    public Sucursales(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Sucursales(Integer id, String nombre, String ubicacion, String direccion, String encargado, String dimension, String ciudad) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.direccion = direccion;
        this.encargado = encargado;
        this.dimension = dimension;
        this.ciudad = ciudad;
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
        if (!(object instanceof Sucursales)) {
            return false;
        }
        Sucursales other = (Sucursales) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Modelo.Sucursales[ id=" + id + " ]";
    }
    
}
