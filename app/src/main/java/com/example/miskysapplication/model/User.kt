package com.example.miskysapplication.model

class User {
    var email:String=""
//    var firstname:String=""
//    var lastname: String=""
    var pass:String=""
    var confirmpass:String=""
    var userid:String=""
    constructor(email:String,pass:String,userid:String,confirmpass:String){
        this.email=email
        this.pass=pass
        this.userid=userid
//        this.firstname=firstname
//        this.lastname=lastname
        this.confirmpass=confirmpass
    }
    constructor()

}
