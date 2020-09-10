package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point

sealed class RouteAlert<M> constructor(
    val type: RouteAlertType,
    val metadata: M,
    val coordinate: Point,
    val distance: Double
)

sealed class SpanningRouteAlert<M : SpanningRouteAlert.Metadata>(
    type: RouteAlertType,
    metadata: M,
    coordinate: Point,
    distance: Double,
    val length: Double
) : RouteAlert<M>(
    type,
    metadata,
    coordinate,
    distance
) {
    open class Metadata(
        val startCoordinate: Point,
        val startShapeIndex: Int,
        val startLegIndex: Int,
        val endCoordinate: Point,
        val endShapeIndex: Int,
        val endLegIndex: Int
    )
}

class TunnelEntranceAlert(
    metadata: Metadata,
    coordinate: Point,
    distance: Double,
    length: Double
) : SpanningRouteAlert<TunnelEntranceAlert.Metadata>(
    RouteAlertType.TunnelEntrance,
    metadata,
    coordinate,
    distance,
    length
) {
    class Metadata(
        startCoordinate: Point,
        startShapeIndex: Int,
        startLegIndex: Int,
        endCoordinate: Point,
        endShapeIndex: Int,
        endLegIndex: Int,
        val tunnelName: String?
    ) : SpanningRouteAlert.Metadata(
        startCoordinate,
        startShapeIndex,
        startLegIndex,
        endCoordinate,
        endShapeIndex,
        endLegIndex
    )
}
