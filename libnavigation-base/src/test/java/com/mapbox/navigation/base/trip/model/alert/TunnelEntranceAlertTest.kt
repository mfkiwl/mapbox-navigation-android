package com.mapbox.navigation.base.trip.model.alert

import com.mapbox.geojson.Point
import com.mapbox.navigation.testing.BuilderTest
import org.junit.Test

class TunnelEntranceAlertTest : BuilderTest<TunnelEntranceAlert, TunnelEntranceAlert.Builder>() {

    override fun getImplementationClass() = TunnelEntranceAlert::class

    override fun getFilledUpBuilder() = TunnelEntranceAlert.Builder(
        TunnelEntranceAlert.Metadata.Builder().build(), //todo
        Point.fromLngLat(10.0, 20.0),
        123.0
    ).alertGeometry(
        RouteAlertGeometry(
            456.0,
            Point.fromLngLat(11.0, 22.0),
            1,
            2,
            Point.fromLngLat(33.0, 44.0),
            3,
            4
        )
    )

    @Test
    override fun trigger() {
        // trigger, see KDoc
    }
}