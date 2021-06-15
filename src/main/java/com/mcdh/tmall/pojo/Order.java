package com.mcdh.tmall.pojo;

import com.mcdh.tmall.service.Impl.OrderServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    private int id;

    private String orderCode;
    private String address;
    private String post;
    private String receiver;
    private String mobile;
    private String userMessage;
    private Date createDate;
    private Date payDate;
    private Date deliveryDate;
    private Date confirmDate;
    private String status;

    private User user;
    private String statusDesc;

    private List<OrderItem> orderItems;
    private double total;
    private int totalNumber;

    public String getStatusDesc(){
        if(null!=statusDesc)
            return statusDesc;
        String desc ="未知";
        switch(status){
            case OrderServiceImpl.waitPay:
                desc="待付";
                break;
            case OrderServiceImpl.waitDelivery:
                desc="待发";
                break;
            case OrderServiceImpl.waitConfirm:
                desc="待收";
                break;
            case OrderServiceImpl.waitReview:
                desc="等评";
                break;
            case OrderServiceImpl.finish:
                desc="完成";
                break;
            case OrderServiceImpl.delete:
                desc="刪除";
                break;
            default:
                desc="未知";
        }
        statusDesc = desc;
        return statusDesc;
    }
}
