package za.ac.cput.campusconnect.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Room;
import za.ac.cput.campusconnect.repository.RoomRepository;

import java.util.List;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */

@Service
public class RoomService implements IRoomService{
    private RoomRepository repository;

    @Autowired
    RoomService(RoomRepository repository){
        this.repository = repository;
    }

    @Override
    public Room save(Room room) {
        return repository.save(room);
    }

    @Override
    public Room read(String roomID) {
        return repository.findRoomByRoomID(roomID);
    }

    @Override
    public void deleteByID(String roomID) {
        repository.deleteById(roomID);
    }

    @Override
    public List<Room> getAll() {
        return repository.findAll();
    }
}
