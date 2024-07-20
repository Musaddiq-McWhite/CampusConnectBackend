package za.ac.cput.campusconnect.service;

import za.ac.cput.campusconnect.domain.Property;

import java.util.List;

/**
 * FileName.java
 * Interface:
 * Author:Aphelele Zimkhita Joka 218130260
 * Completion date:
 */

public interface IPropertyService  extends IService<Property, String>
{
    List<Property> getall();
}