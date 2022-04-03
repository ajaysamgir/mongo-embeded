## Spring Data MongoDB

- MongoDB is lightweight quickly scale and handle large amount of data.
- MongoDB also fits nicely with developing REST Api's using spring
- Instead of using concepts like Tables, Rows, Columns mongodb uses Databases, Collections and Documents
- Spring Data MongoDB is part of Spring Data umbrella project
- Create Collections using shells, java etc.
- With NoSQL you dont need to explicitly specify any relationship in documents. List consider as "Many" and field is consider as one entity.
- Document relation manage with embeded document or reference document.

### MongoReposotory
- This is simple interface of repository patterns which contains generic methods of MongoDB operation.
- Methods
    - insert()
    - findAll()
    - findById()
    - delete()
    - find()

### MongoTemplate
- This class follows standard template pattern
- Easy to performs CRUD operations
