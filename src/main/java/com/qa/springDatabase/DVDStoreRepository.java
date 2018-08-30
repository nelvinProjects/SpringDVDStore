package com.qa.springDatabase;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DVDStoreRepository extends JpaRepository<DVDStoreDVDSModel, Long >{

}
