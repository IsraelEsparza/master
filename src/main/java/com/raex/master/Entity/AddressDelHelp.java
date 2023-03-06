package com.raex.master.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tb_address_delhelp")
public class AddressDelHelp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "id_user")
    @ManyToOne(fetch = FetchType.EAGER)
    private User idUser;
    @Column(name = "number_address")
    private String numberAddress;
    @Column(name = "name_address")
    private String nameAddress;
    @Column(name = "observations")
    private String observations;
    @Column(name = "creation_date")
    private Date creationDate;
    @Column(name = "update_date")
    private Date updateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public String getNumberAddress() {
        return numberAddress;
    }

    public void setNumberAddress(String numberAddress) {
        this.numberAddress = numberAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
