package junit.test;

import java.util.List;

import org.junit.Test;

import com.nbut.dao.dbutils_impl.ProgramDaoImpl;
import com.nbut.entity.ProgramSet;

public class testDbUtilsImpl {

	
	
	@Test
	public void test1() {
		
		List<ProgramSet> list = new ProgramDaoImpl().getProgramSet_admin(1);
		
		for (ProgramSet pro : list) {
			System.out.println(pro.toString());
		}
		
	}
}
