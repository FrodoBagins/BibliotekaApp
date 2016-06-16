/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.model;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kamil_2
 */
@Entity
@Table(name = "ksiazki")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ksiazki.findAll", query = "SELECT k FROM Ksiazki k"),
    @NamedQuery(name = "Ksiazki.findById", query = "SELECT k FROM Ksiazki k WHERE k.id = :id"),
    @NamedQuery(name = "Ksiazki.findByNazwa", query = "SELECT k FROM Ksiazki k WHERE k.nazwa = :nazwa"),
    @NamedQuery(name = "Ksiazki.findByAutor", query = "SELECT k FROM Ksiazki k WHERE k.autor = :autor"),
    @NamedQuery(name = "Ksiazki.findByIsbn", query = "SELECT k FROM Ksiazki k WHERE k.isbn = :isbn"),
    @NamedQuery(name = "Ksiazki.findByWydawca", query = "SELECT k FROM Ksiazki k WHERE k.wydawca = :wydawca"),
    @NamedQuery(name = "Ksiazki.findByRokWydania", query = "SELECT k FROM Ksiazki k WHERE k.rokWydania = :rokWydania"),
    @NamedQuery(name = "Ksiazki.findByLastUpdate", query = "SELECT k FROM Ksiazki k WHERE k.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Ksiazki.findByStanksiazki", query = "SELECT k FROM Ksiazki k WHERE k.stanksiazki = :stanksiazki")})
public class Ksiazki implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nazwa")
    private String nazwa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "autor")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "wydawca")
    private String wydawca;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rok_wydania")
    private int rokWydania;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.DATE)
    private Date lastUpdate;
    @Column(name = "stanksiazki")
    private Integer stanksiazki;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ksiazkiId")
    private Collection<UzytkownikWypozycenia> uzytkownikWypozyceniaCollection;
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;

    public Ksiazki() {
    }

    public Ksiazki(Integer id) {
        this.id = id;
    }

    public Ksiazki(Integer id, String nazwa, String autor, String isbn, String wydawca, int rokWydania, Date lastUpdate) {
        this.id = id;
        this.nazwa = nazwa;
        this.autor = autor;
        this.isbn = isbn;
        this.wydawca = wydawca;
        this.rokWydania = rokWydania;
        this.lastUpdate = lastUpdate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getWydawca() {
        return wydawca;
    }

    public void setWydawca(String wydawca) {
        this.wydawca = wydawca;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Integer getStanksiazki() {
        return stanksiazki;
    }

    public void setStanksiazki(Integer stanksiazki) {
        this.stanksiazki = stanksiazki;
    }

    @XmlTransient
    public Collection<UzytkownikWypozycenia> getUzytkownikWypozyceniaCollection() {
        return uzytkownikWypozyceniaCollection;
    }

    public void setUzytkownikWypozyceniaCollection(Collection<UzytkownikWypozycenia> uzytkownikWypozyceniaCollection) {
        this.uzytkownikWypozyceniaCollection = uzytkownikWypozyceniaCollection;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
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
        if (!(object instanceof Ksiazki)) {
            return false;
        }
        Ksiazki other = (Ksiazki) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID " + id + " " + autor + " " + nazwa;
    }
    
}
