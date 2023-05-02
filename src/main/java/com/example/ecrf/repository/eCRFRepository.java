package com.example.ecrf.repository;

import com.example.ecrf.model.eCRF1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface eCRFRepository extends JpaRepository<eCRF1, Long> {

    Optional<eCRF1> findById(Long id);

    @Query("SELECT e FROM eCRF1 e WHERE (LOWER(e.ecrfStatus) IS NULL OR LOWER(e.ecrfStatus) = 'draft') AND e.patId LIKE %:patIdStartsWith%")
    Page<eCRF1> findAllByEcrfStatusIsNullOrDraftAndPatIdStartsWith(@Param("patIdStartsWith") String patIdStartsWith, Pageable pageable);

    @Query("SELECT e FROM eCRF1 e WHERE (LOWER(e.ecrfStatus) = 'sent') AND e.patId LIKE %:patIdStartsWith%")
    Page<eCRF1> findByEcrfStatusAndPatIdStartsWith(@Param("patIdStartsWith") String patIdStartsWith, Pageable pageable);

    @Query("SELECT e FROM eCRF1 e WHERE (LOWER(e.ecrfStatus) = 'deleted') AND e.patId LIKE  %:patIdStartsWith%")
    Page<eCRF1> findAllByEcrfStatusIsDeleteAndPatIdStartsWith(@Param("patIdStartsWith") String patIdStartsWith, Pageable pageable);

}
