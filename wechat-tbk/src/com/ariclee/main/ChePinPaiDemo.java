package com.ariclee.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;

import com.ariclee.weixin_codec.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * 车管家车品牌demo
 * 
 * @author ariclee
 */
public class ChePinPaiDemo {
	private static final QueryRunner runerUpdate = new QueryRunner();
	private static final Connection conn = JdbcUtils.getConnection();
	private static final SimpleDateFormat sp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
	private static final Gson gson = new Gson();
	private static final String url = "http://apps.api.dbscar.com/";
	/**
	 * 业务主方法
	 * 
	 * @param args
	 * @author ariclee
	 */
	public static void main(String[] args) {
		
		// 1. 获取所有车品牌信息
		List<ChePinPai> list = new ChePinPaiDemo().getAllCPP();
		
//		for (ChePinPai chePinPai : list) {
//			creatCPPRec(chePinPai.getId(), chePinPai.getChName(), chePinPai.getEnName());
//		}
		
		// 2. 根据车信息，获取车每个型号信息
		for (ChePinPai chePinPai : list) {
			List<CheXing> cl = getCX(chePinPai.getId());
		}
	}
	
	/**
	 * 获取某个车品牌所有的车型
	 * 
	 * @param cheXingId 车品牌ID
	 * @return
	 * @author ariclee
	 */
	private static List<CheXing> getCX(String cheXingId) {
		List<CheXing> items = new ArrayList<>();
		String res = HttpRequest.sendGet(url,
				"action=mine_car_service.query_market_car_type&app_id=121&lan=zh&lan_id_or_name=CN&sign=4bac08981b6dfcbc234a54a13cc05b5a&detailId="
						+ cheXingId + "&ver=5.3.4&user_id=2036062");
		JsonObject json = gson.fromJson(res, JsonObject.class);
		JsonArray array = json.getAsJsonArray("data");
		
		if (array != null && array.size() > 0) {
			for (int j = 0; j < array.size(); j++) {
				JsonElement el = array.get(j);
				String name = el.getAsJsonObject().get("carType").getAsString();
				String chePinPaiId = el.getAsJsonObject().get("detailId").getAsString();
				String id = el.getAsJsonObject().get("id").getAsString();
				items.add(new CheXing(chePinPaiId, id, name));
				creatCXRec(id, chePinPaiId, name);
			}
		}
		return items;
	}
	
	/**
	 * 获取所有车品牌信息
	 * 
	 * @return
	 * @author ariclee
	 */
	private List<ChePinPai> getAllCPP() {
		List<ChePinPai> items = new ArrayList<>();

		String res = HttpRequest.sendGet(url,
				"action=mine_car_service.query_x431_car_series&is_abroad=0&app_id=121&lan=zh&lan_id_or_name=CN&sign=675f36c22d500986a085292e482d3549&ver=5.3.4&user_id=2036062");
		JsonObject json = gson.fromJson(res, JsonObject.class);
		
		JsonArray array = json.getAsJsonArray("data");

		for (int i = 0; i < array.size(); i++) {
			JsonElement el = array.get(i);
			String englishName = el.getAsJsonObject().get("autoCode").getAsString();
			String chinesName = el.getAsJsonObject().get("carSeriesName").getAsString();
			String detailID = el.getAsJsonObject().get("detailId").getAsString();
			JsonArray arr = el.getAsJsonObject().get("subList").getAsJsonArray();
			
			if (arr.size() != 0) {
				for (JsonElement jsonElement : arr) {
					String sub_englishName = jsonElement.getAsJsonObject().get("autoCode").getAsString();
					String sub_chinesName = jsonElement.getAsJsonObject().get("carSeriesName").getAsString();
					String sub_detailID = jsonElement.getAsJsonObject().get("detailId").getAsString();
					ChePinPai sub_cpp = new ChePinPai(sub_detailID, sub_chinesName, sub_englishName);
					items.add(sub_cpp);
				}
			} else {
				ChePinPai cpp = new ChePinPai(detailID, chinesName, englishName);
				items.add(cpp);
			}
		}
		return items;
	}
	
	/**
	 * 生成一条车品牌数据记录
	 * 
	 * @param brand_id
	 *            车品牌ID
	 * @param brand_name
	 *            车品牌中文名
	 * @param engName
	 *            车品牌英文名
	 * @author ariclee
	 */
	private static void creatCPPRec(String brand_id, String brand_name, String engName) {
		String sql = "INSERT INTO `intimatecarcare`.`brand` (`brand_id`, `brand_name`, `eng_name`, `cre_time`) VALUES (?, ?, ?, ?)";

		SimpleDateFormat sp = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
		Object[] param = { brand_id, brand_name, engName, sp.format(new Date(System.currentTimeMillis())) };
		try {
			int res = runerUpdate.update(conn, sql, param);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 生成一条车型号数据库记录
	 * 
	 * @param arctic_id
	 *            车型号id
	 * @param brand_id
	 *            所属车品牌
	 * @param arctic_name
	 *            车型名字
	 * @author ariclee
	 */
	private static void creatCXRec(String arctic_id, String brand_id, String arctic_name) {
		String sql = "INSERT INTO `intimatecarcare`.`arctic` (`arctic_id`, `brand_id`, `arctic_name`, `cre_time`) VALUES (?, ?, ?, ?)";

		Object[] param = { arctic_id, brand_id, arctic_name, sp.format(new Date(System.currentTimeMillis())) };
		try {
			int res = runerUpdate.update(conn, sql, param);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

class ChePinPai {

	private String id;
	private String chName;
	private String enName;

	public ChePinPai(String id, String chName, String enName) {
		this.id = id;
		this.chName = chName;
		this.enName = enName;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getChName() {
		return chName;
	}
	public void setChName(String chName) {
		this.chName = chName;
	}
	public String getEnName() {
		return enName;
	}
	public void setEnName(String enName) {
		this.enName = enName;
	}

	@Override
	public String toString() {
		return "ChePinPai [id=" + id + ", chName=" + chName + ", enName=" + enName + "]";
	}
}


class CheXing {
	private String chePinPaiId;
	private String id;
	private String name;
	public CheXing(String chePinPaiId, String id, String name) {
		this.chePinPaiId = chePinPaiId;
		this.id = id;
		this.name = name;
	}
	
	public String getChePinPaiId() {
		return chePinPaiId;
	}

	public void setChePinPaiId(String chePinPaiId) {
		this.chePinPaiId = chePinPaiId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CheXing [chePinPaiId=" + chePinPaiId + ", id=" + id + ", name=" + name + "]";
	}
	
}
