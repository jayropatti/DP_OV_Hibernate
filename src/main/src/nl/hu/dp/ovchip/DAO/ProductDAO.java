package nl.hu.dp.ovchip.DAO;

import nl.hu.dp.ovchip.domein.OV_Chipkaart;
import nl.hu.dp.ovchip.domein.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDAO {
    boolean save(Product product) throws SQLException;

    boolean update(Product product);

    boolean delete(Product product);

    List<Product> findByOVChipkaart(OV_Chipkaart ov_chipkaart);

    List<Product>  findAll();

}
