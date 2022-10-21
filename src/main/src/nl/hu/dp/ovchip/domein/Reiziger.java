package nl.hu.dp.ovchip.domein;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Reiziger {
    @Id
    @Column(name = "reiziger_id") //aangezien id geen id heet maar reiziger_id
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
    @OneToOne(mappedBy = "reiziger") //reiziger_id waarde uit adres
    private Adres adres;
    @OneToMany(mappedBy = "reiziger")
    private List<OV_Chipkaart> ov_chipkaarten;


    public Reiziger(int id, String voorletters, String tussenvoegsel, String achternaam, java.sql.Date geboortedatum){
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        ov_chipkaarten = new ArrayList<>();
    }

    public Reiziger(){

    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;

    }

    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;
    }


    public int getAantalOVchips(){
        return this.ov_chipkaarten.size();
    }


    public String getVoorletters(){
        return voorletters;
    }

    public String getTussenvoegsel(){
        return tussenvoegsel;
    }

    public String getAchternaam(){
        return achternaam;
    }

    public java.sql.Date getGeboortedatum(){
        return geboortedatum;
    }

    public void addChipkaart(OV_Chipkaart ov_chipkaart) {
        boolean toevoegen = true;
        for (OV_Chipkaart ov_chip : ov_chipkaarten){
            if (ov_chipkaart.getKaart_nummer() == ov_chipkaart.getKaart_nummer()){
                toevoegen = false;
                break;
            }
        }
        if (toevoegen){
            this.ov_chipkaarten.add(ov_chipkaart);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Reiziger_Id: " + id + ",  " + voorletters + " ");
        if (tussenvoegsel != null){
            sb.append(tussenvoegsel).append(" ");
        }
        sb.append(achternaam).append(", geboren op: ").append(geboortedatum).append(" ");
        if (adres != null){
            sb.append(", adres_id: ").append(adres);
        }

        return sb.toString();
    }


}
