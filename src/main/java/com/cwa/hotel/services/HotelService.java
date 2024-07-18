package com.cwa.hotel.services;

import com.cwa.hotel.model.Hotel;

import java.util.List;


public interface HotelService {

    //create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAllHotels();

    //getById
    Hotel getHotelById(String hotelId);

    //delete
    void deleteHotelById(String hotelId);
}
