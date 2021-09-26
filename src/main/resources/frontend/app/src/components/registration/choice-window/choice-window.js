import './choice-window.css';
import React from 'react';
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
        console.log(this.state.buttonId);
        return (
            <div>
            <div className="choiceContainer">
                    <div className="reg-btn-container">
                        <div className="rbox">
                        <p className='regp'>Not register yet?</p>
                        <input className={this.state.buttonId === 1? "button-reg btn-outline-light" : 
                        "button1"} onClick={() => this.setButton(1)} value="REGISTER" 
                        type="button" ref="button" />
                    </div>
    
                    <div className='rbox'>
                        <p className='regp'>Have account?</p>
                        <input className={this.state.buttonId === 2? "button-reg btn-outline-light" : 
                        "button2"} onClick={() => this.setButton(2)}  value="LOGIN" 
                        ref="button1" type="button" />
                    </div>
                    </div>
            </div>
            <div className="validationForm">
                {this.state.buttonId === 1 && <RegistrationWindow/>}
                {this.state.buttonId === 2 && <LoginWindow/>}
                {this.state.buttonId !== 1  && this.state.buttonId !== 2}
            </div>
            </div>
    
        )};
}

export default ChoiceWindow;
