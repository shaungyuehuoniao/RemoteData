package DataAn.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import DataAn.common.config.CommonConfig;
import DataAn.common.utils.FileUtil;

public class FileUtilTest {

	@Test
	public void test(){
		String sPath = CommonConfig.getCachePath();
		System.out.println(sPath);
		FileUtil.deleteDirectory(sPath,false);
	}
	
	@Test
	public void saveFile() throws Exception{
		File file = new File("C:\\excel_result\\数管分系统.csv");
		InputStream in = new FileInputStream(file);
		FileUtil.saveFile(CommonConfig.getUplodCachePath(), "数管分系统.csv", in);
	}
	
	@Test
	public void copyFile(){
		String srcPath = "D:\\temp\\data\\2016\\7";
		String desDirectoy = "D:\\temp";
		FileUtil.copyFile(srcPath, desDirectoy, true);
	}
	
}
