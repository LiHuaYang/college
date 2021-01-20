

# 2016年11月16日
私有协议开发中，客户端消息具有很多类型时候，怎么设计解码器
1. 设计多个解码器
	需要在启动的时候加上很多的解码handler
	
2. 设计一个通用解码器加上很多的方法
	在一个解码器中会有产生很多switch case
	
	
# 2016年11月17日
若将redis中存储形式设为map，如何保证每条记录的唯一性


> pipeline, handler, channelHandlerContext这样对象倒底是channel级的，还是event级的，又或者是系统级的？ 
> 或者这样问，一个连接中只有一个相应的实例，抑或每来一个消息都会生成一个相应的实例，又或者整个系统共享一个相应的实例？ 

一个pipeline实例只属于一个channel
一个连接会产生一个Channel实例
一个Channel里面只有一个pipeline实例
一个pipeline里面可以有多个handler实例
一个handler对应一个context

# 2016年11月18日
Netty半包解码器的实现



Netty服务端创建时的两个NioEventLoopGroup的作用是？

本质是线程组：
	1. 一个线程组用于监听本地端口接受客户端链接，并产生Channel
	2. 一个线程组用于为前线程组产生的Channel分配一个专属的Thread（Eventloop）
	

# 2016年11月26日
增加 CodercFactory 替代 MessageDecoderDispatch
	1. 提供统一地编解码获取方式

增加 MessageTail 类
	代表帧尾
	
修改 MessgaeDecoder/MessageEncoder 接口为抽象父类
	1. 提供默认的加密和解密功能
		当业务是登陆或者是心跳时，子类可以有选择性使用加/解密功能。亦可覆盖


# 2016年12月1日
1. 修改接口 MessageDecoder 的 decoder 方法的参数，增加一个 String 型的密码
	因为除了登陆和心跳以外的业务数据都进行加密，必须提供密码参数，我实在是想不到什么
	好的方法来解决这个问题，先这样子吧


# 2016年12月4日
1. 增加 MessageHandler 接口
2. 增加 BasicHandler 
3. 修改 Decoder、Encoder、Handler 处理池的字符串标记为 MessageType
4. 取消 EncoderPool 和 DecoderPool，将初始化工作转移到工厂类中

5. 增加 MessageAttach 类暂时用来保存ChannelId，以后可能还会用其他的增加的信息，需要保存
6. 修改 MessageConstant 类用来保存消息不变的信息，例如帧头，帧尾，消息中固定字段的长度

7. 将 MessageHeader 中的 yeWuId、xieYiHao 移动到 MessageContent 中
8. 将客户端到服务器的请求消息实体，移入 com.yingteman.netty.message.request 包中
	该包存放请求消息实体
9. 将服务器到客户端的响应消息实体，移入 com.yingteman.netty.message.response 包中
	该包存放响应消息实体
10. 修改 MessageHeader 中的属性类型,使更匹配协议，而不全部是 String 类型
11. 在 MessageTail 类中添加，时间戳和校验码字段

12. 删除 CodecFactory 类，使用 MessageDecoderFactory、MessageEncoderFactory 代替
13. 修改所有 业务ID 的类型为 short
	注：当需要用到 equals 等方法时，需要使用 short 的包装类 Short

14. 大致完成 LoginReqMessageHandler 中的业务逻辑

# 2016年12月10日
1. 修改 LoginReqMessage 中类型为 String 的属性全部修改为 byte[]
2. 增加 com.yingteman.netty.client 包，用来存放客户端测试类
3. 完善注释文档

4. 修改 LoginRespMessage 的 token 和 carTypeId 为 byte[] 和 int
5. 服务器和客户端连接成功（可以实现单次登陆）

# 2016年12月11日
1. 完善如下包的注释信息
 - com.yingteman.netty.message
 - com.yingteman.netty.message.request
 - com.yingteman.netty.message.response
 - com.yingteman.netty.codec.encoder
2. 实现服务器和客户端的心跳互连

# 2016年12月12日
1. 修改类名 LoginReqMessage 为 LoginReqMessageContent
2. 修改类名 LoginRespMessage 为 LoginRespMessageContent
 
# 2016年12月13日
1. 实现客户端和服务器心跳登陆最简单流程（在服务器端需要加上日志）

# 2016年12月14日
1. 新增 
	- TourReportReqMessageContent 行程报告请求消息类
	- TourReportRespMessageContent 行程报告响应消息类
	- WarningReqMessageContent 报警信息请求消息类
	- TourReportMessageContentHandler 行程报告处理类
2. 修改 Handler 名字，为 ContentHandler，因为此项目的 Handler 自始至终操作的都是 MessageContent，而不是 整个Message

# 2016年12月18日
1. 实现通过修改服务器心跳响应报文，来更改客户端的心跳周期的功能
2， 添加 OnlineObdDevice，用户储存客户端 channelId 和 Channel 之间的映射关系
3. 添加 com.yingteman.httpservice 包，为用户提供 http 服务。如：修改盒子的激活状态，或者是修改盒子的心跳周期
	- 需要制定请求接口规范，未实现
4. 增加 nanohttpd-webserver-2.1.1-jar-with-dependencies.jar，用于实现轻量级 http 服务器。

5. 将测试源码（test）文件加，类合并后，移入 com.yingteman.test 包内（虽然我也不知道为什么要这么干，看起来干净点？）

# 2016年12月19日
1. 修改
	- com.yingteman.netty.codec.decoder
	- com.yingteman.netty.handler
	- com.yingteman.netty.codec.encoder
	中的类名，因为具体实现类，操作的只是 MessageContent，所以并不需要命名为 MessageDecoder、Messagehalder、MessageHandlder
	加上 Content 会更加的贴切。如 LoginMessageContentDecoder、LoginMessageContentEncoder、LoginMessageContentHandler
2. 修改 Decoder、Encoder、Handler 的父类名字为 Abstract...（单纯地觉得更加贴切）


# 2016年12月20日
1. 完成客户端登陆成功后，往服务器定时发送行程数据的测试功能

# 2016年12月23日
1. 添加 CRC16 算法
2. 将 redis-key 保存到 redis-key.properties 文件中


# 2017年1月9日
1. 添加 HttpService，为 web 后端提供服务
2. 添加 HttpService 实现类
	- CfgService：修改配置文件服务
	- UnBindService：解除绑定服务


# 2017年1月10日
1. 完成单个配置（心跳）下发的基本流程
















