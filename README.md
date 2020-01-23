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

### Get advert 
**_GET api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id 

### Remove advert 
**_DELETE api/advert/{id}_**<br/>

_Query parameters:_ <br/>
id - Long id <br/>

### Get adverts list for user
**_GET api/advert/user/{id}_**

_Query parameters:_ <br/>
id - Long id <br/>

### Create user
**_POST api/user_**<br/>

body:<br/>

    {
        "name": "name",
        "surname": "surname",
        "email": "email",
        "category": "category"
    }
