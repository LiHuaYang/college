package set;

import java.sql.ResultSet;
import java.sql.SQLException;


public class stationEntirety implements Comparable<stationEntirety> {

	private int stationId; //绔欑偣缂栧彿
	private int stationBikeNumber; //绔欑偣鑷杞︽暟

	
	
	@Override
	public int compareTo(stationEntirety sta) {

		int res = new Integer(this.stationId).compareTo(new Integer(sta.getStationId()));

		if (res == 0) { 
			return new Integer(this.stationBikeNumber).compareTo(new Integer(sta.getStationBikeNumber())); 
		}
		return new Integer(this.stationId).compareTo(new Integer(sta.getStationId()));
	}

	
	
	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public int getStationBikeNumber() {
		return stationBikeNumber;
	}

	public void setStationBikeNumber(int stationBikeNumber) {
		this.stationBikeNumber = stationBikeNumber;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(((stationEntirety) obj).getStationId() == this.stationId && ((stationEntirety) obj).getStationBikeNumber()==this.stationBikeNumber) {
			return true;
		}
		return false;
	}
}
