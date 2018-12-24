
API call:
	https://localhost:8443/search?term=list

API call from command line:

	$ curl localhost:8443/search?term=ArrayDeque && echo
	[{"id":4446,"term":"ArrayDeque","path":"java/util/ArrayDeque.html"}]
	
	$ curl localhost:8443/search?term=Array | json_reformat | less


connecting to postgresql:

	$ psql -d javadocs -U app_user -W
  
To configure spring project to use https:

    Create keystore:
    
        $ keytool -genkey -alias javadocsprojectcert -keyalg RSA -keystore ~/.javadocsprojectcertkeystore
        
    Above creates a keystore called .javadocsprojectcertkeystore and within that keystore the alias 
    javadocsprojectcert.
    I copied .javadocsprojectcertkeystore to the resources folder and then change the name to 
    javadocsprojectcertkeystore (removing the leading dot so it could be viewed in the eclipse project).
    (Don't forget to refresh the folder so that it's visible to the project.) 
    I use the same password for each (prompted for within interactive mode).
   
				
Temporarily load firefox extension:

	about:debugging 
	load mainfest.json
	


try using ports 80/443 -- UPDATE: NOT NEEDED
	there are restrictions to using ports under 1000(?), so you must use the conventional higher ports
	(eg 8080 and 8443), and then map them 80 and 443 using iptables' NAT feature
	
		sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
		sudo iptables -t nat -I OUTPUT -p tcp -d 127.0.0.1 --dport 80 -j REDIRECT --to-ports 8080
	
        sudo iptables -t nat -A PREROUTING -p tcp --dport 443 -j REDIRECT --to-port 8443
        sudo iptables -t nat -I OUTPUT -p tcp -d 127.0.0.1 --dport 443 -j REDIRECT --to-ports 8443

		# to list tables
		sudo iptables -L -n -v -t nat | less

	source:
	   https://stackoverflow.com/questions/33703965/spring-boot-running-app-on-port-80
       https://stackoverflow.com/a/33704078/724199
       
