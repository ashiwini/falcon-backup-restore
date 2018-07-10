package com.falcon.backup.entities;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import org.joda.time.DateTime;

@Entity
@Access(value = AccessType.FIELD)
public class Device {

	@Id
	private Integer deviceId;

	private Integer createdBy;

	private DateTime creationDate;

	private String lastModifiedBy;

	private DateTime lastModifiedDate;

	private String name;

	private String token;

	private DateTime lastSeenDate;

	private Boolean isOnline;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "deviceId")
	private List<Action> actions;

	@OneToMany
	@JoinTable(name = "deviceapplications", joinColumns = {
			@JoinColumn(name = "deviceId", referencedColumnName = "deviceId") }, inverseJoinColumns = {
					@JoinColumn(name = "applicationId", referencedColumnName = "applicationId", unique = true) })
	private List<Application> applications;

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public DateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(DateTime creationDate) {
		this.creationDate = creationDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public DateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(DateTime lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public DateTime getLastSeenDate() {
		return lastSeenDate;
	}

	public void setLastSeenDate(DateTime lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}

	public Boolean getIsOnline() {
		return isOnline;
	}

	public void setIsOnline(Boolean isOnline) {
		this.isOnline = isOnline;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}
