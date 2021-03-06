package com.gps21.model;

// Generated Mar 16, 2017 3:16:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Events generated by hbm2java
 */
@Entity
@Table(name = "events", catalog = "traccar")
public class Events implements java.io.Serializable {

	private Long id;
	private Positions positions;
	private Devices devices;
	private Geofences geofences;
	private Maintenances maintenances;
	private Boolean expired;
	private boolean notificationSent;
	private Date time;
	private String type;

	public Events() {
	}

	public Events(boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	public Events(Positions positions, Devices devices, Geofences geofences,
			Maintenances maintenances, Boolean expired,
			boolean notificationSent, Date time, String type) {
		this.positions = positions;
		this.devices = devices;
		this.geofences = geofences;
		this.maintenances = maintenances;
		this.expired = expired;
		this.notificationSent = notificationSent;
		this.time = time;
		this.type = type;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "position_id")
	public Positions getPositions() {
		return this.positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "device_id")
	public Devices getDevices() {
		return this.devices;
	}

	public void setDevices(Devices devices) {
		this.devices = devices;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "geoFence_id")
	public Geofences getGeofences() {
		return this.geofences;
	}

	public void setGeofences(Geofences geofences) {
		this.geofences = geofences;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "maintenance_id")
	public Maintenances getMaintenances() {
		return this.maintenances;
	}

	public void setMaintenances(Maintenances maintenances) {
		this.maintenances = maintenances;
	}

	@Column(name = "expired")
	public Boolean getExpired() {
		return this.expired;
	}

	public void setExpired(Boolean expired) {
		this.expired = expired;
	}

	@Column(name = "notificationSent", nullable = false)
	public boolean isNotificationSent() {
		return this.notificationSent;
	}

	public void setNotificationSent(boolean notificationSent) {
		this.notificationSent = notificationSent;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", length = 19)
	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
