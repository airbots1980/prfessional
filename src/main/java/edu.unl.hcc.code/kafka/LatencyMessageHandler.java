package edu.unl.hcc.code.kafka;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kafka.consumer.BaseConsumerRecord;
import kafka.tools.MirrorMaker;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LatencyMessageHandler implements MirrorMaker.MirrorMakerMessageHandler {

    private static String TENANT = ",\"tenantid\":\"\\d{4}\",";

    private Logger log = LoggerFactory.getLogger(LatencyMessageHandler.class);;
    /**
     * The overrided interface method for this message handler.
     * @param record the incoming record
     * @return List of producer record
     */
    public List<ProducerRecord<byte[], byte[]>> handle(BaseConsumerRecord record) {
        return Collections.singletonList(emitRecord(record));
    }

    /**
     * The method used to massage each kafka record and corresponding transformation.
     * @param record the incoming record
     * @return ProducerRecord
     */
    ProducerRecord<byte[], byte[]> emitRecord(BaseConsumerRecord record) {
        long timestamp = getLatency(record);
        return new ProducerRecord<byte[], byte[]>(record.topic(),
            record.partition(),
            timestamp,
            record.key(),
            record.value(),
            record.headers());
    }

    /**
     * The method used to calculate latency and generate JMX message
     * @param record the incoming record
     */
    long getLatency(BaseConsumerRecord record) {
        Long timestamp = record.timestamp();
        System.out.println();
        if(timestamp != null) {
            String tenant = getTenant(record);
            log.info("Latency for record in Topic %s of Tenant %s is: %d",
                record.topic(),
                tenant,
                System.currentTimeMillis()/1000 - record.timestamp());
            return timestamp;
        }
        return System.currentTimeMillis()/1000;
    }

    /**
     * Get Tenant information from record and log it.
     * @param record the original message record from upper level.
     * @return tenant if find null of not found
     */
    String getTenant(BaseConsumerRecord record) {
        if(record != null) {
            String value = new String(record.value());
            Pattern p = Pattern.compile(TENANT);   // the pattern to search for
            Matcher m = p.matcher(value);
            if(m.find()) {
                return m.group(1);
            }
            return null;
        }
        return null;
    }
}
