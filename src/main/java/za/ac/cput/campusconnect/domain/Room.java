package za.ac.cput.campusconnect.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * FileName.java
 * Class:
 * Author:
 * Completion date:
 */

@Entity
public class Room {
    @Id
    private String roomID;
    @ManyToOne
    @JoinColumn(name = "propertyID", referencedColumnName = "propertyID")
    private Property property;
    private int roomNumber;
    private boolean occupied;

    public Room() {
    }

    public Room(Builder builder){
        this.roomID = builder.roomID;
        this.property = builder.property;
        this.roomNumber = builder.roomNumber;
        this.occupied = builder.occupied;
    }

    public String getRoomID() {
        return roomID;
    }

    public Property getProperty() {
        return property;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return roomNumber == room.roomNumber && occupied == room.occupied && Objects.equals(roomID, room.roomID) && Objects.equals(property, room.property);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomID, property, roomNumber, occupied);
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomID='" + roomID + '\'' +
                ", property=" + property +
                ", roomNumber=" + roomNumber +
                ", occupied=" + occupied +
                '}';
    }

    public static class Builder{
        private String roomID;
        private Property property;
        private int roomNumber;
        private boolean occupied;

        public Builder setRoomID(String roomID){
            this.roomID = roomID;
            return this;
        }

        public Builder setProperty(Property property){
            this.property = property;
            return this;
        }

        public Builder setRoomNumber(int roomNumber){
            this.roomNumber = roomNumber;
            return this;
        }

        public Builder setOccupied(Boolean occupied){
            this.occupied = occupied;
            return this;
        }

        public Builder copy(Room room){
            this.roomID = room.roomID;
            this.property = room.property;
            this.roomNumber = room.roomNumber;
            this.occupied = room.occupied;
            return this;
        }

        public Room build(){return new Room(this);}
    }
}
