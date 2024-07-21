package za.ac.cput.campusconnect.service;

import org.springframework.stereotype.Service;
import za.ac.cput.campusconnect.domain.Administrator;

import java.util.List;

/**
 * FileName.java
 * Interface:
 * Author:
 * Completion date:
 */
@Service
public interface IAdministratorService extends IService<Administrator,Integer> {
List<Administrator> getAll();
}
