package DataAn.mongo;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import DataAn.common.utils.UUIDGeneratorUtil;
import DataAn.fileSystem.dto.CSVFileDataResultDto;
import DataAn.fileSystem.option.J9SeriesType;
import DataAn.fileSystem.service.ICSVService;
import DataAn.mongo.service.IMongoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-hibernate.xml","classpath:applicationContext.xml"})
public class MongoServiceTest {

	@Resource
	private IMongoService mongoService;
	
	@Resource
	private ICSVService csvService;
	private String filePath = "D:\\temp\\data\\2016\\1-6\\j9-02--2016-01-10.csv";
	
	@Test
	public void saveCSVData() throws Exception{
		long begin = System.currentTimeMillis();
		String uuId = UUIDGeneratorUtil.getUUID();
		String series = J9SeriesType.SERIES.getName();
		String star = J9SeriesType.STRA2.getValue();
		String date= "2016-01-10";
		CSVFileDataResultDto<Document> result= csvService.readCSVFileToDoc(filePath,uuId);
		List<Document> list = result.getDatas();
		mongoService.saveCSVData(series, star, date, list);
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - begin));
	}
	
	@Test
	public void saveConfig() throws Exception{
		long begin = System.currentTimeMillis();
		List<Document> list = new ArrayList<Document>();
		Document doc = new Document();
		doc.append("ns", "config.tags");
		Document min = new Document();
		min.append("_id", new ObjectId());
		doc.append("min", min);
//		Document max = new Document();
//		min.append("_id", new ObjectId());
//		doc.append("max", max.);
		doc.append("tag", "AAA");
		list.add(doc);
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - begin));
	}
	
	@Test
	public void find(){
		mongoService.find();
	}
	
	
}
