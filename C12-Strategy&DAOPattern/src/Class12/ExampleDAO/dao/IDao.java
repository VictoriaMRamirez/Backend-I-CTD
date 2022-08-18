package Class12.ExampleDAO.dao;

import java.util.List;

public interface IDao<T> {
    T save(T t);
    void delete(Long id);
    T search(Long id);
    List<T> findAll();

    /* Every persistent mechanism we implement must allow us to save it. If we
    do a generic dao, we can implement it in other classes. More useful. */
}
