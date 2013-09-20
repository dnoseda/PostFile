PostFile
========


to reproduce the problem just run the app with

`grails run-app`


and in the same directory in another console run:

`curl -X POST -d @small.csv localhost:8080/post/index`
