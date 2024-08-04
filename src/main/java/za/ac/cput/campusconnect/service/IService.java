package za.ac.cput.campusconnect.service;

import org.springframework.stereotype.Service;

@Service
public interface IService <Object, PKey> {

    Object create(Object obj);

    Object read(PKey pKey);

    Object update(Object obj);
}


