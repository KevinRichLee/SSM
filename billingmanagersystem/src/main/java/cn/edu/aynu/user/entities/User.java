package cn.edu.aynu.user.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/14
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class User {
    private Integer id;
    private String username;
    private String real_name;
    private String password;
    private Integer gender;
    private Date birthday;
    private Integer user_type;
}


