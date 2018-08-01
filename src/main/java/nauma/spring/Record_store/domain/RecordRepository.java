package nauma.spring.Record_store.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RecordRepository extends CrudRepository<Record, Long> {

    List<Record> findByTitle(String Title);
    
}