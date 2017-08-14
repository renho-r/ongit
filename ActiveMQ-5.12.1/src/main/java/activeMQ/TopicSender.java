package activeMQ;

import javax.jms.DeliveryMode;
import javax.jms.MapMessage;
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TopicSender {

	// ���ʹ���
	public static final int SEND_NUM = 5;
	// tcp ��ַ
	public static final String BROKER_URL = "tcp://localhost:61616";
	// Ŀ�꣬��ActiveMQ����Ա����̨���� http://localhost:8161/admin/queues.jsp
	public static final String DESTINATION = "hoo.mq.topic";

	/**
	 * <b>function:</b> ������Ϣ
	 * 
	 * @author hoojo
	 * @createDate 2013-6-19 ����12:05:42
	 * @param session
	 *            �Ự
	 * @param publisher
	 *            ������
	 * @throws Exception
	 */
	public static void sendMessage(TopicSession session, TopicPublisher publisher) throws Exception {
		for (int i = 0; i < SEND_NUM; i++) {
			String message = "������Ϣ��" + (i + 1) + "��";

			MapMessage map = session.createMapMessage();
			map.setString("text", message);
			map.setLong("time", System.currentTimeMillis());
			System.out.println(map);

			publisher.send(map);
		}
	}

	public static void run() throws Exception {

		TopicConnection connection = null;
		TopicSession session = null;
		try {
			// �������ӹ���
			TopicConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
					ActiveMQConnection.DEFAULT_PASSWORD, BROKER_URL);
			// ͨ����������һ������
			connection = factory.createTopicConnection();
			// ��������
			connection.start();
			// ����һ��session�Ự
			session = connection.createTopicSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// ����һ����Ϣ����
			Topic topic = session.createTopic(DESTINATION);
			// ������Ϣ������
			TopicPublisher publisher = session.createPublisher(topic);
			// ���ó־û�ģʽ
			publisher.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			sendMessage(session, publisher);
			// �ύ�Ự
			session.commit();

		} catch (Exception e) {
			throw e;
		} finally {
			// �ر��ͷ���Դ
			if (session != null) {
				session.close();
			}
			if (connection != null) {
				connection.close();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		TopicSender.run();
	}
}