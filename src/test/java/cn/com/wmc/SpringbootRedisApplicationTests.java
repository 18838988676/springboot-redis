package cn.com.wmc;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.com.wmc.entity.PrescriptionVO;
import cn.com.wmc.service.impl.PrescriptionServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
	
	 @Autowired
	    private PrescriptionServiceImpl prescriptionServiceImpl;
	 @Autowired  // RedisTemplate，可以进行所有的操作
	    private RedisTemplate<Object,Object> redisTemplate;  
	 
	 
	 @Test
	public void testName() throws Exception {
		System.out.println(redisTemplate);
	}
	 
	 //select
	@Test
	public void testselectId() {
		PrescriptionVO prescription = prescriptionServiceImpl.selectById(14);
		System.out.println(prescription);
	}
	
	
	//select all
	@Test
	public void testSelectAll() throws Exception {
		 List<PrescriptionVO> prescriptions = prescriptionServiceImpl.list(null);
		 for (PrescriptionVO prescriptionVO : prescriptions) {
			System.out.println(prescriptionVO);
		}
	}
	
	// delete 
	@Test
	public void testdelet() throws Exception {
		int a= prescriptionServiceImpl.deleteById(7);
		System.out.println(a);
	}
	
	// delete 
		@Test
		public void testdelets() throws Exception {
			List<Integer> ids=new ArrayList<>();
			ids.add(30);
			ids.add(31);
			ids.add(32);
			int a= prescriptionServiceImpl.deleteByIds(ids);
			System.out.println(a);
		}
	
	//add
	@Test
	public void testadd() throws Exception {
		PrescriptionVO prescription=new PrescriptionVO();
		prescription.setClassifyid(1);
		prescription.setDiagnosis("  处方诊断");
		prescription.setDoctorid(1);
		prescription.setIsvalid(1);
		prescription.setNatureid(1);
		prescription.setNote("  this is note");
		prescription.setPrescriptioncode("  prescriptioncode");
		prescription.setRegisterid(1);
		prescription.setPrescriptionname("  setPrescriptionname");
		prescription.setPrescriptiontypeid(1);
		prescription.setPrescriptiontime(new Date());
		prescriptionServiceImpl.insert(prescription);
	}
	
	
	@Test
	public void testadds() throws Exception {
		PrescriptionVO prescription=new PrescriptionVO();
		for (int i = 0; i < 50; i++) {
			prescription.setClassifyid(1);
			prescription.setDiagnosis(i+"  处方诊断");
			prescription.setDoctorid(1);
			prescription.setIsvalid(1);
			prescription.setNatureid(1);
			prescription.setNote(i+"  this is note");
			prescription.setPrescriptioncode(i+"  prescriptioncode");
			prescription.setRegisterid(1);
			prescription.setPrescriptionname(i+"  setPrescriptionname");
			prescription.setPrescriptiontypeid(1);
			prescription.setPrescriptiontime(new Date());
			prescriptionServiceImpl.insert(prescription);
		}
	}
	
	
	
	//update
		@Test
		public void testupdate() throws Exception {
			PrescriptionVO prescriptionVO=new PrescriptionVO();
			prescriptionVO.setId(13);
			prescriptionVO.setRegisterid(0000);
			prescriptionServiceImpl.updateById(prescriptionVO);
		}
	
	
	
	
	
	
	
	
	
	

}
