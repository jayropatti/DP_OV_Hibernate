package nl.hu.dp.ovchip.DAO;

import nl.hu.dp.ovchip.domein.Reiziger;

import java.sql.SQLException;
import java.util.List;

public interface ReizigerDAO {
    boolean save(Reiziger reiziger) throws SQLException;
    boolean update(Reiziger reiziger) throws SQLException;
    boolean delete(Reiziger reiziger) throws SQLException;
    Reiziger findById(int id) throws SQLException;
    List<Reiziger> findByGBDatum(String datum) throws SQLException;
    List<Reiziger> findAll() throws SQLException;
}