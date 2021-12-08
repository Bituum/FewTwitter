import './registration-window.css'
import React, {Component} from 'react';
import axios from "axios";

class RegistrationWindow extends Component{
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
        axios.post('http://127.0.0.1:8080/user',
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
    render() {
        return(
            <div className="login_flex">
                <div className="login_container">
                    <div className="authLine">
                        <h2>Registration</h2>
                        <div className="authContent">
                            <p>Enter email</p>
                            <input onChange={this.updateUsername} type="text" />
                        </div>
                        <div className="authContent">
                            <p>Enter password</p>
                            <input onChange={this.updatePassword}  type="password" />
                        </div>
                    </div>
                    <div className="btnvalidation">
                        <button type="button" onClick={this.handleSubmit} className='btnval'>Continue</button>
                    </div>
                </div>
            </div>
        );
    }
}

export default RegistrationWindow;