ckage com.aoide.global.dataBaseManipulationObjects.bullet;

import java.util.List;

public class TestBulletDAO {

	public static void main(String[] args) {
		BulletDAO dao = new BulletDAO();
		
		
		// 新增
		BulletVO bulletVO1 = new BulletVO();
		//bulletVO1.setBulletId(4);
		bulletVO1.setTiltle("哈搂你好嗎");
		bulletVO1.setContentFile("你我他");
		dao.insert(bulletVO1);

		// 修改
		BulletVO bulletVO2 = new BulletVO();
		bulletVO2.setBulletId(4);
		bulletVO2.setTiltle("哈搂你好嗎媽媽媽");
		bulletVO2.setContentFile("你我他我他你");
		dao.insert(bulletVO2);


		// 刪除
    	dao.delete(4);

		// 查詢
		BulletVO bulletVO3 = dao.findByPrimaryKey(1);
		System.out.print(bulletVO3.getBulletId() + ",");
		System.out.print(bulletVO3.getDate() + ",");
		System.out.print(bulletVO3.getTiltle() + ",");
		System.out.println(bulletVO3.getContentFile() + ",");
        System.out.println("---------------------");

		// 查詢
		List<BulletVO> list = dao.getAll();
		for (BulletVO aBulletVO : list) {
			System.out.print(aBulletVO.getBulletId() + ",");
			System.out.print(aBulletVO.getDate() + ",");
			System.out.print(aBulletVO.getTiltle() + ",");
			System.out.print(aBulletVO.getContentFile() + ",");
            System.out.println();
		}
    }
}