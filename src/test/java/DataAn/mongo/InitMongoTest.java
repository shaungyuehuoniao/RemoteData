package DataAn.mongo;

import org.junit.Test;

import DataAn.common.config.Config;
import DataAn.mongo.init.InitMongo;

public class InitMongoTest {

	@Test
	public void test(){
//		System.out.println(InitMongo.SERVER_HOST);
//		System.out.println(InitMongo.SERVER_PORT);
//		System.out.println(InitMongo.DATABASE_TEST);
		System.out.println(Config.CACHE_PATH);
	}
}
