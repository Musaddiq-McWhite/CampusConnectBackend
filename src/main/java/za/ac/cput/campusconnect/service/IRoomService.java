package za.ac.cput.campusconnect.service;

import za.ac.cput.campusconnect.domain.Room;

import java.util.List;

/**
 * FileName.java
 * Interface:
 * Author:
 * Completion date:
 */

public interface IRoomService {
    Room save(Room room);
    Room read(String roomID);
    List<Room> getAll();
    void deleteByID(String roomID);
}
