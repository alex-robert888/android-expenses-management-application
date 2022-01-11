const bcrypt    = require("bcrypt");
const jwt       = require("jsonwebtoken");
const MongoUser = require("../database/models/mongoUser");

interface IUser {
  id?: string,
  name?: string,
  email?: string,
  password?: string
}

class User {
  props: IUser;
  mongoModel: any;
  
  constructor(props: IUser) {
    if(props.password!.length < 6) 
      throw Error("Password should be at least 6 characters long.")
   
    this.props = props;
    this.initMongoModel();
  }

  initMongoModel() {
    return new MongoUser(this.props);
  }

  async init() {
    this.props.password = await this.hashPassword();
    return this;
  }

  async authenticate(): Promise<string> {
    this.validateEmailAndPassword();
    const accessToken = jwt.sign(this.props, process.env.ACCESS_TOKEN_SECRET);
    return accessToken;
  }
  
  private async hashPassword(): Promise<string> {
    const salt = await bcrypt.genSalt(10);
    const hashedPassword = await bcrypt.hash(this.props.password, salt);
    return hashedPassword;
  }

  private async validateEmailAndPassword() {
    this.mongoModel = await MongoUser.findOne({ email: this.props.email }).orFail();
    await bcrypt.compare(this.props.password, this.mongoModel.password);
  }
}

module.exports = User;