
21/12/2018 13:25:57 create a search API and tie it to a firefox search

2018-12-21 13:26:54 configure  database

2018-12-21 13:52:26 connect to database

2018-12-21 14:46:04 rest api now working

example API call:

	$ curl localhost:8080/search?term=ArrayDeque && echo
	[{"id":4446,"term":"ArrayDeque","path":"java/util/ArrayDeque.html"}]
	$ 
	
	
	$ curl localhost:8080/search?term=Array | json_reformat | less


connecting to postgresql:

	$ psql -d javadocs -U app_user -W

/home/bschilke/Documents/development/platforms/firefox extensions


try using port 80
	there are restrictions to using port 80
		https://stackoverflow.com/questions/33703965/spring-boot-running-app-on-port-80
			answer: https://stackoverflow.com/a/33704078/724199
				sudo iptables -t nat -A PREROUTING -p tcp --dport 80 -j REDIRECT --to-port 8080
				sudo iptables -t nat -I OUTPUT -p tcp -d 127.0.0.1 --dport 80 -j REDIRECT --to-ports 8080
