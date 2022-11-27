package com.example.springgeo

import org.springframework.data.jpa.repository.JpaRepository


interface GeoRepository: JpaRepository<GeoModel, Long>