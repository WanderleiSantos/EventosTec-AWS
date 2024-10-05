package com.manodev.eventostec.api.domain.coupon;

public record CouponRequestDTO (String code, Integer discount, Long valid){
}
