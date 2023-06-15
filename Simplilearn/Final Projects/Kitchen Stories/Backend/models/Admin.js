const mongoose = require('mongoose');

const Admin = mongoose.model('Admin', 
{
    user: {type: 'string'},
    pass: {type: 'string'}
});

module.exports = Admin;