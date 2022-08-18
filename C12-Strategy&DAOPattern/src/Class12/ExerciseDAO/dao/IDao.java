package Class12.ExerciseDAO.dao;

public interface IDao<T> {
    T save(T t);
    T search(Long id);
}
