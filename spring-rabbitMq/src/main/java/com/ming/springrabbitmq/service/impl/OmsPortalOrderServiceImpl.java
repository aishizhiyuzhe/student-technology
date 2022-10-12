package com.ming.springrabbitmq.service.impl;

import com.ming.springrabbitmq.common.api.CommonResult;
import com.ming.springrabbitmq.component.CancelOrderSender;
import com.ming.springrabbitmq.dto.OrderParam;
import com.ming.springrabbitmq.service.OmsPortalOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OmsPortalOrderServiceImpl  implements OmsPortalOrderService {
    private final Logger logger= LoggerFactory.getLogger(OmsPortalOrderServiceImpl.class);
    @Resource
    CancelOrderSender cancelOrderSender;

    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        sendDelayMessageCancelOrder(11L);
        CommonResult commonResult=new CommonResult(200,"创建订单成功",11L);
        return commonResult;
    }

    @Override
    public void cancelOrder(Long orderId) {
        logger.debug("取消订单"+orderId);
    }

    private void sendDelayMessageCancelOrder(Long orderId) {
        //获取订单超时时间，假设为60分钟(测试用的30秒)
        long delayTimes = 1000;
        //发送延迟消息
        cancelOrderSender.sender(orderId, delayTimes);
    }
}
