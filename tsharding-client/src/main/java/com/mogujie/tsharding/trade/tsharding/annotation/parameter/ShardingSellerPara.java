package com.mogujie.tsharding.trade.tsharding.annotation.parameter;

/**
 * sharding参数注解
 * @auther qigong on 5/28/15 1:00 PM.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
/**
 * sharding计算用的Para sellerUserId
 */
public @interface ShardingSellerPara {
    String value() default "sellerUserId";
}
