package com.shankar.example.fileDbApi.data;

import com.shankar.example.fileDbApi.model.Report;
import com.shankar.example.fileDbApi.model.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportsRepository extends CrudRepository<Report, Integer> {
    @Query("select r.id, r.col1, r.col3, r.col5, r.col7, r.col9 from REPORTS r")
    List<Object> getOddCols();
    @Query("select r.id, r.col2, r.col4, r.col6, r.col8, r.col10 from REPORTS r")
    List<Object> getEvenCols();
    @Query("select r from REPORTS r")
    List<Object> getAllCols();
    @Query("show columns from REPORTS r")
    List<Object> getCols();
}
//public interface UserRepository extends JpaRepository<User, Integer> {
//}