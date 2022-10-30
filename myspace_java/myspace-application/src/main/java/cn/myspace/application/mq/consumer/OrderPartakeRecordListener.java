package cn.myspace.application.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 抽奖活动领取记录监听消息
 */
@Component
public class OrderPartakeRecordListener {

    private Logger logger = LoggerFactory.getLogger(OrderPartakeRecordListener.class);

//    @Resource
//    private IActivityPartake activityPartake;
//
//    @KafkaListener(topics = "lottery_activity_partake", groupId = "lottery")
//    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        Optional<?> message = Optional.ofNullable(record.value());
//
//        // 0. 实际场景在消费MQ的时候，可以通过固定标识判断是否已经消费过，添加记录。对程序的处理会起到优化作用。
//
//        // 1. 判断消息是否存在
//        if (!message.isPresent()) {
//            return;
//        }
//
//        // 2. 转化对象（或者你也可以重写Serializer<T>）
//        ActivityPartakeRecordVO activityPartakeRecordVO = JSON.parseObject((String) message.get(), ActivityPartakeRecordVO.class);
//        logger.info("消费MQ消息，异步扣减活动库存 message：{}", message.get());
//
//        // 3. 更新数据库库存【实际场景业务体量较大，可能也会由于MQ消费引起并发，对数据库产生压力，所以如果并发量较大，可以把库存记录缓存中，并使用定时任务进行处理缓存和数据库库存同步，减少对数据库的操作次数】
//        activityPartake.updateActivityStock(activityPartakeRecordVO);
//
//        // 4. 消息消费完成
//        ack.acknowledge();
//    }

}
