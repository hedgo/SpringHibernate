package com.hedgo.dbtests.dao;

        import com.hedgo.dbtests.model.User;
        import org.springframework.data.jpa.repository.JpaRepository;

public interface UserSpringDataDAO extends JpaRepository<User,Long> {
}
