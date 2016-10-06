# HorsleyParish.co.uk README
This is a webservice application serving the community of Horsley Parish, Gloucerstershire.

It provides a web interface for members of the public and a RESTFUL webservice for use by application clients. It is a Play Framework application with a PostgreSQL database. It is designed to run on Heroku, with manipulation handled by Slick.

## Getting started

This application is accessible to the public and can be downloaded from bitbucket on run on a local machine.

### Local development on OSX
#### Database Setup
- Install PostgreSQL 9.3 Postgres.app is the easiest way: [postgresapp.com](http://postgresapp.com/)
- [PostgreSQL full documentation](http://www.postgresql.org/docs/9.3/interactive/)
- Run `psql`
- Set up a development database, note the underscores:
`CREATE DATABASE play_heroku_seed;`
- Confirm the database has been created by looking at the database list
`\l`


#### Run the application
- In the root folder of the repo:
`activator run`
- In a browser, open localhost:9000. If no folder for conf/evolutions/default exists, do not worry. On first request in browser, slick will automatically inspect the models, and generate a 1.sql file in conf/evolutions/default. This initial file is a complete schema of the application.

#### Development
##### Common database tasks
- If you need to connect to the database to inspect it or run sql:
`\c play_heroku_seed;`
and if you are currently logged into osx as "johnsmith" you should see
`You are now connected to database "play_heroku_seed" as user "johnsmith".`

- To view users created in the user table using psql:
1. Open psql, connect to the database:
`\c play_heroku_seed;`
2. View user table data:
`SELECT * FROM "user";`

Note: "user" is also a keyword in PostgreSQL, if you enter this command without quotation marks, it will not select from the play_heroku_seed user table, but instead will output from PostgreSQL's internal database users table and you will get something like this:

```
play_heroku_seed=# SELECT * FROM user;
 current_user
--------------
 Mashallah
(1 row)
```

- To reset your local database:
`DROP DATABASE play_heroku_seed;`
`CREATE DATABASE play_heroku_seed;`
and run the application


##### Introducing model changes to the database
If you modify the models, and you do not care about current production data (still before launch):

1. Stop the application
2. Delete conf/evolutions/default/1.sql
3. Open psql, reset the database by doing the following:
`DROP DATABASE play_heroku_seed;`
`CREATE DATABASE play_heroku_seed;`
4. Run the application, visit localhost:9000

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
name := """play-heroku-seed"""
```
If you modify the application name in the Procfile, make sure you update the application name in build.sbt. If the names do not match, the web process will fail to start on Heroku.


### Requests for contribution
- Documentation and tips for readme
- Model improvements/refinement
