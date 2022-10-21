package nl.hu.dp.ovchip.DAO;

import nl.hu.dp.ovchip.domein.OV_Chipkaart;
import nl.hu.dp.ovchip.domein.Reiziger;

import java.sql.SQLException;
import java.util.ArrayList;

public interface OV_ChipkaartDAO {
    boolean save(OV_Chipkaart ov_chipkaart) throws SQLException;
    boolean update(OV_Chipkaart ov_chipkaart) throws SQLException;
    boolean delete(OV_Chipkaart ov_chipkaart) throws SQLException;
    OV_Chipkaart findByReiziger(Reiziger reiziger) throws SQLException;
    OV_Chipkaart findByKaartnummer(int kaart_nummer) throws SQLException;
    ArrayList<OV_Chipkaart> findAll() throws SQLException;

}
