package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point

class RouteAlertGeometry private constructor(
    val length: Double,
    val startCoordinate: Point,
    val startShapeIndex: Int,
    val startLegIndex: Int,
    val endCoordinate: Point,
    val endShapeIndex: Int,
    val endLegIndex: Int
) {

    fun toBuilder() = Builder(
        length,
        startCoordinate,
        startShapeIndex,
        startLegIndex,
        endCoordinate,
        endShapeIndex,
        endLegIndex
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RouteAlertGeometry

        if (length != other.length) return false
        if (startCoordinate != other.startCoordinate) return false
        if (startShapeIndex != other.startShapeIndex) return false
        if (startLegIndex != other.startLegIndex) return false
        if (endCoordinate != other.endCoordinate) return false
        if (endShapeIndex != other.endShapeIndex) return false
        if (endLegIndex != other.endLegIndex) return false

        return true
    }

    override fun hashCode(): Int {
        var result = length.hashCode()
        result = 31 * result + startCoordinate.hashCode()
        result = 31 * result + startShapeIndex
        result = 31 * result + startLegIndex
        result = 31 * result + endCoordinate.hashCode()
        result = 31 * result + endShapeIndex
        result = 31 * result + endLegIndex
        return result
    }

    override fun toString(): String {
        return "RouteAlertGeometry(" +
            "length=$length," +
            "startCoordinate=$startCoordinate," +
            "startShapeIndex=$startShapeIndex," +
            "startLegIndex=$startLegIndex," +
            "endCoordinate=$endCoordinate," +
            "endShapeIndex=$endShapeIndex," +
            "endLegIndex=$endLegIndex)"
    }

    class Builder(
        private val length: Double,
        private val startCoordinate: Point,
        private val startShapeIndex: Int,
        private val startLegIndex: Int,
        private val endCoordinate: Point,
        private val endShapeIndex: Int,
        private val endLegIndex: Int
    ) {
        fun build() = RouteAlertGeometry(
            length,
            startCoordinate,
            startShapeIndex,
            startLegIndex,
            endCoordinate,
            endShapeIndex,
            endLegIndex
        )
    }
}
