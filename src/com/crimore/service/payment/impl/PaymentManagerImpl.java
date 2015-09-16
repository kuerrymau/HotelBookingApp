package com.crimore.service.payment.impl;

import com.crimore.domain.hotel.RoomType;
import com.crimore.service.payment.PaymentManager;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public class PaymentManagerImpl implements PaymentManager{

    @Override
    public float getRoomRateTotalForGuest(RoomType roomType, int numberOfGuests) {
        return roomType.getRoomRatePerDay() * numberOfGuests;
    }


}
