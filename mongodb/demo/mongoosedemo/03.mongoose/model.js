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
// StuModel.find({name:"孙悟空"}, function(err, docs) {
//     if(!err) {
//         console.log(docs);
//     }
// });
// StuModel.create([{
//     name:"唐僧",
//     age:18,
//     gender:"male",
//     address:"大唐"
// },
// {
//     name:"猪八戒",
//     age:16,
//     gender:"male",
//     address:"高老庄"
// },
// {
//     name:"沙和尚",
//     age:18,
//     gender:"male",
//     address:"流沙河"
// }
// ],function(err) {
//     if(!err) {
//         console.log("插入数据库成功~~~");
//     }
// });
// StuModel.find({},{name:1,_id:0}, function(err, docs) {
//     if(!err) {
//         console.log(docs);
//     }
// });
// StuModel.find({}, "name -_id", function(err, docs) {
//     if(!err) {
//         console.log(docs);
//     }
// });
// StuModel.find({}, "name -_id", {skip:3,limit:1}, function(err, docs) {
//     if(!err) {
//         console.log(docs);
//     }
// });
// StuModel.findOne({}, function(err, doc) {
//     if(!err) {
//         console.log(doc.name);
//     }
// });
// StuModel.findById("5b5f2a5df011601a148c1d02", function(err, doc) {
//     if(!err) {
//         console.log(doc);
//         console.log(doc instanceof StuModel);
//     }
// });
// StuModel.update({name:"唐僧"},{$set:{age:28}},function(err) {
//     if(!err) {
//         console.log("修改数据成功~~~");
//     }
// })
// StuModel.remove({name:"大乔"},function(err) {
//     console.log("删除数据成功~~~");
// })
StuModel.count({}, function(err, count) {
    if(!err) {
        console.log(count);
    }
})