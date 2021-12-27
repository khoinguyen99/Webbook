package com.example.webbook.respontories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webbook.entity.ThuongHieuEntity;

public interface ThuongHieuRespon extends JpaRepository<ThuongHieuEntity, Long> {
    
}
