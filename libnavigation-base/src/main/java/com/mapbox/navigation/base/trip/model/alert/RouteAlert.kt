package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point

sealed class RouteAlert<Metadata> constructor(
    val type: RouteAlertType,
    val metadata: Metadata,
    val coordinate: Point,
    val distance: Double,
    val alertGeometry: RouteAlertGeometry?
)

class TunnelEntranceAlert(
    metadata: Metadata,
    coordinate: Point,
    distance: Double,
    alertGeometry: RouteAlertGeometry?
) : RouteAlert<TunnelEntranceAlert.Metadata>(
    RouteAlertType.TunnelEntrance,
    metadata,
    coordinate,
    distance,
    alertGeometry
) {
    class Metadata(
        val tunnelName: String?
    )
}
