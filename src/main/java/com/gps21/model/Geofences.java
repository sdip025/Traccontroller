package com.gps21.model;

// Generated Mar 16, 2017 3:16:37 PM by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Geofences generated by hbm2java
 */
@Entity
@Table(name = "geofences", catalog = "traccar")
public class Geofences implements java.io.Serializable {

	private Long id;
	private Boolean allDevices;
	private String color;
	private String description;
	private String name;
	private String points;
	private float radius;
	private String type;
	private Set<Users> userses = new HashSet<Users>(0);
	private Set<Events> eventses = new HashSet<Events>(0);
	private Set<Reports> reportses = new HashSet<Reports>(0);
	private Set<Devices> deviceses = new HashSet<Devices>(0);

	public Geofences() {
	}

	public Geofences(float radius) {
		this.radius = radius;
	}

	public Geofences(Boolean allDevices, String color, String description,
			String name, String points, float radius, String type,
			Set<Users> userses, Set<Events> eventses, Set<Reports> reportses,
			Set<Devices> deviceses) {
		this.allDevices = allDevices;
		this.color = color;
		this.description = description;
		this.name = name;
		this.points = points;
		this.radius = radius;
		this.type = type;
		this.userses = userses;
		this.eventses = eventses;
		this.reportses = reportses;
		this.deviceses = deviceses;
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

	@Column(name = "allDevices")
	public Boolean getAllDevices() {
		return this.allDevices;
	}

	public void setAllDevices(Boolean allDevices) {
		this.allDevices = allDevices;
	}

	@Column(name = "color")
	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Column(name = "description")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "points", length = 2048)
	public String getPoints() {
		return this.points;
	}

	public void setPoints(String points) {
		this.points = points;
	}

	@Column(name = "radius", nullable = false, precision = 12, scale = 0)
	public float getRadius() {
		return this.radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Column(name = "type")
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_geofences", catalog = "traccar", joinColumns = { @JoinColumn(name = "geofence_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<Users> getUserses() {
		return this.userses;
	}

	public void setUserses(Set<Users> userses) {
		this.userses = userses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "geofences")
	public Set<Events> getEventses() {
		return this.eventses;
	}

	public void setEventses(Set<Events> eventses) {
		this.eventses = eventses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "reports_geofences", catalog = "traccar", joinColumns = { @JoinColumn(name = "geofence_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "report_id", nullable = false, updatable = false) })
	public Set<Reports> getReportses() {
		return this.reportses;
	}

	public void setReportses(Set<Reports> reportses) {
		this.reportses = reportses;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "devices_geofences", catalog = "traccar", joinColumns = { @JoinColumn(name = "geofence_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "device_id", nullable = false, updatable = false) })
	public Set<Devices> getDeviceses() {
		return this.deviceses;
	}

	public void setDeviceses(Set<Devices> deviceses) {
		this.deviceses = deviceses;
	}

}
