package com.falcon.backup.entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.joda.time.DateTime;

@Entity
@Access(value = AccessType.FIELD)
public class User {

	@Id
	@SequenceGenerator(name = "userId_generator", sequenceName = "user_sequence", initialValue = 1)
	@GeneratedValue(generator = "userId_generator")
	private Integer userId;

	private String username;

	private DateTime creationDate;

	private DateTime lastModifiedDate;

	@OneToMany
	@JoinTable(name = "userdevices", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "userId") }, inverseJoinColumns = {
					@JoinColumn(name = "deviceId", referencedColumnName = "deviceId", unique = true) })
	private List<Device> devices;

	@OneToMany
	@JoinTable(name = "userapplications", joinColumns = {
			@JoinColumn(name = "userId", referencedColumnName = "userId") }, inverseJoinColumns = {
					@JoinColumn(name = "applicationId", referencedColumnName = "applicationId", unique = true) })
	private List<Application> applications;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}
}
