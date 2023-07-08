const express = require('express');
const { isValidObjectId } = require('mongoose');
const router = express.Router()

const Employee = require('../models/employee.js')
const ObjectId = require('mongoose').Types.ObjectId

// api needs to be created for Get, Post, Put, Delete
// Base path for employee requests consider http://localhost:3000/employees
// '/' in post refers to base path


// get api for all employee data fetch
router.get('/', (request, response) =>{
    Employee.find((err, doc) => {
        if(err){
            console.log("Error in get data " + err)
        }else{
            response.send(doc)
        }
    })
})

// get api for one employee data fetch
router.get('/:id', (request, response) =>{
    if(ObjectId.isValid(request.params.id)){
        Employee.findById(request.params.id, (err, doc) => {
            if(err){
                        console.log("Error in get data " + err)
                    }else{
                        response.send(doc)
                    }
        })
    } else {
        return response.status(404).send("No record found")
    }
    
})


// Post api as unless data is posted nothing can be retrieved
// the data received from angular application will be available in request 
// the employee object will be received in the request
router.post('/',(request, response) => {
    let emp = new Employee({
        name : request.body.name,
        designation: request.body.designation,
        dept : request.body.dept
    })


    emp.save((err, doc) =>{
        if(err){
            console.log("Error in post data " + err)
        }else{
            response.send(doc)
        }
    })
})

// delete api 
router.delete('/:id', (request, response) =>{
    if(ObjectId.isValid(request.params.id)){
        Employee.findByIdAndRemove(request.params.id, (err, doc) => {
            if(err){
                        console.log("Error in delete employee data " + err)
                    }else{
                        response.send(doc)
                    }
        })
    } else {
        return response.status(404).send("No record found")
    }
    
})

// put api 
router.put('/:id', (request, response) =>{
    if(ObjectId.isValid(request.params.id)){

        let emp = {
        name : request.body.name,
        designation: request.body.designation,
        dept : request.body.dept
    }
        Employee.findByIdAndUpdate(request.params.id, {$set : emp}, {new : true},(err, doc) => {
            if(err){
                        console.log("Error in update employee data " + err)
                    }else{
                        response.send(doc)
                    }
        })
    } else {
        return response.status(404).send("No record found")
    }
    
})

module.exports = router;