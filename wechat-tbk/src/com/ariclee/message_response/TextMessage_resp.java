package com.ariclee.message_response;

/**
 * 消息文本
 * @author WangYuwei
 *
 */
public class TextMessage_resp extends BaseMessage_resp{
	
	// 回复的消息内容  
    private String Content;  
  
    public String getContent() {  
        return Content;  
    }  
  
    public void setContent(String content) {  
        Content = content;  
    }  

}
