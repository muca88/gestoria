package simi.gestoria.resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class Conexion {
	
	public void LimpiarRegistros()
	{
		
		String conectionUrl = "jdbc:sqlserver://SIMIMX-BDQA01;databaseName=Gestoria;";
		String UserName = "usrGestoria";
		String Password = "g3st0r14";
		Connection con = null;
		Statement stmt = null;
		//ResultSet rs = null;

		try{

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(conectionUrl, UserName, Password);
			//System.out.println("Conexión Establecida");
			
			String DeleteAD =	"delete [Gestoria].[dbo].[AlojamientoDocumentos]";
			String ReinicioAD = "DBCC CHECKIDENT ('[Gestoria].[dbo].[AlojamientoDocumentos]', RESEED, 0)";
			String DeleteDP =	"delete [Gestoria].[dbo].[DocumentosPermiso]";
			String ReinicioDP = "DBCC CHECKIDENT ('[Gestoria].[dbo].[DocumentosPermiso]', RESEED, 0)";
			String DeleteP =	"delete [Gestoria].[dbo].[Permisos]";
			String ReinicioP = "DBCC CHECKIDENT ('[Gestoria].[dbo].[Permisos]', RESEED, 0)";
			String DeleteS =	"delete [Gestoria].[dbo].[Solicitudes]";
			String ReinicioS =	"DBCC CHECKIDENT ('[Gestoria].[dbo].[Solicitudes]', RESEED, 0)";

			stmt = con.createStatement();
			stmt.executeUpdate(DeleteAD);
			stmt.executeUpdate(ReinicioAD);
			stmt.executeUpdate(DeleteDP);
			stmt.executeUpdate(ReinicioDP);
			stmt.executeUpdate(DeleteP);
			stmt.executeUpdate(ReinicioP);
			stmt.executeUpdate(DeleteS);
			stmt.executeUpdate(ReinicioS);


			//while (rs.next()){
				
				//System.out.println("");
			//}
		
			con.close();
		
		}catch (Exception e){
		
			e.printStackTrace();
		
		}
	}
}