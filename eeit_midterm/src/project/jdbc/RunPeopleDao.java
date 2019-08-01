package project.jdbc;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.json.JSONException;

public class RunPeopleDao {
		
	public static void main(String[] args) throws Exception {
		IPeopleDao pDao = PeopleDaoFactory.createPeopleDao();
		pDao.createConn();
		
		Scanner sca = new Scanner(System.in);
		People p = new People();
		
		//新增資料測試			
//		System.out.println("請輸入年份");
//		p.setYear(sca.nextInt());
//		System.out.println("請輸入縣市代碼");
//		p.setCounty(sca.nextInt());
//		System.out.println("請輸入死因代碼");
//		p.setCause(sca.nextInt());
//		System.out.println("請輸入性別(男/女)");
//		p.setSex(sca.next());
//		System.out.println("請輸入年齡代碼");
//		p.setAge_code(sca.nextInt());
//		System.out.println("請輸入人數");
//		p.setAmount(sca.nextInt());	
//		pDao.insertDb(p);			
		
		//修改資料測試
//		System.out.println("請輸入人數");
//		p.setAmount(sca.nextInt());
//		System.out.println("請輸入對應的資料ID");
//		p.setId(sca.nextInt());
//		pDao.update(p);
		
		//刪除資料測試
//		System.out.println("請輸入欲刪除的資料ID");
//		p.setId(sca.nextInt());
//		pDao.delete(p);
		
		//查詢資料測試
		pDao.queryDb();
		
		//匯入資料測試
//		pDao.inputDb();
		
		pDao.closeConn();
	}

}
