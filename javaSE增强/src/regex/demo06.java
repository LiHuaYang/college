package regex;

import java.util.ArrayList;

public class demo06 {

	public static void main(String[] args) throws Exception {
		getPlaylists(1);
	}

	private static ArrayList<Integer> getPlaylists(int userID) throws Exception {
		ArrayList<Integer> playlists = new ArrayList<Integer>();
		String url = "http://music.163.com/api/user/playlist/";
		
		// 48117729 ะกฮฤ
		// 136361772 
		// 
		System.out.println(HttpRequest.sendGet(url, "offset=0&limit=100&uid=" + ""));

		return playlists;
	}
}
