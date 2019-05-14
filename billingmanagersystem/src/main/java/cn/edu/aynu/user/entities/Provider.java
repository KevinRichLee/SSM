package cn.edu.aynu.user.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * company: www.abc.com
 * Author: KevinLee
 * Create Data: 2019/3/15
 */
@NoArgsConstructor
@Data
@Accessors
public class Provider {
    private Integer pid;
    private String provider_code;
    private String providerName;
    private String people;
    private String phone;
    private String address;
    private String fax;
    private String describes;
    private Date create_date;

    public Provider(String provider_code, String providerName, String people, String phone, String address, String fax, String describes, Date create_date) {
        this.provider_code = provider_code;
        this.providerName = providerName;
        this.people = people;
        this.phone = phone;
        this.address = address;
        this.fax = fax;
        this.describes = describes;
        this.create_date = create_date;
    }
}
