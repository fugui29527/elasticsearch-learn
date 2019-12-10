package com.hengxinyongli.model.dao;

import lombok.Data;

import java.util.Date;

/**
 * <一句话说明功能>
 * <功能详细描述>
 *
 * @author admin
 * @title <一句话说明功能>
 * @date 2019/12/4 16:43
 * @since <版本号>
 */
@Data
public class GameRecord {
    private long id;  //'主键',
    private String billNo;// '订单号',
    private String playerId; // '玩家id',
    private String platform; // '游戏平台',
    private int gameType;// '游戏类型',
    private String gameName; // '游戏名称',
    private Integer betNumber; // '投注金额',
    private Integer validBetNumber; // '有效投注金额',
    private Integer netNumber; //'盈亏金额',
    private Integer dml; // '打码量',
    private int flag; // '结算转态，1已结算，0未结算',
    private String expandStr;  // '扩展字段,每个平台的注单详细信息放此字段',
    private Date betTime; // '投注时间',
    private Date beijingTime;  // '北京时间',
    private Date createTime; // '创建时间',
    private Date updateTime;
    private double tax;
}
