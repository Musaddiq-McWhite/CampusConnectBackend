package za.ac.cput.campusconnect.service;

public interface IService <T, ID> {
    T create(T t);

    T read(ID id);

    T update(T t);

}
