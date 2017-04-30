package fv.monster.model;

import java.util.Objects;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;

/**
 *
 * @author fvsaddam - saddamtbg@gmail.com
 */
@Entity
@Table(name = "materi")
public class Materi {

    @GeneratedValue
    @Id
    @Column(name = "id")
    private Long id;

    @Size(min = 3, max = 255)
    @NotNull
    @NotEmpty
    @Column(name = "nama")
    private String nama;

    @Size(min = 3, max = 255)
    @NotNull
    @NotEmpty
    @Column(name = "nomor")
    private String nomor;

    @Size(min = 3)
    @NotNull
    @NotEmpty
    @Column(name = "deskripsi")
    private String deskripsi;

    @Size(min = 3, max = 255)
    @NotNull
    @NotEmpty
    @Column(name = "gambar")
    private String gambar;

    @NotNull
    @Column(name = "harga", nullable = false)
    @DecimalMin(value = "1000.00", message = "Harga harus lebih besar dari Rp 1000")
    @NumberFormat(style = NumberFormat.Style.DEFAULT)
    private BigDecimal harga;

    @Size(min = 3, max = 255)
    @NotNull
    @NotEmpty
    @Column(name = "status")
    private String status;

    @Column(name = "lastupdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastupdate;

    @Column(name = "shareto")
    private String shareto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(Date lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getShareto() {
        return shareto;
    }

    public void setShareto(String shareto) {
        this.shareto = shareto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.nama);
        hash = 47 * hash + Objects.hashCode(this.nomor);
        hash = 47 * hash + Objects.hashCode(this.deskripsi);
        hash = 47 * hash + Objects.hashCode(this.gambar);
        hash = 47 * hash + Objects.hashCode(this.harga);
        hash = 47 * hash + Objects.hashCode(this.status);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Materi)) {
            return false;
        }
        Materi other = (Materi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
}
