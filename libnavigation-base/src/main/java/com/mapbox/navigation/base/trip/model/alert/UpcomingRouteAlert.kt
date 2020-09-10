package com.mapbox.navigation.base.trip.model.alert

class UpcomingRouteAlert private constructor(
    val routeAlert: RouteAlert<*>,
    val distanceRemaining: Double
) {

    fun toBuilder() = Builder(routeAlert, distanceRemaining)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UpcomingRouteAlert

        if (routeAlert != other.routeAlert) return false
        if (distanceRemaining != other.distanceRemaining) return false

        return true
    }

    override fun hashCode(): Int {
        var result = routeAlert.hashCode()
        result = 31 * result + distanceRemaining.hashCode()
        return result
    }

    override fun toString(): String {
        return "UpcomingRouteAlert(routeAlert=$routeAlert, distanceRemaining=$distanceRemaining)"
    }

    class Builder(
        private val routeAlert: RouteAlert<*>,
        private val distanceRemaining: Double
    ) {
        fun build() = UpcomingRouteAlert(routeAlert, distanceRemaining)
    }
}
