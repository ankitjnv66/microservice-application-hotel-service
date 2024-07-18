package com.cwa.hotel.controller;

import com.cwa.hotel.model.Hotel;
import com.cwa.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/saveHotel")
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
        Hotel createdHotel = this.hotelService.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
    }

    @GetMapping("/getHotelById/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String hotelId) {
        Hotel hotel = this.hotelService.getHotelById(hotelId);
        return ResponseEntity.ok(hotel);
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<List<Hotel>> fetchAll() {
        List<Hotel> hotels = this.hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    @DeleteMapping("/deleteHotelById/{hotelId}")
    public void deleteHotelById(@PathVariable("hotelId") String hotelId) {
        this.hotelService.deleteHotelById(hotelId);
    }
}
