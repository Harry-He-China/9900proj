package cn.myspace.application.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 中奖发货单监听消息
 */
@Component
public class OrderInvoiceListener {

    private Logger logger = LoggerFactory.getLogger(OrderInvoiceListener.class);

//    @Resource
//    private DistributionGoodsFactory distributionGoodsFactory;
//
//    @KafkaListener(topics = "lottery_invoice", groupId = "lottery")
//    public void onMessage(ConsumerRecord<?, ?> record, Acknowledgment ack, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
//        Optional<?> message = Optional.ofNullable(record.value());
//
//        // 1. 判断消息是否存在
//        if (!message.isPresent()) {
//            return;
//        }
//
//        // 2. 处理 MQ 消息
//        try {
//            // 1. 转化对象（或者你也可以重写Serializer<T>）
//            InvoiceVO invoiceVO = JSON.parseObject((String) message.get(), InvoiceVO.class);
//
//            // 2. 获取发送奖品工厂，执行发奖
//            IDistributionGoods distributionGoodsService = distributionGoodsFactory.getDistributionGoodsService(invoiceVO.getAwardType());
//            DistributionRes distributionRes = distributionGoodsService.doDistribution(new GoodsReq(invoiceVO.getuId(), invoiceVO.getOrderId(), invoiceVO.getAwardId(), invoiceVO.getAwardName(), invoiceVO.getAwardContent()));
//
//            Assert.isTrue(Constants.AwardState.SUCCESS.getCode().equals(distributionRes.getCode()), distributionRes.getInfo());
//
//            // 3. 打印日志
//            logger.info("消费MQ消息，完成 topic：{} bizId：{} 发奖结果：{}", topic, invoiceVO.getuId(), JSON.toJSONString(distributionRes));
//
//            // 4. 消息消费完成
//            ack.acknowledge();
//        } catch (Exception e) {
//            // 发奖环节失败，消息重试。所有到环节，发货、更新库，都需要保证幂等。
//            logger.error("消费MQ消息，失败 topic：{} message：{}", topic, message.get());
//            throw e;
//        }
//    }

}