package edu.unl.hcc.code.kafka;

import java.util.prefs.BackingStoreException;
import kafka.consumer.BaseConsumerRecord;
import kafka.consumer.BaseConsumerRecord$;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeaders;
import org.apache.kafka.common.record.TimestampType;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Unit tests for testing the LatencyMessageHandler
 */
public class LatencyMessageHandlerTests {

    LatencyMessageHandler lmh = new LatencyMessageHandler();;
    BaseConsumerRecord record;
    byte[] keyBytes;
    byte[] valBytes;

    @Before
    public void setup() {
        keyBytes = "mockKey".getBytes();
        valBytes = "mockValue".getBytes();
        record = new BaseConsumerRecord("mockTopic",
            1, 0,
            System.currentTimeMillis()/1000-512,
            TimestampType.NO_TIMESTAMP_TYPE,
            keyBytes,
            valBytes,
            new RecordHeaders());
    }

    @Test
    public void testGetLatency() {
        Assert.assertTrue(System.currentTimeMillis()/1000
            - lmh.getLatency(this.record) >= 512);
    }

    @Test
    public void testEmitRecord(){
        ProducerRecord<byte[], byte[]> pr = lmh.emitRecord(this.record);
        Assert.assertEquals((long)pr.partition(),1);
        Assert.assertNotNull(pr.headers());
        Assert.assertEquals(pr.key(), keyBytes);
        Assert.assertEquals(pr.value(), valBytes);
        Assert.assertTrue((System.currentTimeMillis()/1000
            - pr.timestamp()) >= 512);
    }
}
