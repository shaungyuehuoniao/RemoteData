package DataAn.mongo.db;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import DataAn.common.utils.DateUtil;
import DataAn.common.utils.LogUtil;
import DataAn.mongo.init.InitMongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;

public class MongodbUtil {

	private MongoClient mg = null;
	
	private  MongoDatabase db = null;
	
	private volatile static MongodbUtil singleton = null;
	
	public static MongodbUtil getInstance() {
		if (singleton == null) {
			synchronized (MongodbUtil.class) {
				if (singleton == null) {
					singleton = new MongodbUtil();
				}
			}
			singleton = new MongodbUtil();
		}
		return singleton;
	}
	
	private MongodbUtil(){
		if (LogUtil.getInstance().getLogger(MongodbUtil.class).isDebugEnabled()) {
			LogUtil.getInstance().getLogger(MongodbUtil.class).debug("MongodbCollectionManagerUtil() - start "); //$NON-NLS-1$
		}
		mg = new MongoClient( InitMongo.SERVER_HOST , InitMongo.SERVER_PORT );
		db = mg.getDatabase(InitMongo.DATABASE_TEST);
//		if(mg == null){
//		}
	}
	
	/**
	* @Title: insert
	* @Description: 为相应的集合添加数据
	* @param collectionName 集合名称
	* @author Shenwp
	* @date 2016年7月6日
	* @version 1.0
	*/
	public void insert(String collectionName, Map<String, Object> map){
		MongoCollection<Document> collection = db.getCollection(collectionName);
		Document doc = new Document(map);
		collection.insertOne(doc);
	}

	/**
	* @Title: insert
	* @Description: 批量插入数据
	* @param collectionName 集合名称
	* @param documents doc集合
	* @author Shenwp
	* @date 2016年7月6日
	* @version 1.0
	*/
	public void insert(String collectionName, List<Document> documents){
		MongoCollection<Document> collection = db.getCollection(collectionName);
		collection.insertMany(documents);
	}
	
	
	/**
	* @Title: insert
	* @Description: 添加一个Json格式的数据类型
	* @param collectionName 集合名称
	* @param json 单个json格式数据
	* @author Shenwp
	* @date 2016年7月6日
	* @version 1.0
	*/
	public void insert(String collectionName, String json){
		MongoCollection<Document> collection = db.getCollection(collectionName);
		Document doc = Document.parse(json);
		collection.insertOne(doc);
	}
	
	public Document findFirst(String collectionName){
		MongoCollection<Document> collection = db.getCollection(collectionName);
		Document doc = collection.find().first();
		return doc;
	}
	
	public void findAll(String collectionName){
		MongoCollection<Document> collection = db.getCollection("testNew");
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}
	}
	
	public void find(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		Document doc = collection.find(Filters.eq("i", 7)).first();
		System.out.println(doc.toJson());
	}
	
	public void update(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		collection.updateOne(Filters.eq("i", 5), Updates.set("i", 51));
	}
	public void deleteOne(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		collection.deleteOne(Filters.eq("i", 9));
	}
	public void deleteMany(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		// >= 100
		DeleteResult deleteResult = collection.deleteMany(Filters.gte("i", 10));
		System.out.println(deleteResult.getDeletedCount());
	}
	public void dropCollection(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		collection.drop();
	}
	
	public void getIndex(){
		MongoCollection<Document> collection = db.getCollection("testNew");
		for (final Document index : collection.listIndexes()) {
		    System.out.println(index.toJson());
		}
	}
	
	public List<Float> findAllByTie(String param){
		MongoCollection<Document> collection = db.getCollection("star2");
	//	MongoCursor<Document> cursor = collection.find().iterator();
		MongoCursor<Document> cursor = collection.find(Filters.eq("year_month_day", "2016-10-10")).iterator();
		try {
			List<Float> paramValue =  new ArrayList<Float>();
//			HashMap<String,List<String>> paramMap = new HashMap<String,List<String>>();
			int count=0;
		    while (cursor.hasNext()) {
		    	if(count>=10000){break;}
		    	Document doc = cursor.next();
		    	Float value = Float.parseFloat(doc.getString("flywheel_b_power_plus_5V"));
		    	//String value = doc.getString("flywheel_b_power_plus_5V");	        
	            paramValue.add(value);	
	            count++;
		    }
		    return paramValue;  
		} finally {
		    cursor.close();
		}
		
	}
	
	public List<String> getDateList(String param){
		MongoCollection<Document> collection = db.getCollection("star2");
	//	MongoCursor<Document> cursor = collection.find().iterator();
		MongoCursor<Document> cursor = collection.find(Filters.eq("year_month_day", "2016-10-10")).iterator();
		try {
			List<String> paramValue =  new ArrayList<String>();
//			HashMap<String,List<String>> paramMap = new HashMap<String,List<String>>();
			int count=0;
		    while (cursor.hasNext()) {	
		    	if(count>=10000){break;}
		    	Document doc = cursor.next();
		    //	DateUtil.formatString("2015年08月10日00时15分01秒","yyyy-MM-dd HH:mm:ss")
		    	String value = DateUtil.formatString(doc.getString("datetime"),"yyyy-MM-dd HH:mm:ss");
		    	//String value = doc.getString("flywheel_b_power_plus_5V");	        
	            paramValue.add(value);	
	           count++;
		    }
		    return paramValue;  
		} finally {
		    cursor.close();
		}		
	}
	
	
	
}
