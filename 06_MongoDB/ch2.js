use my_database
db.users.find()


// 데이터베이스를 tutorial로 선정하세요.
use tutorial

//users 컬렉션에 username이 smith인 문서를 저장하세요.
db.users.insert({username:"smith"})

//users 컬렉션에 username이 jones인 문서를 저장하세요.
db.users.insertOne({username:"jones"})

db.users.count()

//앞에서 저장한 모든 문서를 출력하세요
db.users.find()

//앞에서 저장한 문서중 하나만 출력하세요
db.users.findOne()

//users 컬렉션에서 username이"jones"인 문서를 찾아서 출력하세요.
db.users.find({username:"jones"})

//AND 조건: _id와 username이 모두 일치하는 문서 조회
db.users.find({_id:ObjectId("6833c58a2d0283a86144152f"), username:"jones"})

//동일한 의미의 AND 조건(명시적 $and 연산자 사용)
db.users.find({$and:[
    {_id:ObjectId("6833c58a2d0283a86144152f")},
    {username:"jones"}
    ]})
 
// users 컬렉션에서 username이"jones" 또는 "smith"인 문서를 찾아서 출력하세요.
db.users.find({$or:[
    {username:"smith"},
    {username:"jones"}
    ]})
   
//   users 컬렉션에서 username이 smith인 문서에 country 키가 Canada 가 되도록 수정하세요.
//   앞의 문서가 올바르게 수정되었는지 확인하세요.
 db.users.update({username:"smith"},{$set:{country:"Canada"}})
 db.users.find()
 

//users컬렉션에서username이smith인문서를 {country: "Canada"}로 대체하고 확인하세요.
 db.users.replaceOne({username:"smith"},{country:"Canada"})
 
// users 컬렉션에서country가Canada인문서를 {username: "smith", country: "Canada"}로대체하고확인하세요.
 db.users.replaceOne({country:"Canada"},{username:"smith", country:"Canada"})
 
 // users 컬렉션에서username이smith인문서에서country 키를 삭제하고, 삭제여부를확인하세요.
 db.users.update({username:"smith"}, {$unset:{country:1}})
 
// 데이터베이스 현재 전체목록을 출력하세요
 show dbs
 //현재 사용중인 데이터베이스의 컬렉션 목록을 출력하세요.
 show collections
 
 
//현재 사용중인 데이터베이스와 users 컬렉션의 상태를 출력하세요
 db.status
 db.users.status
 
 
// users 컬렉션에서 username이 smith인 문서를 삭제하고, 삭제여부를확인하세요.
db.users.deleteOne({username:"smith"})
db.users.find()
//users 컬렉션의 모든문서를 삭제하고, 삭제여부를 확인하세요.
db.users.remove({})

//users 컬렉션을 삭제하세요.
db.users.drop()

//다음형태의문서20,000건을추가하세요
use test
for(let i=0;i<20000;i++){
    db.product.insert({num:i,name:'스마트폰'+i})
}
//product 컬렉션의전체문서수를출력하세요.
db.product.find()

//product 컬렉션의문서를num의내림차순으로정렬하여출력하세요.
db.product.find().sort({num:-1})
//상위 10건
db.product.find().sort({num:-1}).limit(10)

//product 컬렉션의 문서를 num의 내림차순으로 정렬한 상태에서 다음을 처리하세요.
//한 페이지당 10건씩, 6페이지에 해당하는 문서를 출력
db.product.find().sort({num:-1}).skip(5*10).limit(10)

//product 컬렉션에서 num이 15미만이거나 1 =9995 초과인것을출력하세요.
db.product.find({
    $or:[
    {num:{$lt:15}},{num:{$gt:19995}}
    ]
})

//product컬렉션에서name이'스마트폰10', '스마트폰 100', '스마트폰 1000' 중에 하나이면 출력
 db.product.find({name:{$in:['스마트폰10','스마트폰100','스마트폰1000']}})
 
// product 컬렉션에서num이5보다작은문서를출력하는데, name만출력하세요.
db.product.find({num:{$lt:5}},{name:1,_id:0})







//심화

use tutorial
db.users.insert({username:"smith"})
db.users.find()
 db.users.update({username:"smith"},
 {
     $set:{
         favorites:{
             cicties:["Chicago", "Chaeyenne"],
             movies:["Casablanca", "For a Few Dollars More", "The Sting"]
         }
     }
 })
 db.users.insert({username:"jones"})
 db.users.update({username:"jones"},
     {
     $set:{
         favorites:{
             movies:["Casablanca", "Rocky"]
         }
     }
 })
 db.users.find({"favorites.movies":"Casablanca"}).pretty()
 db.users.updateMany({"favorites.movies":"Casablanca"},{$addToSet:{"favorites.movies":"The Maltese Falcon"}},{upsert:false})
 
 for(let i=0;i<20000;i++){
     db.number.insert({num:i})
 }
 db.number.count()
 db.number.find({num:{$gte:20,$lte:25}})
 db.number.createIndex({num:1})
 db.number.getIndexes()