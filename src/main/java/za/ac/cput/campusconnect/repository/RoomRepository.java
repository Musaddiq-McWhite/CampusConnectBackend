package za.ac.cput.campusconnect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.campusconnect.domain.Room;

import java.util.List;

/**
 * FileName.java
 * Interface:
 * Author:
 * Completion date:
 */

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    Room findRoomByRoomID(Long roomID);
    //List<Room> findAllByOccupiedIsTrue(Boolean occupied);
    //List<Room> findAllByOccupiedIsFalse(Boolean occupied);
}
