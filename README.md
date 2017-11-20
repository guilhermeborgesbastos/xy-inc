# Generic Rest Backend
> Custom Rest Application using Java 1.8, Tomcat, MongoDB and Spring MVC.

## Requirements
- Application Server: Apache Tomcat 8.5 [Download](https://tomcat.apache.org/download-80.cgi);
- JDK/JRE Java Version: 8.* [Download](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html);
- Database: MongoDB 3.4 [Download](https://docs.mongodb.com/getting-started/shell/installation/);
- Dependency Manager: Maven [Download](https://maven.apache.org/download.cgi);

## Installation and configuration
Follow these steps to setup the project
+ Clone the repository into a new folder in your machine;
    * Make sure you have the Git installed [Download](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git);
    * ```git clone https://github.com/guilhermeborgesbastos/xy-inc.git```
+ Install and configure the MongoDB;
    * [Click here to know how to install MongoDB](https://docs.mongodb.com/getting-started/shell/);
    * Create a new instance of MongoDB to the default port ```27017```;
    * Make sure you have the database named ```admin```;
+ Download and install Maven [Install](https://maven.apache.org/download.cgi);
+ Download and install Apache Tomcat  [Install](https://wiki.apache.org/tomcat/GettingStarted);
    * Make sure the Tomcat is responding in the port ```8095```;
+ Import the project into your IDE (Netbeans, Eclipse, etc);
+ Set up the project as a Maven-Project;
+ Build the project using Maven Build and run it;

## Default routes
Using these routes bellow you are able to create and manipulate any endpoint you want via RESTful.

| Path | Method |  Description |
| ------ | ------ | ------ |
| http://localhost:8095/ | _GET | List all models created |
| http://localhost:8095/ `modelId` | _GET | List all documents of an specific model |
| http://localhost:8095/ `modelId`/ `id` | _GET | Get a document by id into an specific modelId |
| http://localhost:8095/ `modelId` | _POST | Create a new document ( respecting the fields of the parent modelId ) |
| http://localhost:8095/ `modelId`/ `id` | _PUT | Edit a document ( respecting the fields of the parent modelId |
| http://localhost:8095/ `modelId`/ `id` | _DELETE | Delete a document into an specific modelId |
| http://localhost:8095/ `modelId` | _DELETE | Delete the model at all |

> `modelId` is the ObjectId of the model

## Frontend user interface
Taking into consideration that this project seeks to assist a  front-end developer to develop a simple REST Application, it was used the ```Advanced Rest Client``` ([Download](https://advancedrestclient.com/)) as a tool to help the user to build their data structure. Saving time and offering a great abstraction level:

![](https://image.ibb.co/gL2NCm/Save_New_Product_Item_2.jpg)

## Knowing more
#### What data types are supported?
This version supports into the field's type:
> String, Integer, Boolean, Double, Decimal & Date

#### How the custom models created looks like?
You can use any MongoDB Client to get access to the database to look your documents and manage the database more deeply, those are the structure of the ```user``` Model:

![](https://image.ibb.co/hiPSCm/Mongo_DB_Documents_Structure_merged.jpg?cache=false)

##### Thank you!
Fell free to open any issue discussion or contact me!

