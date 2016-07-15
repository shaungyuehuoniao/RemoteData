package DataAn.fileSystem.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import DataAn.Analysis.dto.ConstraintDto;
import DataAn.fileSystem.service.impl.FlyWheelServiceImpl;

public class FlyWheelServiceTest {

	private IFlyWheelService flyWheelService;
	
	@Before
	public void init(){
		flyWheelService = new FlyWheelServiceImpl();
	}
	
	@Test
	public void test() throws Exception{
		List<ConstraintDto> list = flyWheelService.getFlyWheelParameterList();
		for (ConstraintDto c : list) {
			System.out.println(c);
		}
	}
}