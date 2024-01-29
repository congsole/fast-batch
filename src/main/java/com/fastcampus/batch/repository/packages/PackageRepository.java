package com.fastcampus.batch.repository.packages;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public interface PackageRepository extends JpaRepository<PackageEntity, Integer> {


    List<PackageEntity> findByCreatedAtAfter(LocalDateTime dateTime, Pageable pageable);


    @Transactional // update, delete 쿼리의 경우 필요한 어노테이션.
    @Modifying // 데이터가 변경되는 쿼리를 작성했을 때 이 어노테이션을 붙이지 않으면 에러 발생
    @Query(
            value = "UPDATE PackageEntity p " +
                    "SET p.count = :count, " +
                    "    p.period = :period " +
                    "WHERE p.packageSeq = :packageSeq"
    )
    int updateCountAndPeriod(@Param("packageSeq") Integer packageSeq, @Param("count") Integer count, @Param("period") Integer period);
}
