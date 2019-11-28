package com.fh.vue.utils;

public enum ResponseEnum {
    SUCCESS(200,"操作成功"),
    ERROR(1000,"操作失败"),
    CODE_ERROR(1001,"验证码错误"),
    PRODUCT_IS_NOT_EXIST(1002,"商品不存在"),
    PRODUCT_IS_DOWN(1003,"商品已下架"),
    CART_KEY_NULL(1004,"购物车不存在"),
    CART_ALL_STOCK_SHORT(1005,"购物车所有商品都库存不足"),
    PAY_REDER_NO_EXIST(1006,"支付订单不存在"),
    ;
    private int code;
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
