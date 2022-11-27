package com.example.springgeo

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.locationtech.jts.geom.Geometry

@Entity
@Table(name = "gio")
class GeoModel(
    @Id
    var index: Long?,
    @Column(name = "new_geometry2") val geometry: Geometry
)
