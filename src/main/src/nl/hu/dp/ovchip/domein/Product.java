package nl.hu.dp.ovchip.domein;

import nl.hu.dp.ovchip.domein.OV_Chipkaart;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {
    @Id
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private double prijs;
    @ManyToMany
    @JoinTable(
            name = "ov_chipkaart_product",
            joinColumns = {@JoinColumn(name = "product_nummer")},
            inverseJoinColumns = {@JoinColumn(name = "kaart_nummer")}
    )
    private List<OV_Chipkaart> ovChipkaart;

    public Product(int product_nummer, String naam, String beschrijving, double prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
        ovChipkaart = new ArrayList<>();
    }

    public Product() {
    }

    public void addOvChipkaart(OV_Chipkaart ovChipkaart) {
        this.ovChipkaart.add(ovChipkaart);
        ovChipkaart.getProduct().add(this);
    }

    public void removeOvChipkaart(OV_Chipkaart ovChipkaart) {
        this.ovChipkaart.remove(ovChipkaart);
        ovChipkaart.getProduct().remove(this);
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    public List<OV_Chipkaart> getOVChipkaarten() {
        return ovChipkaart;
    }

    public void setOvChipkaart(List<OV_Chipkaart> ovChipkaart) {
        this.ovChipkaart = ovChipkaart;
    }

    @Override
    public String toString() {
        String string = "";
        for(OV_Chipkaart ov_chipkaart : ovChipkaart) {
            string += ov_chipkaart.getKaart_nummer() + ", ";
        }

        return "Product: " +
                product_nummer + ", '" +
                naam + ", " +
                beschrijving +
                ", €" + prijs + ", OV_Chipkaart(en) = " + string;
    }

}