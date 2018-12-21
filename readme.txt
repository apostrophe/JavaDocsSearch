
21/12/2018 13:25:57 create a search API and tie it to a firefox search

2018-12-21 13:26:54 configure  database

2018-12-21 13:52:26 connect to database

2018-12-21 14:46:04 rest api now working

example API call:

	$ curl localhost:8080/search?term=ArrayDeque && echo
	[{"id":4446,"term":"ArrayDeque","path":"java/util/ArrayDeque.html"}]
	$ 


connecting to postgresql:

	$ psql -d javadocs -U app_user -W

/home/bschilke/Documents/development/platforms/firefox extensions



