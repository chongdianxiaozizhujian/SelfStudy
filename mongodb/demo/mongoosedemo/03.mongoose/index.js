require("./tools/conn_mongo");
// var Student = require("./models/student").model;
var Student = require("./models/student");
Student.find({}, function(err,docs) {
    if(!err) {
        console.log(docs);
    }
})
console.log(Student);