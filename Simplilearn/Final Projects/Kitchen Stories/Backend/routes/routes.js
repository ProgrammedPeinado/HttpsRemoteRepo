const express = require('express')
const { isValidObjectId } = require('mongoose');
const router =express.Router()

const Food = require('../models/Food.js')


const ObjectId = require('mongoose').Types.ObjectId

// api needs to be created for Get, Post, Put, Delete
// Base path for food requests consider http://localhost:4000/kitchen_stories/foods
// '/' in post refers to base path


// get api for all Food data fetch
router.get('/', (request, response) =>{
    Food.find((err, doc) => {
        if(err){
            console.log("Error in get data " + err)
        }else{
            response.send(doc)
        }
    })
})

// get api for one Food data fetch
router.get('/:id', (request, response) =>{
    if(ObjectId.isValid(request.params.id)){
        Food.findById(request.params.id, (err, doc) => {
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
// the Food object will be received in the request
router.post('/',(request, response) => {
    let food = new Food({
        name : request.body.name,
        category: request.body.category,
        tag : request.body.tag,
        price: request.body.price
    })


    food.save((err, doc) =>{
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
        Food.findByIdAndRemove(request.params.id, (err, doc) => {
            if(err){
                        console.log("Error in delete Food data " + err)
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

        let food = {
        name : request.body.name,
        category: request.body.category,
        tag : request.body.tag,
        price: request.body.price
    }
        Food.findByIdAndUpdate(request.params.id, {$set : food}, {new : true},(err, doc) => {
            if(err){
                        console.log("Error in update Food data " + err)
                    }else{
                        response.send(doc)
                    }
        })
    } else {
        return response.status(404).send("No record found")
    }
    
})

module.exports = router;