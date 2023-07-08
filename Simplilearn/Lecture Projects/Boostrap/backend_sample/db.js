cont mongoose = require('mongoose')



mongoose.connect('mongoose://localhost:27017/[databasename]', (err)=>
{
if(!err)
{
    console.log('DB Connection Successful.')
}
else
{
    console.log('Connection to DB has been unsuccessful. \n'+err)
}
}
)

module.exports = mongoose;