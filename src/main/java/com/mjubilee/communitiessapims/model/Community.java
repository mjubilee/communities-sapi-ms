package com.mjubilee.communitiessapims.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

@Entity
public class Community {

	@Id
	@GeneratedValue
	@Column(nullable=false, updatable=false)
	private Long id;
	
	@Size(min=3, message="Minimum length of community name is 3 characters.")
	private String Name;

	@ManyToMany(mappedBy = "communityList")
	List<CommunityGroup> groupList;

	private boolean active;
	
	public Community() {
		super();
	}

	public Community(Long id, String name) {
		this(id, name, true);
	}

	public Community(Long id, String name, boolean active) {
		super();
		this.id = id;
		this.active = active;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public List<CommunityGroup> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<CommunityGroup> groupList) {
		this.groupList = groupList;
	}
	
	
}
