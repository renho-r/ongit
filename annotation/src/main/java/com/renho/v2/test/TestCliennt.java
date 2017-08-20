package com.renho.v2.test;

import com.renho.v2.po.UserInfo;
import datastore.impl.Envelope;
import datastore.impl.MsgDataset;
import datastore.impl.MsgRow;

/**
 * @author renho
 * @since: 2017/8/18
 */
public class TestCliennt {

    public static void main(String[] args) {

        UserInfo user = new UserInfo(100, "renho", "addr");

        Envelope envelope = new Envelope();
        MsgDataset md = envelope.addDataset("HEADER", 100);
        MsgRow mr = md.addRow(1);

        mr.setItem(1, user.getId().toString());
        mr.setItem(2, user.getName());

        System.out.println(mr);
    }

}
