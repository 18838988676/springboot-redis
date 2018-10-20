package cn.com.wmc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisZSetCommands.Range;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
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
	 
	 
	   
	 
	 //最新列表
	 @Test
	 public void testList() throws Exception {
		 ListOperations<Object, Object> 	list=	redisTemplate.opsForList();
		 list.leftPush("news1", "z");
		 list.leftPush("news1", "2x");
		 list.leftPush("news1", "v3");
		 list.leftPush("news1", "kkk4");
		 List<Object> listsss=  redisTemplate.opsForList().range("news1",0,-1);  
		 for (Object object : listsss) {
			System.out.println(object);
		}
	}
	 
	 //排行榜从高到底排序，热搜榜，热搜词
	 @Test
	public void testPaihang() throws Exception {
	     ZSetOperations<Object, Object> zSetOperations = redisTemplate.opsForZSet();
	     int infoId=1;
	     zSetOperations.add("book", "wmc1", 48);
	     zSetOperations.add("book", "wmc2", 53);
	     zSetOperations.add("book", "wmc4", 35);
	     zSetOperations.add("book", "wmc6", 99);
	      Set<Object> ss2= zSetOperations.reverseRange("book", 0, -1);
	      System.out.println(ss2);
	}
	 
/*================================计数器===============================================================	 */
	 //点击计数器
	 @Test
	public void testjishuqi() throws Exception {
		 RedisAtomicLong redisAtomicLong = new RedisAtomicLong("cishu2", redisTemplate.getConnectionFactory());
		 //初始化为1
		// RedisAtomicLong redisAtomicLong = new RedisAtomicLong("cishu23", redisTemplate.getConnectionFactory(),9);
	     //次数 
		 Long increment = redisAtomicLong.getAndIncrement();
	        System.out.println("已经点击次数："+increment);
	        //获得内存中的值
	        System.out.println("内存中值："+redisAtomicLong.get());
	}
	 
	 //手机号3次数限制
	 @Test
	public void testxianzhi() throws Exception {
		 RedisAtomicLong redisAtomicLong = new RedisAtomicLong("48838988676", redisTemplate.getConnectionFactory());
		//次数   调用一次加一次
		 Long increment = redisAtomicLong.getAndIncrement();
		 if(redisAtomicLong.get()==3){
			 System.out.println("次数已到");
		 }
		 else {
			System.err.println("还有"+(3-redisAtomicLong.get())+"次机会");
		}
	}
	 
//手机号60秒内：3次数限制
//	 第一步：先初始化  给定时间  
	 @Test
	public void testone() throws Exception {
		 RedisAtomicLong redisAtomicLong = new RedisAtomicLong("18838988676", redisTemplate.getConnectionFactory());
		 long liveTime=new Long(60);
		 redisAtomicLong.expire(liveTime, TimeUnit.SECONDS);
		 Long increment = redisAtomicLong.getAndIncrement();
	}
	 
//第二步： 
	 @Test
	public void testxianzhi2() throws Exception {
		 RedisAtomicLong redisAtomicLong = new RedisAtomicLong("18838988676", redisTemplate.getConnectionFactory());
		 if (redisAtomicLong.get()!=0) {
			if(redisAtomicLong.get()==3){
				System.out.println("次数已到");
			}else {
				System.err.println("还有"+(3-redisAtomicLong.get())+"次机会");
				//次数   调用一次加一次
				Long increment = redisAtomicLong.getAndIncrement();
			}
		}else {
			System.out.println("时间已到");
		}
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
