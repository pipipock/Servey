package survey.mapper;

import org.springframework.stereotype.Repository;
import survey.pojo.Admin;

import java.util.List;

@Repository
public interface AdminMapper {

    void insert(Admin admin);

    List<Admin> query(Admin admin);

    Admin queryOne(Admin admin);
}
