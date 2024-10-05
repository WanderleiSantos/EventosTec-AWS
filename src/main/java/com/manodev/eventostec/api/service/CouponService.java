package com.manodev.eventostec.api.service;

import com.manodev.eventostec.api.domain.coupon.Coupon;
import com.manodev.eventostec.api.domain.coupon.CouponRequestDTO;
import com.manodev.eventostec.api.domain.event.Event;
import com.manodev.eventostec.api.repositories.CouponRepository;
import com.manodev.eventostec.api.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private EventRepository eventRepository;

    public Coupon addCoupon(UUID eventId, CouponRequestDTO couponData) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));

        Coupon coupon = new Coupon();
        coupon.setCode(couponData.code());
        coupon.setDiscount(couponData.discount());
        coupon.setValid(new Date(couponData.valid()));
        coupon.setEvent(event);

        return couponRepository.save(coupon);

    }
}
