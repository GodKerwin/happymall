package com.xul.happymall.portal.domain

/**
 * Created by lxu on 2018/12/11.
 */
class Address {

    /**
     * 用户ID
     */
    Integer userId

    /**
     * 收货姓名
     */
    String receiverName

    /**
     * 收货固定电话
     */
    String receiverPhone

    /**
     * 收货移动电话
     */
    String receiverMobile

    /**
     * 省份
     */
    private String receiverProvince

    /**
     * 城市
     */
    private String receiverCity

    /**
     * 区/县
     */
    private String receiverDistrict

    /**
     * 详细地址
     */
    private String receiverAddress

    /**
     * 邮编
     */
    private String receiverZip

}