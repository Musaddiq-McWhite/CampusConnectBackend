package za.ac.cput.campusconnect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.campusconnect.domain.Room;
import za.ac.cput.campusconnect.service.RoomService;

import java.util.List;
import java.util.Set;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Room room){
        Room created = roomService.create(room);
        if(created==null){
            return ResponseEntity.badRequest().body("Error creating Room");
        }
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PostMapping("/read{roomID}")
    public ResponseEntity<?> read(@PathVariable Long roomID){
        Room read = roomService.read(roomID);
        if (read==null){
            return ResponseEntity.badRequest().body("Room with Room ID: " + roomID + " does not exist");
        }
        return ResponseEntity.ok(read);
    }

    @PostMapping("/getAll")
    public List<Room> getAll(){
        return roomService.getAll();
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Room room){
        Room updatedRoom = roomService.create(room);
        if (updatedRoom==null){
            return ResponseEntity.badRequest().body("Error updating room");
        }
        return ResponseEntity.ok(updatedRoom);
    }
}
