package com.uni.register.repository;

import com.uni.register.entity.RoutersEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author songning
 * @date 2020/4/27
 * description
 */
@Repository
public interface RoutersRepository extends JpaRepository<RoutersEntity, String> {

    @Override
    List<RoutersEntity> findAll();

    List<RoutersEntity> findAllByUrl(String url);

    List<RoutersEntity> findAllByRequestTypeAndUrl(String requestType, String Url);
}
