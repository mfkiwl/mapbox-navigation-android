package com.mapbox.navigation.base.trip.model.alert

class UpcomingRouteAlert private constructor(
    val routeAlert: RouteAlert<*>,
    val distanceRemaining: Double
)
