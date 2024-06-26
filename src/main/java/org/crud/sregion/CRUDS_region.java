package org.crud.sregion;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * app java ---- jdbc ---- oracle
 * 
 */
public class CRUDS_region {
	public static Connection connection = null;
	public static String driver = "oracle.jdbc.driver.OracleDriver";
	public static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";

	public static void connectDataBaseOracle() throws IOException, SQLException {

		try {
			Class.forName(driver).newInstance();
			System.out.println("cargo driver: ojdbc.jar");

		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
		try {
			connection = DriverManager.getConnection(URL, "System", "Temporal1");
			System.out.println("Conexion Exitosa: Oracle11g");
		} catch (Exception e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}

	public static void agregarS_Region(int id, String name) throws IOException {
		try {
			connectDataBaseOracle();

			// Parametrom: ? :a
			String sql = "INSERT INTO S_REGION (ID,NAME) VALUES (?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.execute();
			System.out.println("INSERTO EL REGISTRO: " + id + "," + name);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	public static void modificarS_Region(int id, String name) throws IOException {
		try {
			connectDataBaseOracle();

			// Parametrom: ? :a
			String sql = "UPDATE S_REGION SET NAME = ? WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.execute();
			System.out.println("ACTUALIZO EL REGISTRO: " + id + "," + name);

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	public static void eliminarS_Region(int id) throws IOException {
		try {
			connectDataBaseOracle();

			// Parametrom: ? :a
			String sql = "DELETE FROM S_REGION WHERE ID=?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
			System.out.println("ELIMINO EL REGISTRO: " + id );

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	public static void consultarS_Region() throws IOException {
		try {
			connectDataBaseOracle();

			// Parametrom: ? :a
			String sql = "SELECT * FROM S_REGION";
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			System.out.println(rs.getInt("id")+","+rs.getString("name"));
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}
	
	public static void consultaIndividualS_Region(int id) throws IOException {
		try {
			connectDataBaseOracle();

			// Parametrom: ? :a
			String sql = "SELECT * FROM S_REGION WHERE ID = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
			System.out.println(rs.getInt("id")+","+rs.getString("name"));
			}

		} catch (Exception e) {
			System.out.println("Exception" + e.getMessage());
		}
	}

	public static void main(String[] args) throws IOException, SQLException {
		//connectDataBaseOracle();
		//agregarS_Region(10, "Chihuahua");
		//modificarS_Region(1, "CDMX");
		//eliminarS_Region(9);
		//consultarS_Region();
		consultaIndividualS_Region(10);
	}
}