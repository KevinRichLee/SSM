package cn.edu.aynu.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors
public class Bill implements Serializable {
    private Integer bid;
    private String bill_code;
    private String bill_name;
    private String bill_com;
    private Integer bill_num;
    private double money;
    private Integer pay;
    private Integer pid;
    private Date create_date;
}
