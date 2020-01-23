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
    
200 - returns successfully created advert <br/>
400 - bad request - advert will not be created <br/>

### Get advert 
**_GET api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id 

200 - returns advert<br/>
400 - bad request - there is no such advert<br/>

### Remove advert 
**_DELETE api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id <br/>

204 - no content

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
    
200 - returns successfully created user<br/>
400 - bad request - user will not be created<br/>
