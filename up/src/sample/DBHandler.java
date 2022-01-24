package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.sql.*;


public class DBHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String conectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(conectionString, dbUser, dbPass);
        return dbConnection;
    }


    public ObservableList<Driver> getDriver() throws SQLException, ClassNotFoundException {
        String select = "SELECT * FROM " + Const.TABLE;
        ObservableList<Driver> drivers = FXCollections.observableArrayList();
        PreparedStatement prSt = getDbConnection().prepareStatement(select);
        ResultSet set = prSt.executeQuery();

        while (set.next()) {
            Driver driver = new Driver();
            driver.setId(set.getInt(Const.id));
            driver.setName(set.getString(Const.name));
            driver.setMiddlename(set.getString(Const.middlename));
            driver.setPassport_serial(set.getString(Const.passport_serial));
            driver.setPassport_number(set.getString(Const.passport_number));
            driver.setPostcode(set.getInt(Const.postcode));
            driver.setAddress(set.getString(Const.address));
            driver.setAddress_life(set.getString(Const.address_life));
            driver.setCompany(set.getString(Const.company));
            driver.setJobname(set.getString(Const.jobname));
            driver.setPhone(set.getString(Const.phone));
            driver.setEmail(set.getString(Const.email));
            driver.setPhoto(set.getString(Const.photo));
            driver.setDescription(set.getString(Const.description));
            drivers.add(driver);
        }
        return drivers;
    }

    public ObservableList<Driver> getAddDriver() throws SQLException, ClassNotFoundException {
        String insert = "INSERT INTO " + Const.TABLE + "(" + Const.id + ", " + Const.name + ", " + Const.middlename + ", " + Const.passport_serial + ", " + Const.passport_number + ", " + Const.postcode + ", " +
                Const.address + ", " + Const.address_life + Const.company + ", " + Const.jobname + "," + Const.phone + ", " + Const.email + ", " + Const.photo + ", " + Const.description + ", " + ") " +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        ObservableList<Driver> drivers = FXCollections.observableArrayList();
        PreparedStatement prSt = getDbConnection().prepareStatement(insert);
        ResultSet set = prSt.executeQuery();

        while (set.next()) {
            Driver driver = new Driver();
            driver.setId(set.getInt(Const.id));
            driver.setName(set.getString(Const.name));
            driver.setMiddlename(set.getString(Const.middlename));
            driver.setPassport_serial(set.getString(Const.passport_serial));
            driver.setPassport_number(set.getString(Const.passport_number));
            driver.setPostcode(set.getInt(Const.postcode));
            driver.setAddress(set.getString(Const.address));
            driver.setAddress_life(set.getString(Const.address_life));
            driver.setCompany(set.getString(Const.company));
            driver.setJobname(set.getString(Const.jobname));
            driver.setPhone(set.getString(Const.phone));
            driver.setEmail(set.getString(Const.email));
            driver.setPhoto(set.getString(Const.photo));
            driver.setDescription(set.getString(Const.description));
            driver.executeUpdate();
        }
        return drivers;
    }
}