package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.index.Indexed;

/***
 * @description:
 * @author: yk
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    @Indexed
    private String city;

    @Indexed
    private String country;

}
