package com.example.springgeo

import org.locationtech.jts.geom.Polygon
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = ["*"])
class SpringGeoController(
    private val geoRepository: GeoRepository
) {
    @GetMapping("/abc")
    fun test() = geoRepository.findAll().run {
        filter { it.geometry.geometryType == "Polygon" } .map { it.geometry.coordinates.map { LatLng(it.x, it.y) } }.let {
            ResponseEntity.ok(it)
        }
    }
}

data class LatLng(
    val lat: Double,
    val lng: Double
)