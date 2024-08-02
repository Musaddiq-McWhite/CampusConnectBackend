package za.ac.cput.campusconnect.domain;

import jakarta.persistence.*;

import java.util.Objects;

/**
 * FileName.java
 * Class:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */
@Entity
public class Business {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long businessID;
    private String businessName;
    @Embedded
    private Contact contact;
    private String description;

    protected Business(){

    }
    private Business(Builder builder){
        this.businessID = builder.businessID;
        this.businessName = builder.businessName;
        this.contact = builder.contact;
        this.description = builder.description;

    }

    public Long getBusinessID() {
        return businessID;
    }

    public String getBusinessName() {
        return businessName;
    }

    public Contact getContact() {
        return contact;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Business business = (Business) o;
        return Objects.equals(businessID, business.businessID) && Objects.equals(businessName, business.businessName) && Objects.equals(contact, business.contact) && Objects.equals(description, business.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessID, businessName, contact, description);
    }

    @Override
    public String toString() {
        return "Business{" +
                "businessID='" + businessID + '\'' +
                ", businessName='" + businessName + '\'' +
                ", contact=" + contact +
                ", description='" + description + '\'' +
                '}';
    }
    public static class Builder{
        private Long businessID;
        private String businessName;
        private Contact contact;
        private String description;


        public Builder setBusinessID(Long businessID) {
            this.businessID = businessID;
            return this;
        }

        public Builder setBusinessName(String businessName) {
            businessName = businessName;
            return this;
        }

        public Builder setContact(Contact contact) {
            this.contact = contact;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder copy(Business business){
            this.businessID = business.businessID;
            this.businessName = business.businessName;
            this.contact= business.contact;
            this.description = business.description;
            return this ;

        }
        public Business build() {
            return new Business(this);
        }
    }
}



