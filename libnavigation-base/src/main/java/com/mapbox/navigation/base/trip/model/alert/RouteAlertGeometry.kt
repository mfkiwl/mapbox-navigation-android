package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point

class RouteAlertGeometry(
    val length: Double,
    val startCoordinate: Point,
    val startShapeIndex: Int,
    val startLegIndex: Int,
    val endCoordinate: Point,
    val endShapeIndex: Int,
    val endLegIndex: Int
)
