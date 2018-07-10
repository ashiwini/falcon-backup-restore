package com.falcon.backup.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.joda.time.DateTime;

/**
 * DeviceConfiguration
 */
@Entity
public class DeviceConfiguration {
	@Id
	@SequenceGenerator(name = "deviceConfigId_generator", sequenceName = "deviceConfig_sequence", initialValue = 1)
	@GeneratedValue(generator = "deviceConfigId_generator")
	private Integer deviceConfigurationId;

	private String actionPollFrequency;

	private String configPollFrequency;

	private String edgeTimeZone;

	private String heartbitSendFrenquency;

	private DateTime creationDate;

	private DateTime lastModifiedDate;

	@OneToMany
	@JoinTable(name = "applieddeviceconfig", joinColumns = {
			@JoinColumn(name = "deviceConfigurationId", referencedColumnName = "deviceConfigurationId") }, inverseJoinColumns = {
					@JoinColumn(name = "deviceId", referencedColumnName = "deviceId", unique = true) })
	private List<Device> devices;

	public Integer getDeviceConfigurationId() {
		return deviceConfigurationId;
	}

	public void setDeviceConfigurationId(Integer deviceConfigurationId) {
		this.deviceConfigurationId = deviceConfigurationId;
	}

	public String getActionPollFrequency() {
		return actionPollFrequency;
	}

	public void setActionPollFrequency(String actionPollFrequency) {
		this.actionPollFrequency = actionPollFrequency;
	}

	public String getConfigPollFrequency() {
		return configPollFrequency;
	}

	public void setConfigPollFrequency(String configPollFrequency) {
		this.configPollFrequency = configPollFrequency;
	}

	public String getEdgeTimeZone() {
		return edgeTimeZone;
	}

	public void setEdgeTimeZone(String edgeTimeZone) {
		this.edgeTimeZone = edgeTimeZone;
	}

	public String getHeartbitSendFrenquency() {
		return heartbitSendFrenquency;
	}

	public void setHeartbitSendFrenquency(String heartbitSendFrenquency) {
		this.heartbitSendFrenquency = heartbitSendFrenquency;
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

}
