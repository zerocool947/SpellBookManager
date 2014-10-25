package com.poorfellow.spellbookmanager.database;

public interface DatabaseObject {

	public long getId();
	public String getName();
	public void setName(String name);
	public void setId(long objectId);
}
