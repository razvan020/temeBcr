package model.interfaces;

import model.enums.ShippingStatus;
import java.time.LocalDateTime;

public interface Trackable {

    String getTrackingId();

    ShippingStatus getCurrentStatus();

    void updateStatus(ShippingStatus status);

    LocalDateTime getLastUpdated();

    String getCurrentLocation();

    void updateLocation(String location);
}