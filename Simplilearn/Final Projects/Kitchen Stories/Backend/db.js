const mongoose = require('mongoose');

// the parameters to be specified for database connectivity.
// first argument is url
// the url for database : mongodb://localhost:27017/kitchen_stories
// meanDB can be created or it will be created automatically when the data is posted

// second argument is callback
mongoose.connect('mongodb://127.0.0.1:27017/kitchen_stories', (err)=>{
    if(!err){
        console.log('DB Connection Successful')
    } else{
        console.log('Error in Connection ' + err)
    }
})

module.exports = mongoose;