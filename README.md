# Callboard API documentation

### Create advert 
**_POST api/advert/user/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id <br/>
body:<br/>
    
    {
      "title": "title",    
      "body": "body",    
      "category": "category",
      "phoneNumber": "phoneNumber"
    }
    
200 - returns successfully created advert
400 - Bad Request - advert will not be created

### Get advert 
**_GET api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id 

200 - returns advert
400 - Bad Request - there is no such advert

### Remove advert 
**_DELETE api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id <br/>

204 - returns empty content after successfull deletion 

### Get adverts list for user
**_GET api/advert/user/{id}_**

_Query parameters:_ <br/>
id - Long id <br/>

200 - returns list of adverts for user (if there are no adverts returns empty list)

### Create user
**_POST api/user_**<br/>

body:<br/>

    {
        "name": "name",
        "surname": "surname",
        "email": "email",
        "category": "category"
    }
    
200 - returns successfully created user
400 - Bad Request - user will not be created
