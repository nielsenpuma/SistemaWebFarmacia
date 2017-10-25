package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import beans.EmpleadoDTO;
import interfaces.EmpleadoDAO;
import utils.MysqlDBConexion;

public class MysqlEmpleadoDAO implements EmpleadoDAO {

	@Override
	public EmpleadoDTO autentificacionEmpleado(String xuser, String xpass) {
		EmpleadoDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn = MysqlDBConexion.getConexion();
			String sql = "select * from tb_empleado " + 
					"where USER_EMP=? and PASS_EMP=?;";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, xuser);
			pstm.setString(2, xpass);
			rs = pstm.executeQuery();
			
			while (rs.next()) {
				obj = new EmpleadoDTO();
				obj.setCod_emp(rs.getInt(1));
				obj.setNom_emp(rs.getString(2));
				obj.setApat_emp(rs.getString(3));
				obj.setAmat_emp(rs.getString(4));
				obj.setFec_ing_emp(rs.getString(5));
				obj.setUser_emp(rs.getString(6));
				obj.setPass_emp(rs.getString(7));
				obj.setCod_cargo(rs.getInt(8));				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("MysqlEM - error: \n"+e);
		}
		return obj;
	}

}
