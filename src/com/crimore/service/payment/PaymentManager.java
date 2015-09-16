package com.crimore.service.payment;

import com.crimore.domain.hotel.RoomType;

/**
 * Created by cchingwenje on 2015-09-13.
 */
public interface PaymentManager {

    float getRoomRateTotalForGuest(RoomType roomType, int numberOfGuests);
}
