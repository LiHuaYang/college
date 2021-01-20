package com.Bll;



import java.text.ParseException;

public class test {
	public static void main(String[] args) throws ParseException {
	/*	List<Participants> p=new ArrayList<Participants>();
		for (int i = 0; i < 100; i++) {
			Participants participants=new Participants();
			participants.setActivityId(i);
			p.add(participants);
		}
		p.subList(0, 50).clear();
	*/
	/*BllFame bllFame=new BllFame();
	List<HashMap<String, Object>> maps=bllFame.QueryHotActivity();
	JSONArray jsonArray=JSONArray.fromObject(maps);
	System.out.println(jsonArray);
*/	
	
		BllFame bllFrame=new BllFame();
		//bllFrame.CreateRegistration(3, "aaa", 1, 1, "asd");
		//System.out.println(bllFrame.QueryRegistrationByUser(3));
	/*	for (int i = 5; i >0 ; i--) {
			Chat chat=new Chat(1, 2, ""+i, chatbelongType.PEOPLE,i);
		
			bllFrame.SendChat(chat);
		}
		for (int i = 10; i >5 ; i--) {
			Chat chat=new Chat(2, 1, ""+i, chatbelongType.PEOPLE,i);
		
			bllFrame.SendChat(chat);
		}
		System.out.println(bllFrame.QueryPeopleChats(1, 2));*/
	}
	
	
}
