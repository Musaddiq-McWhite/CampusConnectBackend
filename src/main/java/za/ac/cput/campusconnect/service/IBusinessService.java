package za.ac.cput.campusconnect.service;
import za.ac.cput.campusconnect.domain.Business;

import java.util.List;

/**
 * FileName.java
 * Interface:
 * Author: Aphelele Zimkhita Joka 218130260
 * Completion date:
 */

public interface IBusinessService extends IService <Business, String>{
    List<Business> getall();
}
