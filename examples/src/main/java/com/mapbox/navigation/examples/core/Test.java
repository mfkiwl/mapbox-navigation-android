package com.mapbox.navigation.examples.core;

import com.mapbox.navigation.base.trip.model.RouteProgress;
import com.mapbox.navigation.base.trip.model.alert.RouteAlert;
import com.mapbox.navigation.base.trip.model.alert.TunnelEntranceAlert;

public class Test {
    void main() {
        RouteProgress progress;
        RouteAlert<?> maneuver = progress.getUpcomingRouteAlerts().get(0).getRouteAlert();
        switch(maneuver.getType()) {
            case Incident:
                break;
            case TollCollectionPoint:
                break;
            case BorderCrossing:
                break;
            case TunnelEntrance:
                if (maneuver instanceof TunnelEntranceAlert) {
                    maneuver.getMetadata()
                }
                break;
            case RestrictedArea:
                break;
            case ServiceArea:
                break;
        }
    }
}
