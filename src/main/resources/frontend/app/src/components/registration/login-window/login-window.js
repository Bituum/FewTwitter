import './login-window.css';
import React from 'react';

const LoginWindow = () => {
    return (
        <div className="login-flex">
            <div className="login-container">

                <div className="authLine">
                    <div className="authContent">
                        <p>ENTER LOGIN</p>
                        <input type="text" />
                    </div>
                    <div className="authContent">
                        <p>ENTER PASSWORD</p>
                        <input type="password" />
                    </div>
                    </div>
                    <button onClick={event =>  window.location.href='/feed'} className='srbtn'>CONTINUE</button>           
            </div>
        </div>
    );
}

export default LoginWindow;