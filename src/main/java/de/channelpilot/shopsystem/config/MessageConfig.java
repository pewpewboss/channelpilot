package de.channelpilot.shopsystem.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.channelpilot.shopsystem.messaging.Receiver;
/**
 * Spring AMQP requires that the Queue, the TopicExchange, and the Binding be declared as top-level Spring beans in order to be set up properly.
 *
 */
@Configuration
public class MessageConfig {

	public static final String TOPIC = "spring-boot-exchange";
	static final String queueName = "spring-boot";

	/**
	 * 
	 * JMS queues and AMQP queues have different semantics. For example, JMS sends
	 * queued messages to only one consumer. While AMQP queues do the same thing,
	 * AMQP producers do not send messages directly to queues. Instead, a message is
	 * sent to an exchange, which can go to a single queue or fan out to multiple
	 * queues, emulating the concept of JMS topics.
	 * 
	 * @return
	 */
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	/**
	 * creates a Topic
	 * 
	 * @return
	 */
	@Bean
	TopicExchange exchange() {
		return new TopicExchange(TOPIC);
	}

	/**
	 * binds the queue and exchange together, defining the behavior that occurs when
	 * RabbitTemplate publishes to an exchange.
	 * 
	 * @param queue
	 * @param exchange
	 * @return
	 */
	@Bean
	Binding bindingV1(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("v1.product.#");
	}
	@Bean
	Binding bindingV2(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with("v2.product.#");
	}

	/**
	 * The Container is needed to listen for messages
	 * 
	 * @param connectionFactory
	 * @param listenerAdapter
	 * @return
	 */
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
			MessageListenerAdapter listenerAdapter) {
		SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
		container.setConnectionFactory(connectionFactory);
		container.setQueueNames(queueName);
		container.setMessageListener(listenerAdapter);
		return container;
	}

	/**
	 * This is a definition of a Bean for a message listener
	 * 
	 * @param receiver The Pojo
	 * @return the actual listener MessageListenerAdapter
	 */
	@Bean
	MessageListenerAdapter listenerAdapter(Receiver receiver) {
		return new MessageListenerAdapter(receiver, "receiveMessage");
	}
}
