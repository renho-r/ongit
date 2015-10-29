package com.renho;

import java.net.UnknownHostException;
import java.util.Set;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

public class Client {

	public static void main(String[] args) throws UnknownHostException, MongoException {
		// ���ӱ������ݿ�
		Mongo m = new Mongo("192.168.0.107", 27017);
		// ������Ϊnew_test_db�����ݿ�
		DB db = m.getDB("new_test_db");
		// ��ȡnew_test_db�еļ��ϣ������ڻ�ȡ��ϵ���ݿ��еı�
		Set<String> cols = db.getCollectionNames();
		// ��ӡ��new_test_db�еļ��ϣ�����Ӧ��Ϊnull
		for (String s : cols) {
			System.out.println(s);
		}
		// ����һ������"new_test_col"�ļ���
		DBCollection collection = db.getCollection("new_test_col");
		// ��ʼ��һ������DB�������ղ������ݿ�ľ������DB����
		BasicDBObject obj = new BasicDBObject();
		// ���뼸����ֵ��
		obj.put("from", "���");
		obj.put("to", "����");
		obj.put("subject", "���Ӱ�����");
		// �������
		collection.insert(obj);
		// �鿴һ����¼��findOne()=find().limit(1);
		DBObject dbobj = collection.findOne();
		// ��ӡ���ղŲ��������
		System.out.println(dbobj);
		// ��������������9��{ranking:i}������
		for (int i = 0; i < 9; i++) {
			collection.insert(new BasicDBObject().append("ranking", i));
		}
		// ��ӡ�����е���������������Ӧ�����10
		System.out.println(collection.getCount());
		// �����������������ϣ�find()�������ص���һ���α�(cursor)������ĸ���͹�ϵ���ݿ������
		DBCursor cursor = collection.find();
		// Ȼ������ʹ������α�����������
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		// ��������һЩ�Ը���һ��Ĳ�ѯ���ɣ���һ�����򵥵�������ѯ����ѯrankingΪ1�ļ�¼
		BasicDBObject query = new BasicDBObject();
		query.put("ranking", 1);
		cursor = collection.find(query);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		// �����Ǹ����ӵ�������ѯ����ѯranking����5С��9�ļ�¼
		query = new BasicDBObject();
		query.put("ranking", new BasicDBObject("$gt", 5).append("$lt", 9));
		cursor = collection.find(query);
		while (cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		// ���ɾ�����ǵĲ������ݿ�
		m.dropDatabase("new_test_db");
	}
}
