import { Request, Response, NextFunction } from 'express';
const express = require("express");
const User = require("../models/user");
const router = express.Router();

router.post('/login', async (req: Request, res: Response, next: NextFunction) => {
  try {
    const user        = await new User(req.body).init();
    const accessToken = await user.authenticate();

    res.json({
      message: "User successfully logged in.",
      data: {
        accessToken: accessToken
      }
    });
  }
  catch(error) {
    next(error);
  }
})

router.post('/register', async (req: Request, res: Response, next: NextFunction) => {
  try {
    const user      = await new User(req.body).init();
    const mongoUser = user.initMongoModel();
    await mongoUser.save();
    
    res.status(201).send("Signed up successfully.");
  } 
  catch(error) {
    console.error(error);
    next(error);
  }
})


module.exports=router;