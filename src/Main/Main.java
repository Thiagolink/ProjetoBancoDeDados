package Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import DAO.IDepartamentos;
import JDBC.DepartamentosJDBC;
import conexao.ConFactory;
import entidade.Departamentos;

public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD");  
		java.sql.Date data = new java.sql.Date(format.parse("2012-09-13").getTime());
		
		Departamentos teste = new Departamentos("aaaaaaa");
		IDepartamentos depDAO = new DepartamentosJDBC("jdbc:mysql://localhost/new_schema","root","102004",ConFactory.MYSQL);

		depDAO.insert(teste);
		depDAO.search(2);
	}

}
