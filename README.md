# IPBlacklistMonitor
IP Blacklist Monitor Backend REST API



It is Sprint Boot standalone application created with Spring MVC, JPA and H2 embedded database.

Application by default runs on embedded tomcat sever at http://localhost:8080 url

Below are the details of the REST endpoint URLs with sample request/response.

1)Add a filtering configuration to the blacklist

 REST URL: http://localhost:8080/api/v1/ip METHOD: POST SAMPLE JSON REQUEST PAYLOAD: 
	    {
	        "hostAddress": "332.22.23.33",
	        "hostName": "ddd.com"
	    }


2) Delete a filtering configuration from the blacklist
 REST URL: http://localhost:8080/api/v1/ip/1 METHOD: DELETE 
“1” appended at the URL end is the id of the blacklisted url.

3) Get current blacklist configuration
 REST URL: http://localhost:8080/api/v1/ip METHOD: GET SAMPLE JSON RESPONSE:   [ { "id": 1, "hostAddress": "332.22.23.33", "hostName": "ddd.com" }, { "id": 2, "hostAddress": "332.22.23.33", "hostName": "ddd.com" } ]
 

4) Check if an IP address is present in the blacklist
 REST URL: http://localhost:8080/api/v1/ip/1 METHOD: GET SAMPLE JSON RESPONSE: true       
