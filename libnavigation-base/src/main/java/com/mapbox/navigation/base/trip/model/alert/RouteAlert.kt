package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point

sealed class RouteAlert<Metadata>(
    val type: RouteAlertType,
    val metadata: Metadata,
    val coordinate: Point,
    val distance: Double,
    val alertGeometry: RouteAlertGeometry?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RouteAlert<*>

        if (type != other.type) return false
        if (metadata != other.metadata) return false
        if (coordinate != other.coordinate) return false
        if (distance != other.distance) return false
        if (alertGeometry != other.alertGeometry) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + (metadata?.hashCode() ?: 0)
        result = 31 * result + coordinate.hashCode()
        result = 31 * result + distance.hashCode()
        result = 31 * result + (alertGeometry?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "RouteAlert(type=$type, metadata=$metadata, coordinate=$coordinate, distance=$distance, alertGeometry=$alertGeometry)"
    }
}

class TunnelEntranceAlert private constructor(
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

    fun toBuilder(): Builder = Builder(metadata, coordinate, distance).alertGeometry(alertGeometry)

    override fun toString(): String {
        return "TunnelEntranceAlert() ${super.toString()}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false
        return true
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    class Builder(
        private val metadata: Metadata,
        private val coordinate: Point,
        private val distance: Double
    ) {
        private var alertGeometry: RouteAlertGeometry? = null

        fun alertGeometry(alertGeometry: RouteAlertGeometry?): Builder = apply {
            this.alertGeometry = alertGeometry
        }

        fun build() = TunnelEntranceAlert(metadata, coordinate, distance, alertGeometry)
    }

    class Metadata private constructor(
        val tunnelName: String?
    ) {
        class Builder {
            private var tunnelName: String? = null

            fun tunnelName(tunnelName: String?): Builder = apply { this.tunnelName = tunnelName }

            fun build() = Metadata(tunnelName)
        }
    }
}
