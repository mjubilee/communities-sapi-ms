package com.mjubilee.communitiessapims.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Size;

@Entity
public class CommunityGroup {

	@Id
	@GeneratedValue
	@Column(nullable=false, updatable=false)
	private Long id;
	
	@Size(min=3, message="Minimum length of group name is 3 characters.")
	private String Name;
	
	private boolean active;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	@JoinTable(name = "community_community_group",
			joinColumns = @JoinColumn(name = "community_group_id"),
			inverseJoinColumns = @JoinColumn( name = "community_id")
			)
	List<Community> communityList;
		
	public CommunityGroup() {
		super();
	}

	public CommunityGroup(Long id, String name) {
		 this(id, name, true);
	}

	public CommunityGroup(Long id, String name, boolean active) {
		super();
		this.id = id;
		Name = name;
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

	public List<Community> getCommunityList() {
		return communityList;
	}

	public void setCommunityList(List<Community> communityList) {
		this.communityList = communityList;
	}
		
	
}
