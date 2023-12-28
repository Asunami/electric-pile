package com.qifa.pileportal.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AliPay {
    private Integer tradeNo;
    private BigDecimal totalAmount;
    private String subject;
    private String alipayTradeNo;
}
