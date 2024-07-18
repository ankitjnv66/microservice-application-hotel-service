package com.cwa.hotel.services.impl;

import com.cwa.hotel.exceptions.ResourceNotFoundException;
import com.cwa.hotel.model.Hotel;
import com.cwa.hotel.repository.HotelRepository;
import com.cwa.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return this.hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return this.hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String hotelId) {
        return this.hotelRepository.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found - " + hotelId));
    }

    @Override
    public void deleteHotelById(String hotelId) {
        this.hotelRepository.deleteById(hotelId);
    }
}
