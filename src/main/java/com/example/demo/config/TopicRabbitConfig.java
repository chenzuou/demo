package com.example.demo.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
	final static String message = "topic.message";
	final static String messages = "topic.messages";


	//创建两个 Queue
	@Bean
	public Queue queueMessage(){
		return new Queue(TopicRabbitConfig.message);
	}

	@Bean
	public Queue queueMessages(){
		return new Queue(TopicRabbitConfig.messages);
	}

	//配置 TopicExchange,指定名称为 topicExchange
	@Bean
	public TopicExchange exchange(){
		return new TopicExchange("topicExchange");
	}

	//给队列绑定 exchange 和 routing_key

	/**
	 * 描述：只处理topic.message的请求
	 * @author : paul
	 * @param
	 * @return
	 * @date   : 2020/4/15/015 16:37
	 */
	@Bean
	public Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange){
		return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
	}

	/**
	 * 描述：处理所有来源的请求
	 * @author : paul
	 * @param
	 * @return
	 * @date   : 2020/4/15/015 16:36
	 */
	@Bean
	public Binding bingingExchangeMessages(Queue queueMessages,TopicExchange exchange){
		return BindingBuilder.bind(queueMessages).to(exchange).with("aaa.yyy");
	}
}
