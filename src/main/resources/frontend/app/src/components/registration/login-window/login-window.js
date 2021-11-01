import './login-window.css';
import React, {Component} from 'react';
import axios from "axios";

class LoginWindow extends Component{
    constructor(props) {
        super(props);

        this.state ={
            username:'',
            password:''
        }

        this.handleSubmit = this.handleSubmit.bind(this);
        this.updateUsername = this.updateUsername.bind(this);
        this.updatePassword = this.updatePassword.bind(this);
    }


    updateUsername(event){
        this.setState({username : event.target.value});
    }
    updatePassword(event){
        this.setState({password: event.target.value});
    }

    handleSubmit(){
        console.log('Your input username is: ' + this.state.username);
        console.log('Your input password is: ' + this.state.password);
        axios.post('http://127.0.0.1:8080/auth/user',
            {login: this.state.username, password: this.state.password},
            {headers: {
                    'Content-Type': 'application/json'
                }}

            )
            .then((response) =>{
                console.log(response.data);
                window.location.href='/feed';


            })
            .catch((error) => {
                console.log(error);
                console.log("popavsia");
                this.validateResult();
            })
    }

    validateResult = () =>{
            return (
                <div className="loginValidation">
                    <p>
                        WRONG LOGIN OR PASSWORD!
                    </p>
                </div>
            );
    }

    render() {
        return (
            <div className="login-flex">
                <form>
                    <div className="login-container">

                        <div className="authLine">
                            <div className="authContent">
                                <p>ENTER LOGIN</p>
                                <input type="text" onChange={this.updateUsername}/>
                            </div>
                            <div className="authContent">
                                <p>ENTER PASSWORD</p>
                                <input type="text" onChange={this.updatePassword}/>
                            </div>
                        </div>
                        <button type="button" onClick={this.handleSubmit} className='srbtn'>CONTINUE</button>
                    </div>
                </form>
            </div>
        );
    }
}

export default LoginWindow;