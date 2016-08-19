package DataAn.common;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import DataAn.common.service.IJobService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-hibernate.xml","classpath:applicationContext.xml"})
public class JobServiceTest {

	@Resource
	private IJobService jobService;
	
	@Test
	public void test(){
		System.out.println(jobService);
	}
	
	@Test
	public void testSaveFileOfCSV() throws Exception{
		jobService.saveFileOfCSV();
	}
}
