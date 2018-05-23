package com.weige.ssm.dwr;
import java.io.IOException;  
import java.util.concurrent.CopyOnWriteArraySet;  
import javax.websocket.OnClose;  
import javax.websocket.OnError;  
import javax.websocket.OnMessage;  
import javax.websocket.OnOpen;  
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;  
  
@ServerEndpoint(value="/websocket/{userName}")  
public class MyWebSocket {  
      
    /**
     * 静态变量 记录count
     */
    private static int onlineCount = 0;  
       
    /**
     * 存放socket连接对象
     */
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();  
       
    /**
     * 与客户端的连接会话
     */
    private Session session;  
    
    /**
     * 记录每个用户名称
     */
    private String userName;
       
    /** 
     * 连接建立成功调用的方法 
     * @param session  可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据 
     */  
    @OnOpen  
    public void onOpen(Session session,@PathParam("userName") String userName){ 
    	this.userName = userName;
        this.session = session;  
        webSocketSet.add(this);     //加入set中  
        addOnlineCount();           //在线数加1  
        System.out.println("用户"+userName+"连接了，当前在线人数为" + getOnlineCount());  
    }  
       
    /** 
     * 连接关闭调用的方法 
     */  
    @OnClose  
    public void onClose(){  
        webSocketSet.remove(this);  //从set中删除  
        subOnlineCount();           //在线数减1      
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());  
    }  
       
    /** 
     * 收到客户端消息后调用的方法 
     * @param message 客户端发送过来的消息 
     * @param session 可选的参数 
     */  
    @OnMessage  
    public void onMessage(String message, Session session) {  
        System.out.println("来自"+userName+"的消息:" + message);  
         message="来自"+userName+"的消息:" + message;
        //群发消息  
        for(MyWebSocket item: webSocketSet){               
            try {  
                item.sendMessage(message);  
            } catch (IOException e) {  
                e.printStackTrace();  
                continue;  
            }  
        }  
    }  
       
    /** 
     * 发生错误时调用 
     * @param session 
     * @param error 
     */  
    @OnError  
    public void onError(Session session, Throwable error){  
        System.out.println("发生错误");  
        error.printStackTrace();  
    }  
       
    /** 
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。 
     * @param message 
     * @throws IOException 
     */  
    public void sendMessage(String message) throws IOException{  
        this.session.getBasicRemote().sendText(message);  
        //this.session.getAsyncRemote().sendText(message);  
    }  
   
    /**
     * 获取在线人数
     * @return
     */
    public static synchronized int getOnlineCount() {  
        return onlineCount;  
    }  
   
    /**
     * 连接人数加1
     */
    public static synchronized void addOnlineCount() {  
        MyWebSocket.onlineCount++;  
    }  
      
    /**
     * 连接人数减1
     */
    public static synchronized void subOnlineCount() {  
        MyWebSocket.onlineCount--;  
    }  
  
    /**
     * 返回所有连接
     * @return
     */
    public static  CopyOnWriteArraySet<MyWebSocket> getAllSocket() {
    	return webSocketSet;
    }
}  
