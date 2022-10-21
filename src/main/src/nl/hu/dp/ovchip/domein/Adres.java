package nl.hu.dp.ovchip.domein;

import javax.persistence.*;

@Entity
public class Adres {
    @Id
    public int adres_id;
    public String postcode;
    public String huisnummer;
    public String straat;
    public String woonplaats;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reiziger_id")
    public Reiziger reiziger;

    public Adres(int adres_id, String postcode, String huisnummer, String straat, String woonplaats, Reiziger reiziger){
        this.adres_id = adres_id;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.straat = straat;
        this.woonplaats = woonplaats;
        this.reiziger = reiziger;
        reiziger.setAdres(this);

    }

    public Adres() {

    }

    public void setAdres_id(int adres_id) {
        this.adres_id = adres_id;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }



    public int getAdres_id(){
        return adres_id;
    }

    public String getPostcode(){
        return postcode;
    }

    public String getHuisnummer(){
        return huisnummer;
    }

    public String getStraat(){
        return straat;
    }

    public String getWoonplaats(){
        return woonplaats;
    }

    public Reiziger getReiziger(){
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
        reiziger.setAdres(this);
    }

    public String toString(){
        return "Adres_id: " + adres_id + ", " + postcode + ", " + straat + " " + huisnummer + ", " + woonplaats + " reiziger_id: " + reiziger.getId();
    }



}

