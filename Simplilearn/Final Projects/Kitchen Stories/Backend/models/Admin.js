const mongoose = require('mongoose');

const Admin = mongoose.model('Admin', 
{
    user: {type: 'String'},
    pass: {type: 'String'}
});

module.exports = Admin;