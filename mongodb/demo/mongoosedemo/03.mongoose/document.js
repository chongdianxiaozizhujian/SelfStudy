var mongoose = require("mongoose");
mongoose.connect("mongodb://127.0.0.1/mongoose_test",{useMongoClient:true});
mongoose.connection.once("open", function() {
    console.log("数据库连接成功~~~");
});
var Schema = mongoose.Schema;
var stuSchema = new Schema({
    name:String,
    age:Number,
    gender:{
        type:String,
        default:"female"
    },
    address:String
});

var StuModel = mongoose.model("student", stuSchema);
// var stu = new StuModel({
//     name:"诸葛亮",
//     age:50,
//     gender:"male",
//     address:"茅庐"
// });
// //console.log(stu);
// stu.save(function(err) {
//     if(!err) {
//         console.log("保存数据成功~~~");
//     }
// });
// StuModel.findOne({},function(err, doc) {
//     if(!err) {
//         console.log(doc);
//     }
// });
StuModel.findOne({},function(err, doc) {
    if(!err) {
        // doc.update({$set:{age:16}},function(err) {
        //     if(!err) {
        //         console.log("修改成功");
        //     }
        // });
        // doc.age = 15;
        // doc.save();
        // doc.remove(function(err) {
        //     if(!err) {
        //         console.log("删除数据成功~~~");
        //     }
        // });
        // doc = doc.toObject();
        // delete doc.address;
        // console.log(doc._id);
        // var json = JSON.stringify(doc);
        // console.log(json);
        
    }
});