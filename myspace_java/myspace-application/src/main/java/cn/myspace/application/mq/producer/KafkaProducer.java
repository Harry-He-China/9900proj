package cn.myspace.application.mq.producer;

import cn.myspace.domain.goods.model.vo.OrderPartakeRecordVO;
import cn.myspace.domain.goods.model.vo.OrderVO;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.annotation.Resource;

/**
 * MQ服务发送消息
 */
@Component
public class KafkaProducer {

    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    @Resource
    private KafkaTemplate<String, Object> kafkaTemplate;

    /**
     * MQ主题：订单发货单
     *
     * 启动zk：bin/zookeeper-server-start.sh -daemon config/zookeeper.properties
     * 启动kafka：bin/kafka-server-start.sh -daemon config/server.properties
     * 创建topic：bin/kafka-topics.sh --create --zookeeper 172.17.0.5:2181 --replication-factor 1 --partitions 1 --topic myspace_order_invoice
     */
    public static final String TOPIC_ORDER_INVOICE = "myspace_order_invoice";

    /**
     * MQ主题：订单商品签收记录
     *
     * 创建 topic：bin/kafka-topics.sh --create --zookeeper 172.17.0.5:2181 --replication-factor 1 --partitions 1 --topic myspace_order_partake
     */
    public static final String TOPIC_ORDER_PARTAKE = "myspace_order_partake";

    /**
     * 发送订单发货单消息
     *
     * @param order 发货单
     */
    public ListenableFuture<SendResult<String, Object>> sendOrderInvoice(OrderVO order) {
        String objJson = JSON.toJSONString(order);
        logger.info("发送MQ消息(中奖发货单) topic：{} bizId：{} message：{}", TOPIC_ORDER_INVOICE, order.getOrderId(), objJson);
        return kafkaTemplate.send(TOPIC_ORDER_INVOICE, objJson);
    }

    /**
     * 发送订单商品签收记录消息
     *
     * @param orderPartakeRecord 订单商品签收记录
     */
    public ListenableFuture<SendResult<String, Object>> sendOrderPartakeRecord(OrderPartakeRecordVO orderPartakeRecord) {
        String objJson = JSON.toJSONString(orderPartakeRecord);
        logger.info("发送MQ消息(订单商品签收记录) topic：{} bizId：{} message：{}", TOPIC_ORDER_PARTAKE, orderPartakeRecord.getOrderId(), objJson);
        return kafkaTemplate.send(TOPIC_ORDER_PARTAKE, objJson);
    }

}
