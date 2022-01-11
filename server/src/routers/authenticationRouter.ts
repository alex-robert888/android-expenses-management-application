import { Request, Response, NextFunction } from 'express';
const express = require("express");
const router = express.Router();

router.post('/login', (req: Request, res: Response, next: NextFunction) => {
  res.send('Log in.')
})

router.post('/register', (req: Request, res: Response, next: NextFunction) => {
  res.send('Register.')
})

module.exports=router;