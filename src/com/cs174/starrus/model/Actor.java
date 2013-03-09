package com.cs174.starrus.model;

public class Actor{

	private int 	id;
	private String	name;
	private String	birthday;
	private boolean	director_Role;
	private boolean actor_Role;

	// Shared across the system
	private static Actor a = null;

	// Default Constructor
	private Actor(){}
	
	private static Actor getActor(){
		if( a == null){
			a = new Actor();
		}
		return a;
	}
	
	// 	role:
	//	Enter 1 for director
	//	Enter 2 for actor 
	public Actor( int id, String name, String birthday, int role){
		this.id		 = id;
		this.name	 = name;
		this.birthday= birthday;
		
		if( role == 1){
			director_Role 	= true;
			actor_Role		= false;
		}else if( role == 2){
			director_Role 	= false;
			actor_Role		= true;
		}
	}

	public int getID(){
		return this.id;
	}
		
	public String getName(){
		return this.name;
	}
		
	public String getBirthday(){
		return this.birthday;
	}

	public boolean isDirector(){
		return director_Role;
	}
	
	public boolean isActor(){
		return actor_Role;
	}

	// 	Returns 1 if diector
	// 	Returns 2 if actor
	public int getRole(){
		int returnVal = 0;
		if( director_Role){
			returnVal = 1;
		}
		else if(actor_Role){
			returnVal = 2;
		}
		return returnVal;
	}

	public void setID(int id){
		this.id = id;
	}
	
	public void setName(String name){
		this.name = name;
	}

	public void setBirthday(String Birthday){
		this.birthday = birthday;
	}

	public void setRole(int role){
		if( role == 1){
			director_Role 	= true;
			actor_Role		= false;
		} else if( role == 2){
			director_Role 	= false;
			actor_Role		= true;
		}
	}

	public void setDirector(){
		director_Role 	= true;
		actor_Role 		= false;
	}

	public void setActor(){
		director_Role	= false;
		actor_Role		= true;
	}

}
