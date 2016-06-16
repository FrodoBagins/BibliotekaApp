/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biblioteka.model;

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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kamil_2
 */
@Entity
@Table(name = "uzytkownik_wypozycenia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UzytkownikWypozycenia.findAll", query = "SELECT u FROM UzytkownikWypozycenia u"),
    @NamedQuery(name = "UzytkownikWypozycenia.findById", query = "SELECT u FROM UzytkownikWypozycenia u WHERE u.id = :id"),
    @NamedQuery(name = "UzytkownikWypozycenia.findByIdUzytkownika", query = "SELECT u FROM UzytkownikWypozycenia u WHERE u.idUzytkownika = :idUzytkownika"),
    @NamedQuery(name = "UzytkownikWypozycenia.findByIdKsiazki", query = "SELECT u FROM UzytkownikWypozycenia u WHERE u.idKsiazki = :idKsiazki"),
    @NamedQuery(name = "UzytkownikWypozycenia.findByDataWypozyczenia", query = "SELECT u FROM UzytkownikWypozycenia u WHERE u.dataWypozyczenia = :dataWypozyczenia")})
public class UzytkownikWypozycenia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_uzytkownika")
    private int idUzytkownika;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ksiazki")
    private int idKsiazki;
    @Column(name = "data_wypozyczenia")
    @Temporal(TemporalType.DATE)
    private Date dataWypozyczenia;
    @JoinColumn(name = "ksiazki_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ksiazki ksiazkiId;
    @JoinColumn(name = "uzytkownik_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Uzytkownik uzytkownikId;

    public UzytkownikWypozycenia() {
    }

    public UzytkownikWypozycenia(Integer id) {
        this.id = id;
    }

    public UzytkownikWypozycenia(Integer id, int idUzytkownika, int idKsiazki) {
        this.id = id;
        this.idUzytkownika = idUzytkownika;
        this.idKsiazki = idKsiazki;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(int idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public int getIdKsiazki() {
        return idKsiazki;
    }

    public void setIdKsiazki(int idKsiazki) {
        this.idKsiazki = idKsiazki;
    }

    public Date getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(Date dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public Ksiazki getKsiazkiId() {
        return ksiazkiId;
    }

    public void setKsiazkiId(Ksiazki ksiazkiId) {
        this.ksiazkiId = ksiazkiId;
    }

    public Uzytkownik getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Uzytkownik uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
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
        if (!(object instanceof UzytkownikWypozycenia)) {
            return false;
        }
        UzytkownikWypozycenia other = (UzytkownikWypozycenia) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "biblioteka.model.UzytkownikWypozycenia[ id=" + id + " ]";
    }
    
}
