package com.manodev.eventostec.api.controller;

import com.manodev.eventostec.api.domain.coupon.Coupon;
import com.manodev.eventostec.api.domain.coupon.CouponRequestDTO;
import com.manodev.eventostec.api.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/coupon")
public class CouponController {

    @Autowired
    private CouponService couponService;

    @PostMapping("/event/{eventId}")
    public ResponseEntity<Coupon> addCouponToEvent(@PathVariable UUID eventId, @RequestBody CouponRequestDTO data) {
        Coupon coupon = couponService.addCoupon(eventId, data);
        return ResponseEntity.ok(coupon);
    }
}
