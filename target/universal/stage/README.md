# horsleyparish.co.uk README
This is a webservice application serving the community of Horsley Parish, Gloucerstershire.

The application is built on the [Play 2 Framework](https://www.playframework.com/), which is an open-source, well-supported and widely documented technology. One of the
benefits of developing on this framework is portability, since it is very easy to get an instance of the application running on any platform (e.g. on a developer's Windows desktop
or Mac), and is also easy to deploy to Cloud-based services like Heroku.

There are three main components to the application:

### The [horsleyparish](horsleyparish.co.uk) Web Site
This is written in AngularJS and JavaScript. The majority of the web site code can be found in the /public folder in the source repository.

### A RESTful Web Service
This is written in Scala and Java. It sits between the website and the database, and is the conduit through which all database data flows. It enables the web site to be de-coupled from the
database technology, making it easier to integrate and change services in the future.

 ### A [PostgreSQL](https://www.postgresql.org/) database
This is an open-source database, that can be freely downloaded and used.

## Getting started

This application is accessible to the public and can be downloaded from bitbucket on run on a local machine.

### Local development on OSX
#### Database Setup
- Install PostgreSQL 9.3 Postgres.app is the easiest way: [postgresapp.com](http://postgresapp.com/)
- [PostgreSQL full documentation](http://www.postgresql.org/docs/9.3/interactive/)
- Run `psql`
- Set up a development database, note the underscores:
`CREATE DATABASE horsley_parish;`
- Confirm the database has been created by looking at the database list
`\l`


#### Run the application
- In the root folder of the repo:
`activator run`
- In a browser, open localhost:9000. If no folder for conf/evolutions/default exists, do not worry. On first request in browser, slick will automatically inspect the models, and generate a 1.sql file in conf/evolutions/default. This initial file is a complete schema of the application.

#### Development
##### Common database tasks
- If you need to connect to the database to inspect it or run sql:
`\c hosrley_parish;`
and if you are currently logged into osx as "johnsmith" you should see
`You are now connected to database "hosrley_parish" as user "johnsmith".`

- To view users created in the user table using psql:
1. Open psql, connect to the database:
`\c hosrley_parish;`
2. View user table data:
`SELECT * FROM "user";`

Note: "user" is also a keyword in PostgreSQL, if you enter this command without quotation marks, it will not select from the play_heroku_seed user table, but instead will output from PostgreSQL's internal database users table and you will get something like this:

```
hosrley_parish=# SELECT * FROM user;
 current_user
--------------
 Mashallah
(1 row)
```

- To reset your local database:
`DROP DATABASE hosrley_parish;`
`CREATE DATABASE hosrley_parish;`
and run the application


##### Configuring the database

Run the application, visit localhost:9000

A 1.sql file reflecting the current state of the application models will be auto-generated by slick, auto-applied by play, and now running. If a 1.sql file was not generated, you have likely introduced a change to the model that slick cannot interpret.

Slick is currently unable to generate incremental database evolution files to make those changes. It can only generate a complete snapshot of the application models at any point. If you want to introduce incremental changes to the models, you will need to manually write the SQL database evolutions.
### Procfile
The app will run without a Procfile, as the necessary settings have been put in application.conf, are read by Heroku's default Procfile settings in the scala buildpack and are applied.

The Procfile is included in this app for reference and best practices.Heroku reads the Procfile and attempts to initialize the app in build.sbt with the same name.

Procfile:
```
web: target/universal/stage/bin/play-heroku-seed
```
build.sbt:

```
name := """horsleyparish""
```
If you modify the application name in the Procfile, make sure you update the application name in build.sbt. If the names do not match, the web process will fail to start on Heroku.

