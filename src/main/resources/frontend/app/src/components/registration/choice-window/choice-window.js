import React from 'react';
import './choice-window.css';
import RegistrationWindow from '../registration-window/registration-window';
import LoginWindow from '../login-window/login-window';


class ChoiceWindow extends React.Component {
    constructor(){
        super();
        this.state = {
            buttonId: null
        }
        this.setButton = this.setButton.bind(this);
    }
    setButton(id){
        this.setState({buttonId: id});
    }


    render(){
        return (
            <div className="authorization_item">
                <div className="padding_for_box">
                    <div className="border_for_box">
                        <div className="auth_box">
                            <h2>Have account?</h2>
                                <div className="metadata">
                                    <label htmlFor="email-label">Email</label>
                                    <input type="text" id="email-label"/>
                                    <label htmlFor="password-label">Password</label>
                                    <input type="password" id="password-label"/>
                                </div>
                                <div className="choice_buttons">
                                    <button onClick={() => this.setButton(1)}>Enter</button>
                                    <button onClick={() => this.setButton(2)}>Registration</button>
                                </div>
                        </div>
                    </div>
                </div>
                <div className="validationForm">
                    {this.state.buttonId === 2 && <RegistrationWindow/>}
                    {this.state.buttonId === 1 && <LoginWindow/>}
                </div>
            </div>

    
        )};
}

export default ChoiceWindow;
