package org.odk.collect.android.sms.base;

import org.odk.collect.android.tasks.sms.models.Message;
import org.odk.collect.android.tasks.sms.models.MessageStatus;
import org.odk.collect.android.tasks.sms.models.SmsSubmission;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Sample Data for SMS Tests
 */
public class SampleData {

    private SampleData() {
    }

    public static final String TEST_INSTANCE_ID = "test_instance";
    public static final String TEST_UNSENT_MESSAGE_INSTANCE_ID = "test_instance_unsent";

    public static SmsSubmission generateSampleModel() {

        SmsSubmission model = new SmsSubmission();

        model.setMessages(generateSampleMessages());
        model.setInstanceId(TEST_INSTANCE_ID);
        model.setLastUpdated(new Date());

        return model;
    }

    public static SmsSubmission generateUnsentSampleModel() {

        SmsSubmission model = new SmsSubmission();

        model.setMessages(generateUnsentSampleMessage());
        model.setInstanceId(TEST_UNSENT_MESSAGE_INSTANCE_ID);
        model.setLastUpdated(new Date());

        return model;
    }

    public static List<SmsSubmission> generateModels() {
        List<SmsSubmission> models = new ArrayList<>();
        models.add(generateSampleModel());
        models.add(generateUnsentSampleModel());

        return models;
    }

    public static List<Message> generateSampleMessages() {

        Message first = new Message();
        first.setMessageStatus(MessageStatus.Sent);
        first.setPart(1);
        first.generateRandomMessageID();
        first.setText("+N Joel Dean");

        Message second = new Message();
        second.setPart(2);
        second.setMessageStatus(MessageStatus.Ready);
        second.generateRandomMessageID();
        second.setText("+C America");

        Message third = new Message();
        third.setPart(2);
        third.setMessageStatus(MessageStatus.Ready);
        third.generateRandomMessageID();
        third.setText("+G Male");

        List<Message> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        return list;
    }

    public static List<Message> generateUnsentSampleMessage() {

        Message first = new Message();
        first.setMessageStatus(MessageStatus.FatalError);
        first.setPart(1);
        first.generateRandomMessageID();
        first.setText("+N Joel Dean");

        Message second = new Message();
        second.setPart(2);
        second.setMessageStatus(MessageStatus.Sent);
        second.generateRandomMessageID();
        second.setText("+C America");

        Message third = new Message();
        third.setPart(2);
        third.setMessageStatus(MessageStatus.Sent);
        third.generateRandomMessageID();
        third.setText("+G Male");

        List<Message> list = new ArrayList<>();
        list.add(first);
        list.add(second);
        list.add(third);

        return list;
    }
}
