package com.renho; /**
 * @author: xxxxx
 * @since: 1.0.0
 */

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.SubmissionPublisher;

/**
 * �� process �� flow demo
 */

/**
 * Processor, ��Ҫ�̳�SubmissionPublisher��ʵ��Processor�ӿ�
 * <p>
 * ����Դ���� integer, ���˵�С��0��, Ȼ��ת�����ַ���������ȥ
 */
public class FlowDemo2 {

    public static void main(String[] args) throws Exception {
        // 1. ���巢����, ���������������� Integer
        // ֱ��ʹ��jdk�Դ���SubmissionPublisher
        SubmissionPublisher<Integer> publiser = new SubmissionPublisher<Integer>();

        // 2. ���崦����, �����ݽ��й���, ��ת��ΪString����
        MyProcessor processor = new MyProcessor();

        // 3. ������ �� ������ �������Ĺ�ϵ
        publiser.subscribe(processor);

        // 4. �������ն�����, ���� String ��������
        Subscriber<String> subscriber = new Subscriber<String>() {

            private Subscription subscription;

            @Override
            public void onSubscribe(Subscription subscription) {
                // ���涩�Ĺ�ϵ, ��Ҫ����������������Ӧ
                this.subscription = subscription;

                // ����һ������
                this.subscription.request(1);
            }

            @Override
            public void onNext(String item) {
                // ���ܵ�һ������, ����
                System.out.println("���ܵ�����: " + item);

                // ���������request������һ������
                this.subscription.request(1);

                // ���� �Ѿ��ﵽ��Ŀ��, ����cancel���߷����߲��ٽ���������
                // this.subscription.cancel();
            }

            @Override
            public void onError(Throwable throwable) {
                // �������쳣(���紦�����ݵ�ʱ��������쳣)
                throwable.printStackTrace();

                // ���ǿ��Ը��߷�����, ���治����������
                this.subscription.cancel();
            }

            @Override
            public void onComplete() {
                // ȫ�����ݴ�������(�����߹ر���)
                System.out.println("��������!");
            }

        };

        // 5. ������ �� ���ն����� �������Ĺ�ϵ
//        processor.subscribe(subscriber);

        // 6. ��������, ������
        // �������������������
        publiser.submit(-111);
        publiser.submit(111);
        publiser.submit(1);
        publiser.submit(2);
        publiser.submit(3);
        publiser.submit(4);
        publiser.submit(5);
        publiser.submit(6);

        // 7. ������ �رշ�����
        // ��ʽ���� Ӧ�÷� finally ����ʹ�� try-resouce ȷ���ر�
        publiser.close();

        // ���߳��ӳ�ֹͣ, ��������û�����Ѿ��˳�
        Thread.currentThread().join(100000);
    }

}
