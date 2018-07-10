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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.joda.time.DateTime;

@Entity
@Access(value = AccessType.FIELD)
@Table(name = "packages")
public class Package {
	@Id
	@SequenceGenerator(name = "packageId_generator", sequenceName = "package_sequence", initialValue = 1)
	@GeneratedValue(generator = "packageId_generator")
	private Integer packageId;

	private String name;

	private String version;

	private DateTime creationDate;

	private DateTime lastModifiedDate;

	@OneToMany
	@JoinTable(name = "packageapps", joinColumns = {
			@JoinColumn(name = "packageId", referencedColumnName = "packageId") }, inverseJoinColumns = {
					@JoinColumn(name = "applicationId", referencedColumnName = "applicationId", unique = true) })
	private List<Application> applications = new ArrayList<Application>();

	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
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
