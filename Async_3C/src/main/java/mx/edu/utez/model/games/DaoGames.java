package mx.edu.utez.model.games;

import mx.edu.utez.model.category.BeanCategory;
import mx.edu.utez.service.ConnectionMySQL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;

public class DaoGames {
    //*Practica DAOGames*//
    private Connection con;
    private CallableStatement cstm;
    private ResultSet rs;
    final private Logger CONSOLE = LoggerFactory.getLogger(DaoGames.class);
    //*  Consulta general: findAll() *//
    public List<BeanGames> findAll(){
        List<BeanGames> listGames = new ArrayList<>();
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_findGames}");
            rs = cstm.executeQuery();
            while(rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                BeanGames beanGames = new BeanGames();
                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("name"));
                beanCategory.setStatus(rs.getInt("status"));
                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("Name"));
                beanGames.setImgGame(Base64.getEncoder().encodeToString(rs.getBytes("imgGames")));
                beanGames.setDatePremiere(rs.getString("datePremiere"));
                beanGames.setCategory_idCategory(beanCategory);
                beanGames.setStatus(rs.getInt("status"));
                listGames.add(beanGames);
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return listGames;
    }
    //* Consulta específica: findById() *//
    public BeanGames findById(long id){
        BeanGames games = null;
        try {
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("SELECT * FROM videogames WHERE id = ? ");
            cstm.setInt(1, (int) id);
            rs = cstm.executeQuery();
            if(rs.next()){
                BeanCategory beanCategory = new BeanCategory();
                BeanGames beanGames = new BeanGames();
                games = new BeanGames();
                beanCategory.setIdCategory(rs.getInt("idCategory"));
                beanCategory.setName(rs.getString("name"));
                beanCategory.setStatus(rs.getInt("status"));
                beanGames.setIdGames(rs.getInt("idGames"));
                beanGames.setName(rs.getString("Name"));
                beanGames.setImgGame(Base64.getEncoder().encodeToString(rs.getBytes("imgGames")));
                beanGames.setDatePremiere(rs.getString("datePremiere"));
                beanGames.setCategory_idCategory(beanCategory);
                beanGames.setStatus(rs.getInt("status"));
            }
        }catch (SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm, rs);
        }
        return games;
    }
    //* Registrar: create() *//
    public boolean create(BeanGames beanGames, InputStream image){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_create(?,?,?,?)}");
            cstm.setString(1, beanGames.getName());
            cstm.setString(2, beanGames.getImgGame());
            cstm.setString(3, beanGames.getDatePremiere());
            cstm.setInt(4, beanGames.getCategory_idCategory().getIdCategory());
            cstm.execute();
            flag = true;
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        } finally {
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
    //* Actualizar: update() *//
    public boolean update(BeanGames beanGames){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_update(?,?,?,?,?,?,?)}");
            cstm.setInt(1, beanGames.getIdGames());
            cstm.setString(2, beanGames.getName());
            cstm.setString(3, beanGames.getImgGame());
            cstm.setString(4, beanGames.getDatePremiere());
            cstm.setInt(5, beanGames.getCategory_idCategory().getIdCategory());
            cstm.setInt(6, beanGames.getStatus());
            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
    //* Eliminar (baja lógica): delete() *//
    public boolean delete(int idGames){
        boolean flag = false;
        try{
            con = ConnectionMySQL.getConnection();
            cstm = con.prepareCall("{call sp_delete2(?)}");
            cstm.setInt(1, (int) idGames);
            flag = cstm.execute();
        }catch(SQLException e){
            CONSOLE.error("Ha ocurrido un error: " + e.getMessage());
        }finally{
            ConnectionMySQL.closeConnections(con, cstm);
        }
        return flag;
    }
}