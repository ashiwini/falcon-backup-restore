package com.falcon.backup.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.joda.time.DateTime;

@Entity
@Access(value = AccessType.FIELD)
public class Action {

	@Id
	@SequenceGenerator(name = "actionId_generator", sequenceName = "action_sequence", initialValue = 1)
	@GeneratedValue(generator = "actionId_generator")
	private Integer actionId;

	private DateTime creationDate;

	private DateTime lastModifiedDate;

	private String actionType;

	private String executionStatus;

	@ManyToOne(targetEntity = Device.class)
	private Integer deviceId;

	@OneToMany
	@JoinTable(name = "actionapplication", joinColumns = {
			@JoinColumn(name = "actionId", referencedColumnName = "actionId") }, inverseJoinColumns = {
					@JoinColumn(name = "applicationId", referencedColumnName = "applicationId", unique = true) })
	private List<Application> applications = new ArrayList<>();

	public Integer getActionId() {
		return actionId;
	}

	public void setActionId(Integer actionId) {
		this.actionId = actionId;
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

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getExecutionStatus() {
		return executionStatus;
	}

	public void setExecutionStatus(String executionStatus) {
		this.executionStatus = executionStatus;
	}

	public Integer getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Integer deviceId) {
		this.deviceId = deviceId;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

}