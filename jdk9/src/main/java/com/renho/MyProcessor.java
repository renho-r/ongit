package com.renho;

import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @author: xxxxx
 * @since: 1.0.0
 */
public class MyProcessor extends SubmissionPublisher<String>
        implements Flow.Processor<Integer, String> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        // ���涩�Ĺ�ϵ, ��Ҫ����������������Ӧ
        this.subscription = subscription;

        // ����һ������
        this.subscription.request(10);
    }

    @Override
    public void onNext(Integer item) {
        // ���ܵ�һ������, ����
        System.out.println("���������ܵ�����: " + item);

        // ���˵�С��0��, Ȼ�󷢲���ȥ
        if (item > 0) {
            this.submit("ת���������:" + item);
        }

        // ���������request������һ������
        this.subscription.request(10);

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
        System.out.println("��������������!");
        // �رշ�����
        this.close();
    }
}
