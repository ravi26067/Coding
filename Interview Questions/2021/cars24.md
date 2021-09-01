# Kids Tracking Application

We are building a location tracking platform for parents/guardians/siblings/etc so that they can track their children via that. We want to support both live tracking as well as history here. Design backend architecture for it. 


Tracking 

List<Users> user/lists

Get
Location track/{user_id}


GET List<Location> track/history/

query params
  user_id: "xyz",
  startDate: ,
  endDate: ,
  

Post user/{user_id}

{ 
  Location{
  }
  time
}

websocket Mapper - {parentid - childId}

parent ---- websocket server


child -> child microservice(post api) -> db 

child microservice(post api) -> queue -> db 


db design

* CHoice of db
** Scale -
*** Sharding based on location
*** Master slave

NoSQL
* Provides large scaling by default
* We have clusters there.

** Structure - 
** Query Pattern


User{
name,
id,
}


Location{
  double lat,
  double long,
}



LocationHistory{
  userid;
  Map<startTime, Location> locations;
}






