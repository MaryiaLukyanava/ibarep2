package iba.repository;

import iba.entity.Buoy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BuoyRepository extends JpaRepository<Buoy, Long>{

}
